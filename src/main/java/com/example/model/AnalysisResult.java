package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "analysis_results")
public class AnalysisResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "filename", nullable = false)
	private String filename;
	@Column(nullable = false)
	private String fileType;
	@Column(nullable = false)
	private Double aiGeneratedScore;
	@Column(nullable = false)
	private Double deepfakeScore;
	@Column(nullable = false)
	private String verdict;
	@Column(nullable = false)
	private String geminiExplanation;
	@Column(nullable = false)
	private LocalDateTime analyzedAt = LocalDateTime.now();
	@Column(nullable = false)
	private Double faceManipulationScore;

	public Double getFaceManipulationScore() {
		return faceManipulationScore;
	}

	public void setFaceManipulationScore(Double faceManipulationScore) {
		this.faceManipulationScore = faceManipulationScore;
	}

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

	public AnalysisResult(Long id, String filename, String fileType, Double aiGeneratedScore, Double deepfakeScore,
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

	public void setAnalyzedAt(LocalDateTime analyzedAt) {
		this.analyzedAt = analyzedAt;
	}

	public AnalysisResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
