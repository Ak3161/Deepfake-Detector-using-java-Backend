package com.example.dto;

import java.time.LocalDateTime;

public class AnalysisResponseDTO {

	private Long id;

	private String filename;

	private String fileType;

	private Double aiGeneratedScore;

	private Double deepfakeScore;

	private String verdict;

	private String geminiExplanation;

	private LocalDateTime analyzedAt = LocalDateTime.now();

	private Double faceManipulationScore;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Double getAiGeneratedScore() {
		return aiGeneratedScore;
	}

	public void setAiGeneratedScore(Double aiGeneratedScore) {
		this.aiGeneratedScore = aiGeneratedScore;
	}

	public Double getDeepfakeScore() {
		return deepfakeScore;
	}

	public void setDeepfakeScore(Double deepfakeScore) {
		this.deepfakeScore = deepfakeScore;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	public String getGeminiExplanation() {
		return geminiExplanation;
	}

	public void setGeminiExplanation(String geminiExplanation) {
		this.geminiExplanation = geminiExplanation;
	}

	public LocalDateTime getAnalyzedAt() {
		return analyzedAt;
	}

	public void setAnalyzedAt(LocalDateTime analyzedAt) {
		this.analyzedAt = analyzedAt;
	}

	public Double getFaceManipulationScore() {
		return faceManipulationScore;
	}

	public void setFaceManipulationScore(Double faceManipulationScore) {
		this.faceManipulationScore = faceManipulationScore;
	}

	public AnalysisResponseDTO(Long id, String filename, String fileType, Double aiGeneratedScore, Double deepfakeScore,
			String verdict, String geminiExplanation, LocalDateTime analyzedAt, Double faceManipulationScore) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileType = fileType;
		this.aiGeneratedScore = aiGeneratedScore;
		this.deepfakeScore = deepfakeScore;
		this.verdict = verdict;
		this.geminiExplanation = geminiExplanation;
		this.analyzedAt = analyzedAt;
		this.faceManipulationScore = faceManipulationScore;
	}
	public AnalysisResponseDTO() {
	    // empty
	}

}
