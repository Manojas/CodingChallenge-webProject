package com.game.service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.game.utility.GetConnection;

public class AddToDatabase {
	public static void addToDatabase() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("D:/PlayerDetails2.json"));
			System.out.println(jsonObject);
			JSONArray jsonArray = (JSONArray) jsonObject.get("PlayerDetails");

			System.out.println(jsonArray);
			Connection con = null;
			con = GetConnection.getConnection();
			PreparedStatement st = null;

			st = con.prepareStatement("INSERT INTO player2 values (?, ?, ?)");
			for (Object obj : jsonArray) {
				JSONObject record = (JSONObject) obj;

				short id = (short) Integer.parseInt((String) record.get("PlayerId"));
				short age = (short) Integer.parseInt((String) record.get("PlayerAge"));
				String playername = (String) record.get("PlayerName");

				st.setShort(1, id);
				st.setShort(2, age);
				st.setString(3, playername);
				st.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
