package com.tracker.supply.model;

import java.util.HashSet;

public class UploadFileResponse {
	
	 private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;
	    private HashSet<String> recommendedSkill;

	    public UploadFileResponse(String fileName, String fileDownloadUri, HashSet<String> recommendedSkill, String fileType, long size) {
	        this.fileName = fileName;
	        this.fileDownloadUri = fileDownloadUri;
	        this.fileType = fileType;
	        this.size = size;
	        this.recommendedSkill=recommendedSkill;
	    }

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileDownloadUri() {
			return fileDownloadUri;
		}

		public void setFileDownloadUri(String fileDownloadUri) {
			this.fileDownloadUri = fileDownloadUri;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public HashSet<String> getRecommendedSkill() {
			return recommendedSkill;
		}

		public void setRecommendedSkill(HashSet<String> recommendedSkill) {
			this.recommendedSkill = recommendedSkill;
		}

}
