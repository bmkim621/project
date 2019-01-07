package com.yi.project.model;

public class Project {
	private int project_no;
	private String project_name;
	private String start_date;
	private String end_date;
	private String progress;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int project_no, String project_name, String start_date, String end_date, String progress) {
		this.project_no = project_no;
		this.project_name = project_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
	}

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return String.format("Project [project_no=%s, project_name=%s, start_date=%s, end_date=%s, progress=%s]",
				project_no, project_name, start_date, end_date, progress);
	}
	
	
}
