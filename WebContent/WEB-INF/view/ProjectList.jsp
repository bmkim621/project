<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+KR');

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	#container {
		margin: 20px auto;
		width: 1000px;
	}
	
	header {
		background-color: #353535;
		padding: 15px;
		color: #FFE400;
		font-weight: bold;
	}
	
	section{
		background-color: #efefef;
		padding: 10px;
		font-size: 14px;
		color: #3A3A3A;
		font-weight: bold;
		padding-left: 100px;
	}
	
	footer{
		background-color: #353535;
		padding: 10px;
		color: #efefef;
		font-size: 12px;
		text-align: center;
	}
	
	table{
		border: 1px solid gray;
		border-collapse: collapse;
		width: 800px;
		background-color: white;
		text-align: center;
		margin: 10px 0;
	}
	
	td, th{
		border: 1px solid gray;
		padding: 5px;
		text-align: center;
	}
	
	.link{
		text-decoration: none;
		color: #3162C7;
	}
	
	a{
		text-decoration: none;
		color: #747474;
		padding-right: 5px;
	}
	
	td{
		color: #747474;
	}
</style>
</head>
<body>
	<div id="container">
		<header> SPMS(Simple Project Management System) </header>

		<section>
			<a href="index.jsp" class="link">[홈으로]</a>
			<a href="${pageContext.request.contextPath }/insert.do" class="link">[새 프로젝트 등록]</a>
			<table>
				<tr>
					<th>프로젝트 이름</th>
					<th>시작날짜</th>
					<th>종료날짜</th>
					<th>상태</tdh>
				</tr>
				<c:forEach var="project" items="${list }">
					<tr>
						<td><a href="read.do?no=${project.project_no }">${project.project_name }</a></td>
						<td>${project.start_date }</td>
						<td>${project.end_date }</td>
						<td>${project.progress }</td>
					</tr>
				</c:forEach>
			</table>
		</section>

		<footer> SPMS ⓒ2019 </footer>
	</div>
</body>
</html>