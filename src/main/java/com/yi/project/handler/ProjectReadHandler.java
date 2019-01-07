package com.yi.project.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ProjectReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			//번호 => 리스트 클릭했을 때 번호가 넘어와야 함.
			String projectNo = req.getParameter("no");
			int no = Integer.parseInt(projectNo);
	
			ProjectService service = ProjectService.getInstance();
			
			Map<String, Object> map = service.readProject(no);
			
			req.setAttribute("map", map);

			return "/WEB-INF/view/ProjectRead.jsp";
		}
		return null;
	}

}
