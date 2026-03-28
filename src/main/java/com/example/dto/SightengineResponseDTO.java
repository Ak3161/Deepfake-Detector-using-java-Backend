package com.example.dto;

public class SightengineResponseDTO {
	private String status;
	private TypeInfo type;
	private DeepfakeInfo deepfake;
	private FaceInfo face;
	
	// regenerate getter → getGenai()

	public String getStatus() {
		return status;
	}

	

	public void setStatus(String status) {
		this.status = status;
	}

	public TypeInfo getType() {
		return type;
	}

	public void setType(TypeInfo type) {
		this.type = type;
	}

	public DeepfakeInfo getDeepfake() {
		return deepfake;
	}

	public void setDeepfake(DeepfakeInfo deepfake) {
		this.deepfake = deepfake;
	}

	public FaceInfo getFace() {
		return face;
	}

	public void setFace(FaceInfo face) {
		this.face = face;
	}

	public static class TypeInfo {
	    private Double ai_generated;

	    public Double getAi_generated() {
	        return ai_generated;
	    }

	    public void setAi_generated(Double ai_generated) {
	        this.ai_generated = ai_generated;
	    }
	}

	public static class DeepfakeInfo {
		private Double score;

		public Double getScore() {
			return score;
		}

		public void setScore(Double score) {
			this.score = score;
		}
	}
	
	public static class FaceInfo{
	private ManipulationInfo manipulation;
	
	public ManipulationInfo getManipulation() { return manipulation; }
    public void setManipulation(ManipulationInfo manipulation) { this.manipulation = manipulation; }
	}
	
	public static class ManipulationInfo {
        private Double score;

        public Double getScore() { return score; }
        public void setScore(Double score) { this.score = score; }
    }

}
