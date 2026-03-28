package com.example.service;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ContentDTO;
import com.example.dto.GeminiRequestDTO;
import com.example.dto.GeminiResponseDTO;
import com.example.dto.PartDTO;

@Service
public class GeminiService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${gemini.api.key}")
	private String apiKey;

	@Value("${gemini.api.url}")
	private String apiUrl;

	public String explainResult(Double aiScore, Double deepfakeScore, Double faceScore) {
		String prompt = "Analyze these AI detection scores and explain in simple English:\n" + "AI Generated Score: "
				+ aiScore + "\n" + "Deepfake Score: " + deepfakeScore + "\n" + "Face Manipulation Score: " + faceScore
				+ "\n" + "Score range is 0 to 1. Higher means more likely fake.\n"
				+ "Give a clear simple explanation whether this media is likely real or fake.";
		
		try {
			PartDTO part = new PartDTO();
			part.setText(prompt);
			
			ContentDTO content = new ContentDTO();
			content.setParts(List.of(part));
			
			GeminiRequestDTO request = new GeminiRequestDTO();
			request.setContents(List.of(content));
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<GeminiRequestDTO> requestEntity = new HttpEntity<>(request, headers);
			String urlWithKey = apiUrl + "?key=" + apiKey;
			
			ResponseEntity<GeminiResponseDTO> response = restTemplate.exchange(
				    urlWithKey,
				    HttpMethod.POST,
				    requestEntity,
				    GeminiResponseDTO.class
				);
			
			if (response.getBody() != null 
				&& response.getBody().getCandidates() != null 
				&& !response.getBody().getCandidates().isEmpty()
				&& response.getBody().getCandidates().get(0).getContent() != null
				&& response.getBody().getCandidates().get(0).getContent().getParts() != null
				&& !response.getBody().getCandidates().get(0).getContent().getParts().isEmpty()) {
				
				return response.getBody()
					    .getCandidates().get(0)
					    .getContent()
					    .getParts().get(0)
					    .getText();
			} else {
				System.err.println("Gemini Response was empty or blocked by safety settings.");
			}
		} catch (Exception e) {
			System.err.println("Error calling Gemini API: " + e.getMessage());
		}
		
		// Fallback logic if API call fails (e.g., Timeout, Missing Key, Safety constraints)
		String level;
		if (aiScore > 0.7 || deepfakeScore > 0.7) {
			level = "highly likely to be AI generated or fake";
		} else if (aiScore > 0.4 || deepfakeScore > 0.4) {
			level = "possibly manipulated or AI assisted";
		} else {
			level = "likely authentic and real";
		}

		return "Based on analysis - AI Generated Score: " + aiScore +
		       ", Deepfake Score: " + deepfakeScore +
		       ". This media is " + level + ".";
	}
}
