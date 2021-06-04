<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <form action="AssignTeacherClass" method="post">
       
       Enter Teacher Name:<input type="text" name="teacherName" required/><br/>
       Enter class Name:<input type="text" name="className" required/><br/>
       
       
       
       <input type="submit" name="submit" value="Assign class to Teacher"/>
    </form>
    
    <a href="AdminHome.jsp">Go back to Admin Home page</a><br/>
    <a href="AddTeacher.jsp">Add Teacher</a><br/>
    <a href="AssignTeacherClass.jsp">Assign more classes to  Teacher</a><br/>
 <c:import url="/footer.jsp"  /> 
</body>
</html>