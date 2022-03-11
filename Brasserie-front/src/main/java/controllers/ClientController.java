package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import util.Context;

@WebServlet("/client")
public class ClientController extends HttpServlet {

	// FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		// findAll()
		if (request.getParameter("id") == null) 
		{
			List<Client> clients = Context.getSingleton().getDaoClient().findAll();
			request.setAttribute("listeBrasseur", clients);
			getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		// findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Compte compte = Context.getSingleton().getDaoClient().findById(id);
			Client c = (Client) compte;
			request.setAttribute("Client", c);
			getServletContext().getRequestDispatcher("/WEB-INF/updateClient.jsp").forward(request, response);
		}

	}



	// Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		if (request.getParameter("tache").equals("insert")) 
		{

			Client c = new Client(request.getParameter("mail"), request.getParameter("password"));
			Context.getSingleton().getDaoClient().save(c);

			// sinon c'est le Client qui fait un nouveau compte
			if (request.getSession().getAttribute("connected") != null)
			{
				response.sendRedirect("compte");
			}

			// Si on est pas encore connecté, c'est une inscription
			else 
			{
				response.sendRedirect("home");
			}

		}

		else if (request.getParameter("tache").equals("update")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			Client c = new Client(request.getParameter("mail"), request.getParameter("password"));
			c.setVersion(version);
			Context.getSingleton().getDaoClient().save(c);
			response.sendRedirect("compte");

		}


		else if (request.getParameter("tache").equals("delete")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoClient().delete(id);
			response.sendRedirect("compte");
		}

	}

}
