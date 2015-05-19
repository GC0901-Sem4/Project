create database ACLData

go
use ACLData
go


create table role
(
	roleID int identity primary key,
	roleName varchar(255)
)

create table tbUser
(
	userID int identity primary key,
	username varchar(50),
	pass varchar(255),
	UserAddress varchar(255),
	email nvarchar(255),
	birthday date,
	roleID int references role(roleID)
)

create table lab
(
	labID int identity primary key,
	labName varchar(50),
)


create table status
(
	statusID int identity primary key,
	statusName varchar(50)
)


create table complaint
(
	complaintID int identity primary key,
	title nvarchar(255),
	complaintDescription nvarchar(255),
	assignerID int references tbUser(userID),
	statusID int references status(statusID),
	createrID int references tbUser(userID),
)


create table department
(
	departmentID int identity primary key,
	departmantName nvarchar(50)
)

create table classes
(
	classID int identity primary key,
	className varchar(50),
	departmentID int references department(departmentID),
	amountTime int
)

create table timetable
(
	timeTableID int identity primary key,
	startTime datetime,
	endTime datetime,
	labID int references lab(labID),
	classID int references classes(classID),
	labStatus varchar(10) check (labStatus='on' or labStatus='off') default ('off')
)

create table labOrder
(
	labOrderID int identity primary key,
	title nvarchar(255),
	labOrderDescription nvarchar(255),
	assignerID int references tbUser(userID),
	statusID int references status(statusID),
	createrID int references tbUser(userID),
)

create table request
(
	requestID int identity primary key,
	requestor int references tbUser(userID),
	instructor int references tbUser(userID),
	title nvarchar(255),
	requestDescription nvarchar(255),
	timeTableID int references timetable(timeTableID),
	statusID varchar(10),
	labOrderID int references labOrder(labOrderID),
	departmentID int references department(departmentID),
	complaintID int references complaint(complaintID)
)




create table resources
(
	resourceID int identity primary key,
	resourceName varchar(255),
	labID int references lab(labID),
	quantity int,
	resourceStatus varchar(10) check (resourceStatus='on' or resourceStatus='off') default ('off')
)




select * from tbUser
select * from role
select * from complaint
select * from request
select * from status
select * from timetable
select * from lab
select * from classes
select * from resources
select * from department

insert into tbUser values
('admin1','123456','A City','user1@gmail.com','January 10, 1995',1),

insert into role values
('Admin'),
('HOD'),
('Instructor'),
('Technical Staff'),
('Student')

insert into complaint values
(),
(),
(),
(),
()

insert into request values
(),
(),
(),
(),
()

insert into status values
('Pending'),
('Done'),
('Reject')

insert into timetable values
(),
(),
(),
()

insert into lab values
(''),
(''),
('')

insert into classes values
(),
(),
(),
()

insert into resources values
(),
(),
(),
()

insert into department values
('A'),
('B'),
('C')