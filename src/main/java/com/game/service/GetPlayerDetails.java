package com.game.service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.game.utility.GetConnection;



public class GetPlayerDetails {
public static void storeToJson() throws SQLException
{
	Connection con=null;
	ResultSet rs=null;
	con=GetConnection.getConnection();
	String str="Select * from player";
	Statement st = null;
	try {
		st = con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	try {
		rs=st.executeQuery(str);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	JSONObject jObject=new JSONObject();
	JSONArray jArray=new JSONArray();
	
	while(rs.next())
	{
		JSONObject record = new JSONObject();
		record.put("Player ID", rs.getShort("playerId"));
		record.put("Player Age", rs.getShort("playerAge"));
		record.put("Player Name", rs.getString("playerName"));
		
		jArray.add(record);
	}
	jObject.put("PlayerDetails", jArray);
	FileWriter file = null;
	try {
		file = new FileWriter("D:/PlayerDetails.json");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1.getMessage());
	}
	try {
		file.write(jObject.toJSONString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	try {
		file.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
}
