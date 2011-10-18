package servlet;
/**
 * @author RachidOuchnine
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Catalogue;
import bean.Produit;

/**
 * Servlet implementation class AfficheProduit
 */
public class AfficheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficheProduit() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// recuperation de l'id du produit 
		String id = (String) request.getParameter("id");
		// recuperation du catalogue coutrant
		Catalogue catalogue = Catalogue.getInstance();
		// recherche du produit avec l'id comme paramatere
		Produit produit = catalogue.getListProduit().get(id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//affichage des caractértistique du produit directement sans l'utilisation d'un jsp
		out.println(" <HTML>\n "
				+ "<body> \n"
				+ "<link rel=stylesheet type='text/css' href='/css/styles.css'> \n"
				+ "<li><td> <a href='index.html'>Page d'acceuil </a>  </td>  \n"
				+ "<div class='produit'> \n" + "<table> \n" + "<tr> \n"
				+ "<td rowspan='2'> \n" + "<img  src='"
				+ produit.getImage()
				+ "' width='300' height='250' />"
				+ "</td>\n"
				+ "<td class='nom'>"
				+ produit.getNom()
				+ "</td> \n"
				+ "</tr> \n"
				+ "<tr> \n"
				+ "<td class='prix'>"
				+ produit.getPrix()
				+ "&nbsp;&euro;</td> \n"
				+ "</tr> \n"
				+ "<tr> \n"
				+ "<td colspan='2' class='desc'>"
				+ produit.getDescription()
				+ "</td> \n"
				+ "</tr> \n"
				+ "</table> \n"
				+ "<form method='get' action='AjouteAuPanier'>\n"
				+ "<input type='hidden' name='id' value='"
				+ produit.getId()
				+ "'/> \n"
				+ "<input type='submit' value='ajouter au panier' />\n"
				+ "</form> \n" + "</body>\n" + "</html>");
		
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
