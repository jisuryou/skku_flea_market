package skku_flea_market.web;

import java.io.IOException;

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
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet implements Action  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession HttpSession = request.getSession();
		
		RequestDispatcher view = null;
		ProductDao productDao = ProductDaoImpl.getInstance();
		Product product = productDao.selectProductId(id);

		request.setAttribute("product", product);
		request.setAttribute("user", HttpSession.getAttribute("user"));
		view = request.getRequestDispatcher("itempage.jsp");
		view.forward(request, response);
	}

}
