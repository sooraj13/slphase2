package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.AdminController;

/**
 * Servlet implementation class validateUserServlet
 */

public class validateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList userList = new ArrayList();
	public static ArrayList passwordList = new ArrayList();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public validateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		userList.add("admin");
		passwordList.add("admin");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("in validateservlet " + username + " " + password);
		//HttpSession session = request.getSession();
		// session.setAttribute("user", username);
		// session.setAttribute("user", "Update to new username");

		if (userList.contains(username) && passwordList.contains(password)) {
			System.out.println("in if");
			response.sendRedirect("HomePage.html");

		} else {
			System.out.println("in else");
			rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.print("<center><span style = 'color:red'> Invalid Credentials !! </span></center>");
		}

	}

	/*
	 * public void addSubject(String subjectName) {
	 * 
	 * System.out.println("in addSubject"); Configuration configuration = new
	 * Configuration().configure();
	 * configuration.addAnnotatedClass(com.dto.Subject.class);
	 * StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	 * .applySettings(configuration.getProperties());
	 * 
	 * SessionFactory factory = configuration.buildSessionFactory(builder.build());
	 * Session session = factory.openSession(); Transaction transaction =
	 * session.beginTransaction(); Subject newSubject = new Subject(subjectName);
	 * System.out.println("in addSubject"); session.save(newSubject);
	 * 
	 * //Player p1 = new Player(18, "Virat", "INDIA", 31); //session.save(p1);
	 * //Player p2 = session.get(Player.class,18);
	 * //p2.setPlayerName("Virat Kohli"); //p2.setAge(35); //Player p3 =
	 * session.get(Player.class, 18); //session.delete(p3); //Player p4 = new
	 * Player("Rohit", "INDIA", 34); //Player p5 = new Player("Rahul", "INDIA", 29);
	 * //session.save(p4); //session.save(p5); //HQL queries //Query query =
	 * session.createQuery("from Player where team=:name order by playerName");
	 * //query.setString("name", "INDIA"); //List<Player> playerList = query.list();
	 * //System.out.println("Player List Details"); //for(Player p:playerList) { //
	 * System.out.println(p.getPlayerId() + " " + p.getPlayerName()); //} //Native
	 * SQL quwries //criteria query System.out.println("in addSubject");
	 * transaction.commit(); System.out.println("in addSubject"); session.close(); }
	 */



}
