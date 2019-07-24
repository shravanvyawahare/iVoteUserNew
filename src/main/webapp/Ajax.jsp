<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script src="jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
      
<script>
$(document).ready(function(){
	//alert("Loaded inside");
	
	$.ajax({
		
		type:'GET',
		url:'DisplayCandidate.jsp',
		
		success: function(result){
			//alert("On inside"+$("#CandidateName").val());
	        $('#demo').html(result);
	    }
	});
	
	});
</script>
</head>
<body>
<%-- <%
   session= request.getSession(false);
if(session.getAttribute("adharcard")!=null)
{
	response.sendRedirect("Logout");	
}
else
{
%> --%>
<br><br>
<div class="container">


  <form class="form" method="get">
                <div class="form-group " id="demo">
                    <label class="col-3"><b>Candidate Name</b></label>
                </div>
                
                   
        </form>
        </div>
       
</body>
</html>
<%-- <%} %> --%>