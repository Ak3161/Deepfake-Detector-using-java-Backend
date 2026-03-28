package com.example.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.SightengineResponseDTO;

@Service
public class SightengineService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${sightengine.api.user}")
	private String apiUser;
	
	@Value("${sightengine.api.secret}")
	private String apiSecret;

	@Value("${sightengine.api.url}")
	private String apiUrl;
	
	public SightengineResponseDTO analyzeMedia(MultipartFile file) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("api_user", apiUser);
		body.add("api_secret", apiSecret);
		body.add("models", "deepfake,genai");
		
		ByteArrayResource fileResource = new ByteArrayResource(file.getBytes()) {
		    @Override
		    public String getFilename() {
		        return file.getOriginalFilename();
		    }
		};
		body.add("media", fileResource);
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = 
			    new HttpEntity<>(body, headers);
		
		ResponseEntity<SightengineResponseDTO> response = restTemplate.exchange(
			    apiUrl,
			    HttpMethod.POST,
			    requestEntity,
			    SightengineResponseDTO.class
			);
		
		return response.getBody();
	}
	
}
