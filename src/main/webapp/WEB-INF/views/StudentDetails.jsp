<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="studentRegistration.model.Student" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="${status}"/>
<c:forEach var="Student" items="${styles}">
  <br/>
  <c:out value="${Student.rollNo}" />
  <c:out value="${Student.name}" />
  <c:out value="${Student.marks}" />
</c:forEach>
</body>
</html>