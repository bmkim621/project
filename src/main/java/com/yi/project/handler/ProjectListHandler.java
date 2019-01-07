package com.yi.project.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.model.Project;
import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ProjectService service = ProjectService.getInstance();
		List<Project> list = service.projectList();
		
		req.setAttribute("list", list);
		
		return "/WEB-INF/view/ProjectList.jsp";
	}

}
