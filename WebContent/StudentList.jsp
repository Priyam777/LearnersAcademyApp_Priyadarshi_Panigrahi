<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learner's Academy</title>
<link rel="stylesheet" href="main.css">
</head>
<body>

<h1 style='color:green'>Students Report</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<table style='border:1px solid black'>

   <tr>
      <th>Student Id</th>
      <th>Student Name</th>
      <th>Student Class</th>
    </tr>
    <c:forEach items="${studentList}"  var="student">
    <tr>
        <td><c:out value="${student.studentId}"/></td>
        <td><c:out value="${student.studentName}"/></td>
        <td><c:out value="${student.studentClass.className}"/></td>
     </tr>
     </c:forEach>
        
        
      
</table>
<br/>
<br/>
<a href="AdminHome.jsp">Go back to Admin Home page</a>

<c:import url="/footer.jsp" />

</body>
</html>