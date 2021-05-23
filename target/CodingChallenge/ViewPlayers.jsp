<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewPlayers</title>
<style type="text/css">
.header{
color:brown;
background-color:orange;
}
h3
{
text-align:right;
}
.main{
color:black;
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
<div class="block1">
<form method="post" action="index.jsp">
<input type="submit"  id="home" value="Home">
</form>
</div>
<div class="main">
<h2>Enter the name of the Team</h2>
</div>
<div class ="block">
<form name="registrationForm" method="post" action="ViewPlayers" onsubmit="requiredFields()">
<div>
<label>Enter Team Name</label>
<input type="text" name="team" id="team">
<br>
<br>
</div>
<input type="submit" id="submit" value="submit">
</form>
<script src="script.js"></script>
</body>
</html>