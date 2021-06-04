<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.GregorianCalendar,java.util.Calendar"%>
<%
   GregorianCalendar currentDate=new GregorianCalendar();
   int currentYear=currentDate.get(Calendar.YEAR);
   
%>
<p>&copy;Copyright <%=currentYear %> Learner's Academy</p>
<p>This application has been designed and developed by    
   Priyadarshi Panigrahi
   Email-priyadarshi_05@yahoo.co.in</p> 
    