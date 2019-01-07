package com.yi.project.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			//삭제할 게시물 번호가 넘어와야 함.
			String projectNo = req.getParameter("no");
			int no = Integer.parseInt(projectNo);
			
			ProjectService service = ProjectService.getInstance();
			int isDel = service.deleteProject(no);
			
			if(isDel < 0){
				System.out.println("isDel " + isDel);
			}
			/*
			 * 삭제 후에 목록을 보이게 하려면 ProjectList.jsp 파일에 있는 내용을 보여야 하는데, 이 내용이 list에 있는 내용들을 실어서 보내야 하기 때문에
			 * ProjectListHandler를 거쳐야 한다.
			 * ProjectListHandler는 properties 파일에서 list.do로 했기 때문에 return을 list.do로 이동시켜야 함!!
			 * */
			return "list.do";
		}
		return null;
	}

}
