package servlet;

/**
 * @author RachidOuchnine
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Catalogue;

/**
 * Servlet implementation class AfficheCatalogueJSTL
 */
public class AfficheCatalogueJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficheCatalogueJSTL() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// comme la servlet AfficheCatalogueJSP sauf cette fois ci on dispatche
		// a un autre jsp
		Catalogue catalogue = (Catalogue) request.getAttribute("catalogue");
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
