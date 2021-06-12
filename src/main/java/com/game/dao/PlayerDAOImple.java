package com.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.game.model.Player;
import com.game.utility.GetConnection;
import com.game.utility.MyException;

public class PlayerDAOImple implements PlayerDAOInterface {

	public String registerPlayer(ArrayList<Player> ls) {
		// TODO Auto-generated method stub
		Player player = ls.get(0);
		Connection con = GetConnection.getConnection();
		PreparedStatement pt = null;

		String query = "insert into player values(?,?,?,?,?)";
		try {
			pt = con.prepareStatement(query);
			pt.setShort(1, player.getPlayerId());
			pt.setShort(2, player.getPlayerAge());
			pt.setString(3, player.getPlayerName());
			pt.setString(4, player.getTeamName());
			pt.setString(5, player.getPlayerGender());
			pt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				GetConnection.closeConnection(pt);
			} catch (Exception e) {
				System.out.println("Prepared statement cant closed");
			}
			try {
				GetConnection.closeConnection(con);
			} catch (Exception e) {
				System.out.println(" Connection cant closed");
			}
		}

		return "PlayerRegistered";
	}

	@Override
	public boolean checkTeam(String team) throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = GetConnection.getConnection();
			String query = "select * from player where teamName=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, team);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new MyException(e);
		} finally {
			if (con != null) {
				// con.close();
				GetConnection.closeConnection(con);
			}
			if (stmt != null) {
				GetConnection.closeConnection(stmt);
			}
		}
		return false;

	}

	public ArrayList<Player> getPlayers(String team) {
		// TODO Auto-generated method stub
		Connection con = GetConnection.getConnection();
		PreparedStatement pt = null;
		ResultSet rs = null;
		String query = "select * from player where teamName=?";
		try {
			pt = con.prepareStatement(query);
			pt.setString(1, team);

			rs = pt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ArrayList<Player> pl = new ArrayList<Player>();
		try {
			while (rs.next()) {
				pl.add(new Player(rs.getShort("playerId"), rs.getString("playerName"), rs.getShort("playerAge"),
						rs.getString("playerGender"), rs.getString("teamName")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				// con.close();
				GetConnection.closeConnection(con);
			}
			if (pt != null) {
				GetConnection.closeConnection(pt);
			}
		}
		return pl;
	}

	@Override
	public boolean checkPlayerId(short id) throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = GetConnection.getConnection();
			String query = "select * from player where playerId=?";
			stmt = con.prepareStatement(query);
			stmt.setShort(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				// con.close();
				GetConnection.closeConnection(con);
			}
			if (stmt != null) {
				GetConnection.closeConnection(stmt);
			}
		}
		return false;
	}

}
