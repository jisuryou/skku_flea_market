package skku_flea_market.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import skku_flea_market.action.Action;
import skku_flea_market.dao.ProductDao;
import skku_flea_market.dao.ProductDaoImpl;
import skku_flea_market.model.Product;
import skku_flea_market.model.User;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = null;
		ProductDao ProductDao = null;
		String ProductName = request.getParameter("search_word");
		
		HttpSession HttpSession = request.getSession();

		ArrayList<Product> products = null;
		
		ProductDao = new ProductDaoImpl();
		
		products = ProductDao.selectProductName(ProductName);
		
		request.setAttribute("products", products);
		
		request.setAttribute("user", HttpSession.getAttribute("user"));
		
		view = request.getRequestDispatcher("itemlist.jsp");
		view.forward(request, response);
	}

}
