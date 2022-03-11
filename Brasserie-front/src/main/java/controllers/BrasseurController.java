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
import model.Brasseur;
import util.Context;

@WebServlet("/brasseur")
public class BrasseurController extends HttpServlet {

	// FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		// findAll()
		if (request.getParameter("id") == null) 
		{
			List<Brasseur> brasseurs = Context.getSingleton().getDaoBrasseur().findAll();
			request.setAttribute("listeBrasseur", brasseurs);
			getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		// findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Compte compte = Context.getSingleton().getDaoBrasseur().findById(id);
			Brasseur b = (Brasseur) compte;
			request.setAttribute("brasseur", b);
			getServletContext().getRequestDispatcher("/WEB-INF/updateBrasseur.jsp").forward(request, response);
		}

	}



	// Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		if (request.getParameter("tache").equals("insert")) 
		{

			Brasseur b = new Brasseur(request.getParameter("mail"), request.getParameter("password"));
			Context.getSingleton().getDaoBrasseur().save(b);

			// sinon c'est le Brasseur qui fait un nouveau compte
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
			Brasseur b = new Brasseur(request.getParameter("mail"), request.getParameter("password"));
			b.setVersion(version);
			Context.getSingleton().getDaoBrasseur().save(b);
			response.sendRedirect("compte");

		}


		else if (request.getParameter("tache").equals("delete")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoBrasseur().delete(id);
			response.sendRedirect("compte");
		}

	}

}
