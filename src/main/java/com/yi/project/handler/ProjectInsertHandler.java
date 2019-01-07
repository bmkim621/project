package com.yi.project.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ProjectInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/ProjectInsertForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")){
			//form에서 입력한 값들 받아오기 : name, content, start, end, progress
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String start = req.getParameter("start");
			String end = req.getParameter("end");
			String progress = req.getParameter("progress");
			
			ProjectService service = ProjectService.getInstance();
			//insert 결과값을 int로 했으니까 그 값을 받을 변수 선언
			int error = service.insertArticle(name, content, start, end, progress);
			
			//실패한 경우 : insert시 실패한 경우 -1, -2, -3 리턴되므로 0보다 작을 경우 에러 발생.
			if(error < 0){
				System.out.println("error :" + error);
			}
			return "list.do";
		}
		return null;
	}

}
