package servlet;

/*
 * @author RachidOuchnine
 */
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Catalogue;
import bean.Produit;

/**
 * Servlet implementation class AffichePanier
 */
public class AffichePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AffichePanier() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// old catalogue correspant à l'ancien catalogue

		Catalogue oldcatalogue = Catalogue.getInstance();
		// catalogue correpond au niveau catalogue qui a contenir l'ensemble des
		// produit des pannier
		Catalogue catalogue = new Catalogue();
		Produit produit = new Produit();
		// liste qui va contenir tous les produits qui existant dans le pannier
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		// recupération des Ids des produits a travers les cookies
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie MonCookie = cookies[i];
			String id = cookies[i].getValue();
			produit = oldcatalogue.getListProduit().get(id);
			// si l'id passé en parramtre correspand a un id d'un produit en
			// rajoute ce dernier dans la liste
			if (produit != null) {
				listProduit.put(produit.getId(), produit);

			}

		}
		// ajouiter la liste au catalogue
		catalogue.setListProduit(listProduit);
		// dispatcher le nouveau catalogue au jsp pour afficher la liste des
		// produits du pannier
		request.setAttribute("catalogue", catalogue);
		RequestDispatcher reqDispatcher = getServletConfig()
				.getServletContext().getRequestDispatcher(
						"/jsp/afficheCatalogueJSTL.jsp");
		reqDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
