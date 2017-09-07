package com.omp.dictionary.domain;

public class VideoDM {
	private int no;
	private String title;
	private String videoOrgName;
	private String videoSystemName;
	private String videoPath;
	private long videoSize;
	private String nick_name;
	

	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideoOrgName() {
		return videoOrgName;
	}
	public void setVideoOrgName(String videoOrgName) {
		this.videoOrgName = videoOrgName;
	}
	public String getVideoSystemName() {
		return videoSystemName;
	}
	public void setVideoSystemName(String videoSystemName) {
		this.videoSystemName = videoSystemName;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public long getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(long videoSize) {
		this.videoSize = videoSize;
	}

}
