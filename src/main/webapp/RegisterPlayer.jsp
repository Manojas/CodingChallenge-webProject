<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>Cricket</title>
<style type="text/css">
.header{
color:black;
background-color:orange;
}
h3
{
text-align:right;
}
.main{
color:silver;
background-color:orange;
}
body{
background-color:silver;
}
.block
{
background-color:white;
align:center;
padding-left:30px;
padding-top:30px;
padding-bottom:30px;
}
</style>
</head>
<body>
<%if(request.getAttribute("Message")!=null) {%>
<p><%=request.getAttribute("Message")%></p>
<%} %>
<div class="block1">
<form method="post" action="index.jsp">
<input type="submit"  id="home" value="Home">
</form>

</div>
<div class="main">
<h2 class="header">Please enter below details</h2>
</div>
<div class ="block">
<form name="registrationForm" method="post" action="RegisterPlayer" onsubmit="requiredFields()">
<div>
<label>Enter Player Id:</label>
<input type="number" name="id" id="id">

</div>
<br>
<div>
<label>Enter Player Name:</label>
<input type="text" name="name" id="name">
</div>
<br>
<div>
<label>Enter Player Age:</label>
<input type="number" name="age" id="age">
</div>
<br>
<div>
<label>Enter Player Gender:</label>
<input type="text" name="gender" id="gender">
</div>
<br>
<div>
<label>Enter Player Team Name:</label>
<input type="text" name="team" id="team">
</div>
<br>
<input type="submit" value="submit" id="submit">
</form>
<br>
</div>
<script src="script.js"></script>
</body>
</html>