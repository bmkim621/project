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
	
	td{
		border: 1px solid gray;
		padding: 5px;
		text-align: center;
	}
	
	td:NTH-CHILD(2n) {
		text-align: left;
		padding-left: 10px;
		color: #747474;
	}
	
	td:NTH-CHILD(1){
		width: 100px;
	}
	
	#wrap{
		padding-left: 300px;
	}
	
	#wrap a{
		text-decoration: none;
		color: #3162C7;
		padding-left: 20px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#del").click(function(){
			var delConfirm = confirm("삭제하시겠습니까?");
			
			if(delConfirm == true){
				//location을 이용해서 삭제
				location.href = "delete.do?no=${map.project.project_no }";
			} else{
				
			}
			return false;
		})
		
	})
</script>
</head>
<body>
	<div id="container">
		<header> SPMS(Simple Project Management System) </header>

		<section>
			<table>
				<tr>
					<td>프로젝트 이름</td>
					<td>${map.project.project_name }</td>
				</tr>
				<tr>
					<td>프로젝트 내용</td>
					<td>${map.content.content }</td>
				</tr>
				<tr>
				<td>시작날짜</td>
					<td>${map.project.start_date }</td>
				</tr>
				<tr>
					<td>종료날짜</td>
					<td>${map.project.end_date }</td>
				</tr>
				<tr>
					<td>상태</td>
					<td>${map.project.progress }</td>
				</tr>
			</table>
			<div id="wrap">
				<a href="modify.do?no=${map.project.project_no }">[수정]</a>
				<a href="delete.do?no=${map.project.project_no }" id="del">[삭제]</a>
				<a href="list.do">[돌아가기]</a>
			</div>
		</section>

		<footer> SPMS ⓒ2019 </footer>
	</div>
</body>
</html>