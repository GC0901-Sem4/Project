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
	statusID int references status(statusID),
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

select * from role
select * from tbUser
select * from lab
select * from status
select * from complaint
select * from department
select * from classes
select * from timetable
select * from labOrder
select * from request
select * from resources

insert into role values
('Admin'),
('HOD'),
('Instructor'),
('Technical Staff')

insert into tbUser values
('admin1','123456','A City','admin1@gmail.com','January 10, 1995',1),
('admin2','123456','B City','admin2@gmail.com','Feb 22, 1985',1),
('admin3','123456','C City','admin3@gmail.com','March 5, 1993',1),
('HOD1','123456','V City','HOD1@gmail.com','April 6, 1987',2),
('HOD2','123456','M City','HOD2@gmail.com','May 30, 1988',2),
('HOD3','123456','X City','HOD3@gmail.com','June 12, 1990',2),
('HOD4','123456','Z City','HOD4@gmail.com','Feb 12, 1994',2),
('Instructor1','123456','E City','Instructor1@gmail.com','July 21, 1991',3),
('Instructor2','123456','T City','Instructor2@gmail.com','August 15, 1997',3),
('Instructor3','123456','F City','Instructor3@gmail.com','September 9, 1989',3),
('TechStaff1','123456','D City','TechStaff1@gmail.com','October 27, 1983',4),
('TechStaff2','123456','G City','TechStaff2@gmail.com','November 25, 1986',4),
('TechStaff3','123456','S City','TechStaff3@gmail.com','December 31, 1988',4)

insert into lab values
('Lab no.1'),
('Lab no.2'),
('Lab no.3')

insert into status values
('Pending'),
('Done'),
('Reject')

insert into complaint values
('Equipment error','Machine M1001 is not working',3,1,3),
('Equipment error','Machine M016 is not working',11,2,5),
('Equipment error','Machine M034 is not working',10,3,8)

insert into department values
('A'),
('B')

insert into classes values
('Architect 101',1,45),
('Economy 102',2,45),
('Psychology 103',1,45),
('Biology 104',2,45)

insert into timetable values
('May 11, 2015 08:00:00', 'May 11, 2015 08:45:00',1,3,'off'),
('June 1, 2015 08:00:00', 'June 1, 2015 08:45:00',2,2,'on'),
('June 3, 2015 08:00:00', 'June 3, 2015 08:45:00',3,4,'off'),
('June 5, 2015 08:00:00', 'June 5, 2015 08:45:00',2,1,'off'),
('June 8, 2015 08:00:00', 'June 8, 2015 08:45:00',3,4,'off'),
('June 10, 2015 08:00:00', 'June 9, 2015 08:45:00',3,1,'off'),
('June 12, 2015 08:00:00', 'June 12, 2015 08:45:00',1,4,'off'),
('June 15, 2015 08:00:00', 'June 15, 2015 08:45:00',1,3,'off'),
('June 17, 2015 08:00:00', 'June 17, 2015 08:45:00',3,1,'off'),
('June 19, 2015 08:00:00', 'June 19, 2015 08:45:00',2,2,'off'),
('June 22, 2015 08:00:00', 'June 22, 2015 08:45:00',3,4,'off'),
('June 24, 2015 08:00:00', 'June 24, 2015 08:45:00',2,4,'off'),
('June 26, 2015 08:00:00', 'June 26, 2015 08:45:00',1,2,'off'),
('June 29, 2015 08:00:00', 'June 29, 2015 08:45:00',1,3,'off'),
('July 1, 2015 08:00:00', 'July 1, 2015 08:45:00',2,1,'off'),
('July 3, 2015 08:00:00', 'July 3, 2015 08:45:00',3,2,'off'),
('July 6, 2015 08:00:00', 'July 6, 2015 08:45:00',3,3,'off'),
('July 8, 2015 08:00:00', 'July 8, 2015 08:45:00',2,4,'off'),
('July 10, 2015 08:00:00', 'July 10, 2015 08:45:00',3,4,'off'),
('July 13, 2015 08:00:00', 'July 13, 2015 08:45:00',3,1,'off'),
('July 15, 2015 08:00:00', 'July 15, 2015 08:45:00',1,4,'off'),
('July 17, 2015 08:00:00', 'July 17, 2015 08:45:00',3,3,'off'),
('July 20, 2015 08:00:00', 'July 20, 2015 08:45:00',3,4,'off'),
('July 22, 2015 08:00:00', 'July 22, 2015 08:45:00',1,2,'off'),
('July 24, 2015 08:00:00', 'July 24, 2015 08:45:00',3,4,'off'),
('July 27, 2015 08:00:00', 'July 27, 2015 08:45:00',3,1,'off')


insert into labOrder values
('Order lab no.1','Order lab no.1 for economy class',11,1,8),
('Order lab no.1','Order lab no.1 for psychology class',10,2,8),
('Order lab no.3','Order lab no.3 for biology class',10,3,8)


insert into request values
(4,9,'Lab request','Request lab no.1 for economy class',3,1,7,1,1),
--(2,11,'Equipment request','Machine M016 is not working. Need replacement ASAP',5,2,8,2,2),
--(6,10,'Lab request','Request lab no.1 for economy class',12,3,9,1,3)

insert into resources values
('Desk ',1,10,'on'),
('Chair ',1,30,'on'),
('Screen ',1,1,'off'),
('Projector ',1,1,'on'),
('Desk ',2,10,'on'),
('Chair ',2,30,'on'),
('Screen ',2,2,'on'),
('Projector ',2,1,'off'),
('Desk ',3,10,'on'),
('Chair ',3,30,'on'),
('Screen ',3,1,'on'),
('Projector ',3,1,'on')
