package com.game.model;

public class Player {
private short playerId;
private String playerName;
private short playerAge;
private String playerGender;
private String teamName;

public Player() {
	super();
}
public Player(short playerId, String playerName,short playerAge, String playerGender, String teamName) {
	super();
	this.playerId = playerId;
	this.playerName=playerName;
	this.playerAge = playerAge;
	this.playerGender = playerGender;
	this.teamName = teamName;
}
//change
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public short getPlayerId() {
	return playerId;
}
public void setPlayerId(short playerId) {
	this.playerId = playerId;
}
public short getPlayerAge() {
	return playerAge;
}
public void setPlayerAge(short playerAge) {
	this.playerAge = playerAge;
}
public String getPlayerGender() {
	return playerGender;
}
public void setPlayerGender(String playerGender) {
	this.playerGender = playerGender;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}





}
