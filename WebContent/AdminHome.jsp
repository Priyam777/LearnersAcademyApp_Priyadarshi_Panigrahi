<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
//response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Logged in Successfully at <%= new Date() %>
<br/>
<br/>
<h1 style="color:blue">Admin Utility</h1>
<br/>
<br/>
<a href="AddSubject.jsp">Add Subjects for a given class</a><br/>
<a href="AddStudent.jsp">Add Students for a given class</a><br/>
<a href="AddTeacher.jsp">Add Teachers</a><br/>
<a href="AddClasses.jsp">Add Classes</a><br/>
<a href="AssignTeacherClass.jsp">Assign class to a given Teacher</a><br/>
<a href="AssignTeacherSubject.jsp">Assign subjects to a given teacher</a><br/>

<br/>
<br/>
<h1 style="color:blue">Admin Reports</h1>
<br/>
<br/>
<a href="StudentsList">Students Report</a><br/>
<a href="SubjectList">Subjects Report</a><br/>

<a href="TeacherList">Teachers Report</a><br/>
<a href="ClassesList">Classes Report</a><br/>
<a href="MasterReport.jsp">Master Report</a><br/>

<br/>
<br/>
<a href="Logout">Log Out</a>
<c:import url="/footer.jsp"/>
</body>
</html>