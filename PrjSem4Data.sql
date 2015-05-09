create database ACLData

go
use ACLData
go

create table tbUser
(
	userID int identity primary key,
	username varchar(50),
	pass varchar(255),
	UserAddress varchar(255),
	email nvarchar(255),
	birthday date,
	roleID int
)

create table role
(
	roleID int,
	roleName varchar(255)
)

create table complaint
(
	complaintID int primary key,
	title nvarchar(255),
	complaintDescription nvarchar(255),
	assignerID int,
	statusID varchar(10),
	createrID int,
)

create table request
(
	requestID int primary key,
	requestor varchar(50),
	instructor varchar(50),
	title nvarchar(255),
	requestDescription nvarchar(255),
	timeTableID int,
	statusID varchar(10)
)

create table status
(
	statusID int primary key,
	statusName varchar(50)
)

create table timetable
(
	timeTableID int primary key,
	startTime datetime,
	endTime datetime,
	labID int,
	classID int,
	labStatus varchar(10) check (labStatus='on' or labStatus='off') default ('off')
)

create table lab
(
	labID int primary key,
	labName varchar(50),
)

create table classes
(
	classID int primary key,
	className varchar(50),
	departmentID int,
	amountTime int
)

create table resources
(
	resourceID int primary key,
	resourceName varchar(255),
	labID int,
	quantity int,
	resourceStatus varchar(10) check (resourceStatus='on' or resourceStatus='off') default ('off')
)

create table department
(
	departmentID int primary key,
	departmantName nvarchar(50)
)
