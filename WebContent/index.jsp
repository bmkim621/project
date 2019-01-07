<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		font-size: 14px;
		color: #3A3A3A;
		font-weight: bold;
		padding-top: 10px;
		padding-bottom: 5px;
	}
	
	section img{
		width: 1000px;
		padding-top: 10px;
	}
	
	footer{
		background-color: #353535;
		padding: 10px;
		color: #efefef;
		font-size: 12px;
		text-align: center;
	}
	
	#menu{
		padding-left: 270px;
	}
	
	a{
		text-decoration: none;
		color: #353535;
		padding-left: 50px;
	}
	
	a:hover{
		color: #3162C7;
		text-decoration: underline;
	}
</style>
</head>
<body>
	<div id="container">
		<header> SPMS(Simple Project Management System) </header>

		<section>
			<div id="menu">
				<a href="index.jsp">HOME</a>
				<a href="insert.do">새 프로젝트 등록하기</a>
				<a href="list.do">프로젝트 리스트 보기</a>
			</div>
			<img src="images/proj-management.png">
		</section>

		<footer> SPMS ⓒ2019 </footer>
	</div>
</body>
</html>