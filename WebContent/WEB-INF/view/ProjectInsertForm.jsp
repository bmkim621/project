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
		padding-left: 220px;
		position: relative;
	}
	
	section label{
		float: left;
		width: 120px;
		text-align: right;
		margin-right: 10px;
	}
	
	section p:LAST-CHILD{
		padding-left: 220px;
	}
	
	section p:LAST-CHILD input{
		margin-left: 10px;
	}
	
	footer{
		background-color: #353535;
		padding: 10px;
		color: #efefef;
		font-size: 12px;
		text-align: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#home").click(function(){
			location.href = "index.jsp";
		})
		
	})
</script>
</head>
<body>
	<div id="container">
		<header> SPMS(Simple Project Management System) </header>
		
		<section>
			<form action="${pageContext.request.contextPath }/insert.do" method="post">
				<p>
					<label>프로젝트 이름</label>
					<input type="text" name="name" size="40">
				</p>
				<p>
					<label>프로젝트 내용</label>
					<textarea rows="10" cols="60" name="content"></textarea>
				</p>
				<p>
					<label>시작날짜</label>
					<input type="text" name="start" size="30">
				</p>
				<p>
					<label>마감날짜</label>
					<input type="text" name="end" size="30">
				</p>
				<p>
					<label>상태</label>
					<select name="progress">
						<option value="준비">준비</option>
						<option value="진행중">진행중</option>
						<option value="종료">종료</option>
						<option value="보류">보류</option>
					</select>
				</p>
				<p>
					<input type="submit" value="저장">
					<input type="button" id="home" value="홈으로">
					<input type="reset" value="취소">
				</p>
			</form>
		</section>

		<footer> SPMS ⓒ2019 </footer>
	</div>
</body>
</html>