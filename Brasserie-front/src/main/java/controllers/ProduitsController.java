package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Biere;
import model.Produits;
import model.Snack;
import util.Context;

@WebServlet("/produits")

public class ProduitsController extends HttpServlet {
//	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//findAll()
		if(request.getParameter("id")==null) 
		{
			
			List<Produits> produits =Context.getSingleton().getDaoProduits().findAll();
			request.setAttribute("listeProduits", produits);
			getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
		}

		//findById()
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Produits p = Context.getSingleton().getDaoProduits().findById(id);
			request.setAttribute("produits", p);
			getServletContext().getRequestDispatcher("/WEB-INF/updateProduits.jsp").forward(request, response);


		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("insert")) 
		{

			if(request.getParameter("typeProduits").equals("biere")) 
			{

				Biere b = new Biere(request.getParameter("nom"),request.getParameter("description"), Double.parseDouble(request.getParameter("prix")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("points")));
				Context.getSingleton().getDaoBiere().save(b);


			}
			else if(request.getParameter("typeProduits").equals("snack"))
			{
				Snack s = new Snack(request.getParameter("nom"),request.getParameter("description"), Double.parseDouble(request.getParameter("prix")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("points")));
				Context.getSingleton().getDaoSnack().save(s);

			}


		}

		else if(request.getParameter("tache").equals("update")) 
		{

			if(request.getParameter("typeProduits").equals("Biere")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				int version = Integer.parseInt(request.getParameter("version"));
				Biere b = new Biere(id, request.getParameter("nom"),request.getParameter("description"), Double.parseDouble(request.getParameter("prix")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("points")));
				b.setVersion(version);
				Context.getSingleton().getDaoBiere().save(b);


			}
			else if(request.getParameter("typeProduits").equals("Snack"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				int version = Integer.parseInt(request.getParameter("version"));
				Snack s = new Snack(id, request.getParameter("nom"),request.getParameter("description"), Double.parseDouble(request.getParameter("prix")), Integer.parseInt(request.getParameter("stock")));
				s.setVersion(version);
				Context.getSingleton().getDaoSnack().save(s);

			}

		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));


			Context.getSingleton().getDaoProduits().delete(id);
		}


		response.sendRedirect("produits");
	}
}
