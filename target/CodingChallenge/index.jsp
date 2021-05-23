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
align:center;
padding-left:30px;
padding-top:30px;
padding-bottom:30px;
}
</style>
</head>
<body>
<h2 class="header">Welcome Champion</h2>

<div class="header">
<h1>Welcome to the Game world</h1>
</div>
<br>
<h3><a href="aboutUs.jsp">About US</a></h3>
<br>
<br>
<div class="main">
<h2 class="header">Click here for registration</h2>
<div class ="block">
<form method="post" action="RegisterPlayer.jsp">
<input type="submit" value="Registration">
</form>
</div>
<br>
<div class="block">
<!-- <form method="post" action="ViewPlayers.jsp"> -->
<a href="ViewPlayers.jsp">Display Players</a>
<!-- <input type="submit" value="Display Players" >
</form> -->
</div>
</div>
</body>
</html>
