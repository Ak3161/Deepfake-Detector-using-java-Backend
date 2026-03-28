package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AnalysisResult;
import com.example.service.AnalysisService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
	@Autowired
	private AnalysisService analysisService;

	@GetMapping
	public ResponseEntity<List<AnalysisResult>> getAllHistory() {
	    return ResponseEntity.ok(analysisService.getAllHistory());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnalysisResult> getById(@PathVariable Long id) {
	    return ResponseEntity.ok(analysisService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
	    analysisService.deleteById(id);
	    return ResponseEntity.ok("Deleted successfully");
	}
}

