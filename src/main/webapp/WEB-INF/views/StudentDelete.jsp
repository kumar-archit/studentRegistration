<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Student Delete Form</h1>
  <form action="<%= request.getContextPath() %>/delete" method="post">
   <table style="with: 80%">
    <tr>
     <td>Roll Number</td>
     <td><input type="text" name="rollNo" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>