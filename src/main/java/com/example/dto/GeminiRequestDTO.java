package com.example.dto;

import java.util.List;

public class GeminiRequestDTO {

    private List<ContentDTO> contents;

    public List<ContentDTO> getContents() {
        return contents;
    }

    public void setContents(List<ContentDTO> contents) {
        this.contents = contents;
    }

}