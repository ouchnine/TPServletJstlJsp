package servlet;

/**
 * @author rachid ouchnine 
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAjouteAuPanier
 */
public class AjouteAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouteAuPanier() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// recuperation de l'id du produit pour l'ajouter au pannier
		String id = request.getParameter("id");
		boolean exist = false;
		// parcourir les ccokies pour determiner si existe deja ou non
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie MonCookie = cookies[i];
			String idCookie = cookies[i].getValue();
			if (id.equals(idCookie)) {

				exist = true;
			}

		}
		// dans le cas ou l'id n'existe pas on rajoute l'id dans la cookies
		if (exist == false) {

			Cookie cookie = new Cookie("PRODUIT" + id, id);
			cookie.setMaxAge(100);
			response.addCookie(cookie);
		}

		// une redirection vers la page d'index
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);

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
