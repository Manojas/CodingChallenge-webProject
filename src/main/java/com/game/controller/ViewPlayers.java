package com.game.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import com.game.dao.PlayerDAOImple;
import com.game.dao.PlayerDAOInterface;
import com.game.model.Player;
import com.game.service.AddToDatabase;
import com.game.service.GetPlayerDetails;
import com.game.utility.MyException;

/**
 * Servlet implementation class ViewPlayers
 */
public class ViewPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  PlayerDAOInterface pdi=new PlayerDAOImple();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlayers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String team=req.getParameter("team");
		//ArrayList<Player> ls2=null;
		
			try {
				if(pdi.checkTeam(team))
				{
					ArrayList<Player> ls2=pdi.getPlayers(team);
				 req.setAttribute("Players",ls2);
					RequestDispatcher rd= req.getRequestDispatcher("PlayersDetails.jsp");
					rd.forward(req,res);
					try {
						GetPlayerDetails.storeToJson();
						AddToDatabase.addToDatabase();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					res.getWriter().write(" Ther is no such players belongs to this "+team);
//			req.setAttribute("There are no players belong to this team", team);	
//			RequestDispatcher rd= req.getRequestDispatcher("PlayersDetails.jsp");
//			rd.forward(req,res);
				}
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
