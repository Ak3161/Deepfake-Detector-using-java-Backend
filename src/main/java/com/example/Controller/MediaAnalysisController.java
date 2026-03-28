package com.example.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.AnalysisResponseDTO;
import com.example.service.AnalysisService;

@RestController
@RequestMapping("/api/analysis")
public class MediaAnalysisController {
	@Autowired
	private AnalysisService analysisService;

	@PostMapping("/upload")
	public ResponseEntity<AnalysisResponseDTO> uploadMedia(
	        @RequestPart("file") MultipartFile file) throws IOException {

	    AnalysisResponseDTO response = analysisService.analyzeAndSave(file);
	    return ResponseEntity.ok(response);
	}
}
