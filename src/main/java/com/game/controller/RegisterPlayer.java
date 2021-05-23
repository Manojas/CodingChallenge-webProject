package com.game.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.dao.PlayerDAOImple;
import com.game.dao.PlayerDAOInterface;
import com.game.model.Player;
import com.game.utility.MyException;

/**
 * Servlet implementation class RegisterPlayer
 */
public class RegisterPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlayerDAOInterface pdi = new PlayerDAOImple();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		short id = (short) Integer.parseInt(req.getParameter("id"));
		short age = (short) Integer.parseInt(req.getParameter("age"));
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String team = req.getParameter("team");
		Player player = new Player(id, name, age, gender, team);
		ArrayList<Player> ls = new ArrayList<Player>();
		ls.add(player);
		try {
			String message="";
			if (pdi.checkPlayerId(id)) {
				//res.getWriter().write("The Player is Already Exists");
				 message="This player Alreday registered";
//				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//				rd.forward(req, res);
			} else {
				pdi.registerPlayer(ls);
				 message=" player registered Successfully";
//				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//				rd.forward(req, res);
			}
			req.setAttribute("Message",message);
			RequestDispatcher rd = req.getRequestDispatcher("RegisterPlayer.jsp");
			rd.forward(req, res);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
