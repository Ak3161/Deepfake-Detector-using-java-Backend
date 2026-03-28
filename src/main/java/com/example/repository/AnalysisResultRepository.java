package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.AnalysisResult;

public interface AnalysisResultRepository  extends JpaRepository<AnalysisResult, Long>{

}
