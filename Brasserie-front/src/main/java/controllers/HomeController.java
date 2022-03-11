package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Brasseur;
import model.Client;
import util.Context;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		if(request.getParameter("typeCompte").equals("brasseur")) {
			Brasseur connected = Context.getSingleton().getDaoBrasseur().seConnecter(mail,password);
			request.getSession().setAttribute("connected", connected);
			if(connected instanceof Brasseur) {
				response.sendRedirect("brasseur.jsp");
			} else {
				request.setAttribute("error", "Identifiants invalides");
				getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}

		} else if(request.getParameter("typeCompte").equals("client")) {
			Client connected=Context.getSingleton().getDaoClient().seConnecter(mail,password);
			request.getSession().setAttribute("connected", connected);
			if(connected instanceof Client) {
				response.sendRedirect("client.jsp");
			} else {
				request.setAttribute("error", "Identifiants invalides");
				getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}
		}
	}


}
