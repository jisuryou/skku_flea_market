package skku_flea_market.web;

import java.io.IOException;
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

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = null;
		ProductDao ProductDao = null;
		
		String category = request.getParameter("category");
		
		HttpSession HttpSession = request.getSession();
		
		ArrayList<Product> category_products = null;
		
		ProductDao = new ProductDaoImpl();

		category_products = ProductDao.selectProductCategory(category);

		request.setAttribute("category_products", category_products);
		
		request.setAttribute("user", HttpSession.getAttribute("user"));
		
		view = request.getRequestDispatcher("category_itemlist.jsp");
		view.forward(request, response);
	}
}
