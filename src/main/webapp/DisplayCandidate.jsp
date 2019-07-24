<%@page import="java.util.List"%>
<%@page import="com.dao.AdharCardImpl"%>
<%@page import="com.dao.AdharCardDao"%>
<%@page import="javax.transaction.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%

		Session s =null;
		Transaction tx=null; 		
		 try{
		AdharCardDao ad=new AdharCardImpl();
		List<String> details = ad.candidateDetails("551634244425");
		//System.out.println(details);
		//out.print(details);
		%> 
		<center>
		<div class="col-6">
		
		<table class='table table-stripped table-primary' ><tr><th>Candidate Name</th><th>Vote</th></tr>
 	<%
		for (String string : details) {%>
			<tr><td><%=string %></td>
			<td><input type='submit' name='vote' value='submit vote'></td></tr>
	<%
		}
		
		out.write("</table>");
		//response.sendRedirect("Ajax.jsp");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

 %>

</table>
</div>
</center>
</body>
</html>