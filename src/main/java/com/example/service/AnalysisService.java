package com.example.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.AnalysisResponseDTO;
import com.example.dto.SightengineResponseDTO;
import com.example.model.AnalysisResult;
import com.example.repository.AnalysisResultRepository;

@Service
public class AnalysisService {

	@Autowired
	private SightengineService sightengineService;

	@Autowired
	private GeminiService geminiService;

	@Autowired
	private AnalysisResultRepository repository;

	public AnalysisResponseDTO analyzeAndSave(MultipartFile file) throws IOException {

		// Step 1 - Call Sightengine
		SightengineResponseDTO sightengineResult = sightengineService.analyzeMedia(file);

		// Step 2 - Extract scores safely
		Double aiScore = sightengineResult.getType() != null &&
			    sightengineResult.getType().getAi_generated() != null ?
			    sightengineResult.getType().getAi_generated() : 0.0;

		Double deepfakeScore = sightengineResult.getDeepfake() != null &&
			    sightengineResult.getDeepfake().getScore() != null ?
			    sightengineResult.getDeepfake().getScore() : 0.0;

		Double faceScore = 0.0;

		// Step 3 - Call Gemini
		String explanation = geminiService.explainResult(aiScore, deepfakeScore, faceScore);

		// Step 4 - Decide verdict
		String verdict;
		if (aiScore > 0.7 || deepfakeScore > 0.7) {
			verdict = "LIKELY_FAKE";
		} else if (aiScore > 0.4 || deepfakeScore > 0.4) {
			verdict = "POSSIBLY_FAKE";
		} else {
			verdict = "LIKELY_REAL";
		}

		// Step 5 - Save to DB
		AnalysisResult result = new AnalysisResult();
		result.setFilename(file.getOriginalFilename());
		result.setFileType(file.getContentType());
		result.setAiGeneratedScore(aiScore);
		result.setDeepfakeScore(deepfakeScore);
		result.setFaceManipulationScore(faceScore);
		result.setVerdict(verdict);
		result.setGeminiExplanation(explanation);
		result.setAnalyzedAt(LocalDateTime.now());

		AnalysisResult savedResult = repository.save(result);

		// Step 6 - Build and return response DTO
		AnalysisResponseDTO response = new AnalysisResponseDTO();
		response.setId(savedResult.getId());
		response.setFilename(savedResult.getFilename());
		response.setFileType(savedResult.getFileType());
		response.setAiGeneratedScore(savedResult.getAiGeneratedScore());
		response.setDeepfakeScore(savedResult.getDeepfakeScore());
		response.setFaceManipulationScore(savedResult.getFaceManipulationScore());
		response.setVerdict(savedResult.getVerdict());
		response.setGeminiExplanation(savedResult.getGeminiExplanation());
		response.setAnalyzedAt(savedResult.getAnalyzedAt());

		return response;
	}

	public List<AnalysisResult> getAllHistory() {
		return repository.findAll();
	}

	public AnalysisResult getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
