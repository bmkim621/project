package com.yi.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.yi.project.model.Project;

public interface ProjectDao {
	//등록하기
	public int insert(Project project) throws SQLException;
	
	public int selectLastNo() throws SQLException;
	
	//리스트
	public List<Project> select() throws SQLException;
	
	//상세보기
	public Project selectByNo(int no) throws SQLException;
	
	//수정하기
	public int modify(Project project) throws SQLException;
	
	//삭제하기
	public int delete(int no) throws SQLException;
}
