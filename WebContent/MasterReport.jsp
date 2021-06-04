<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learners's Academy</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
<h1 style='color:green'>Class Master Report</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="MasterReport" method="post">
      Enter Class Name:<input type="text" name="className" required/>
      <br/>
      
      <input type="submit" name="submit" value="Get Master Report"/>

</form>

<table style='border:1px solid black'>
   <tr>
      <th>Teachers associated with ${className}</th>
      
    </tr>
    <c:forEach items="${teacherNames}"  var="teacher">
    <tr>
        <td><c:out value="${teacher}"/></td>
        
     </tr>
     </c:forEach>
</table>        
<table style='border:1px solid black'>
   <tr>
      <th>Subjects associated with ${className}</th>
      
    </tr>
    <c:forEach items="${subjectNames}"  var="subject">
    <tr>
        <td><c:out value="${subject}"/></td>
        
     </tr>
     </c:forEach>
</table>        
<table style='border:1px solid black'>
   <tr>
      <th style='border;1px solid black'>Students associated with ${className}</th>
      
    </tr>
    <c:forEach items="${studentNames}"  var="student">
    <tr>
        <td><c:out value="${student}"/></td>
        
     </tr>
     </c:forEach>
        
</table>
<br/>
<br/>
<a href="AdminHome.jsp">Go back to Admin Home page</a>
<c:import url="/footer.jsp" />
</body>
</html>