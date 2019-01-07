package com.yi.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yi.project.dao.ProjectContentDao;
import com.yi.project.dao.ProjectDao;
import com.yi.project.model.Project;
import com.yi.project.model.ProjectContent;
import com.yi.project.mvc.MySqlSessionFactory;

public class ProjectService {
	//Singleton
	private static ProjectService service = new ProjectService();
	
	public static ProjectService getInstance(){
		return service;
	}
	
	//insert
	// -1 : project에 저장 실패한 경우
	// -2 : projecteContent에 저장 실패한 경우
	// -3 : 특수 경우
	// 0 : 성공
	public int insertArticle(String name, String content, String start, String end, String progress){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
						
			//1. project 테이블에 저장하기
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			
			//insert에는 Project 클래스가 와야되므로 만들어주기.
			//article_no ==> DB에서 알아서 증가하므로 처리하기 때문에 default값으로 넘기기, default 값 : 0
			Project project = new Project(0, name, start, end, progress);
			
			//ArticleDao에서 newNo받도록 처리했었는데 mapper에는 그냥 insert만 하고, newNo를 못가지고 오기 때문에 다시 selectLastNo를 호출해야 한다.
			projectDao.insert(project);
			int project_no = projectDao.selectLastNo();
			
			//위에 insert 성공했을 경우 newNo넘어옴, 그렇지 않을 경우 -1이므로 0보다 작음.
			if(project_no < 0){
				return -1;
			}
			
			//2. project_content 테이블에 저장하기
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			
			//insert에는 ProjectContent 클래스가 와야되므로 만들어주기.
			ProjectContent projectContent = new ProjectContent(project_no, content);
			int result = contentDao.insert(projectContent);
			//insert함수에서 실패할 경우 -1 return하므로 0보다 작음.
			if(result < 0){
				return -2;
			}
			
			session.commit();	//project 테이블, project_content 테이블에 모두 insert 성공했을 시
			
			return 0;	//성공!
			
		} catch (Exception e) {
			//insert 과정에서 SqlException발생 시 rollback 처리한다.
			session.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return -3;
	}

	//리스트
	public List<Project> projectList(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			return dao.select();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	//상세보기
	public Map<String, Object> readProject(int no){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			
			//no에 맞는 Project, Project_content 들고오기
			Project project = projectDao.selectByNo(no);
			ProjectContent content = contentDao.selectByNo(no);
			
			//project, content 모두 return 시키기
			//객체 2개(project, content) 리턴할 경우 hashmap 사용
			Map<String, Object> map = new HashMap<>();
			
			map.put("project", project);
			map.put("content", content);
			
			return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	//수정하기
	// 0: 수정 성공, -1 : 수정실패
	public int modifyProject(Project newProject, ProjectContent newContent){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			//1. project
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			projectDao.modify(newProject);
			
			//2. project_content
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			contentDao.modify(newContent);
			
			session.commit();
			
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return -1;
	}
	
	//삭제하기
	//0: 삭제 성공, -1: project에서 삭제 실패, -2: project_content에서 삭제 실패 , -3: 그 외
	public int deleteProject(int no){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			//1. project
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			//project_no 검색해서 그 내용들을 삭제해야 함
			Project project = projectDao.selectByNo(no);
			//project에 있는 project_no와 매개변수로 받은 no와 같아야만 삭제 가능
			if(project.getProject_no() == no){
				projectDao.delete(no);
			} else{
				return -1;
			}
			
			//2. project_content
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			ProjectContent content = contentDao.selectByNo(no);
			if(content.getProject_no() == no){
				contentDao.delete(no);
			} else{
				return -2;
			}
			
			//둘 다 삭제 성공했을 경우
			session.commit();
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return -3;
	}
}
