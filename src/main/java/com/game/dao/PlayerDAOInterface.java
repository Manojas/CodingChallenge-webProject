package com.game.dao;

import java.util.ArrayList;

import com.game.model.Player;
import com.game.utility.MyException;

public interface PlayerDAOInterface {
public String registerPlayer(ArrayList<Player> ls);
public boolean checkTeam(String team) throws MyException;
public ArrayList<Player> getPlayers(String team);
public boolean checkPlayerId(short id) throws MyException;

}
