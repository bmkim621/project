package com.yi.project.dao;

import java.sql.SQLException;

import com.yi.project.model.ProjectContent;

public interface ProjectContentDao {
	//등록하기
	public int insert(ProjectContent content) throws SQLException;
	
	public ProjectContent selectByNo(int no) throws SQLException;
	
	//수정하기
	public int modify(ProjectContent content) throws SQLException;
	
	//삭제하기
	public int delete(int no) throws SQLException;
}
