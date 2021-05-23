<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "com.game.model.Player" %>
    <%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Players Details</title>
</head>
<body>
<h2>The Player Details are:</h2>
<table border=1>
<tr>
<td>Player id</td>

<th>Player Name</th>
<th>Player Age</th>
<th>Player Gender</th>
<th>Player Team</th>
</tr>

<%
List<Player> pl=(List<Player>)request.getAttribute("Players");
for(Player p:pl){
	
%>
<tr><td><%= p.getPlayerId() %></td>
<td><%= p.getPlayerName() %></td>
<td><%= p.getPlayerAge() %></td>
<td><%= p.getPlayerGender() %></td>
<td><%= p.getTeamName() %></td></tr>
<% }%>
</table>
<br>
<form method="post" action="index.jsp">
<input type="submit"  id="home" value="Home">
</form>
</body>
</html>