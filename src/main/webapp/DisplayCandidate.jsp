<%@page import="com.model.Candidate"%>
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
	String session_adharcard=(String)session.getAttribute("adharcard");
		Session s =null;
		Transaction tx=null; 		
		 try{
		AdharCardDao ad=new AdharCardImpl();
		List<Candidate> clist=ad.fetchAll(session_adharcard);
%> 
<!-- 		<center> -->
		<div class="col-6">
		
		<table class='table  table-white' style="color: white;" ><tr>
		<th>Candidate id</th>
		<th>Candidate Name</th>
		<th>Vote</th></tr>		
 	<%
 	 for (Candidate c : clist) {%>
			<tr><td><%=c.candidateId %></td>
			<td><%=c.getCandidateName() %></td>
			<td>
			<a href="DisableUserAfterVote?id=<%=c.candidateId %>" 
			class="btn btn-" >Vote Now</a>
			
			</td></tr>
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
<!-- </center> -->
</body>
</html>