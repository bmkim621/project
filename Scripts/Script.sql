drop database if exists project_management;
create database project_management;

-- 사용할 DB 지정하기
use project_management;

create table project(
	project_no int(11) not null auto_increment,
	project_name varchar(50) not null,
	start_date date not null,
	end_date date not null,
	progress varchar(30) not null,
	primary key(project_no)
);

-- 일련번호, 프로젝트 내용
create table project_content(
	project_no int(11) not null,
	content text,
	primary key(project_no)
);