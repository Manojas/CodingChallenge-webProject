<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About us page</title>
<style>
@keyframes cssg
{
0% {background-color:green;}
25% {background-color:yellow;}
50% {background-color:orange;}
100% {background-color:red;}
}
.block1
{
align:right
}
.h2
{
color:black;
background-color:orange;
}
body{
background:color-black;
animation-name:cssg;
animation-duration:5s;
}
</style>
</head>
<body>
<div class="block1">
<form method="post" action="index.jsp">
<input type="submit" value="Home">
</form>
</div>
<p class="h2">
This is an Indian primier League and we are happy to announce thank you for being a part of this game.<br>
Lots of foriegn players took part here to make this event as a grand success</p> 

<br>
<p id="display"></p>
<input type="button" value="Greeting" onclick="loadMessage()">
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">-->

<script type="text/javascript">
$(document).ready(function()
		{
	$("btn").click(function()
			{
         alert("Thanks for reading");		
			});
	
		});
</script>
<script type="text/javascript">
function loadMessage()
{
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("display").innerHTML = xhttp.responseText;	
		}
	};
	xhttp.open('GET','some.txt',true);
	xhttp.send();

	}
	</script>
</body>
</html>