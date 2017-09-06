package com.omp.photo.domain;

public class PhotoFileDM {
	
	private String orgName; //사용자가 올린 파일 이름
	private String systemName; //서버에 실제 저장된 파일 이름
	private long fileLength; //파일 사이즈
	private String filePath; //파일 경로
	private int boardNo; //파일 게시판 번호
	private int fileNo;  //파일 번호
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public long getFileLength() {
		return fileLength;
	}
	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	
}
