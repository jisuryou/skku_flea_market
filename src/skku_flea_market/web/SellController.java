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
import skku_flea_market.model.User;

/**
 * Servlet implementation class SellController
 */
@WebServlet("/sell")
public class SellController extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = null;

		ProductDao productDao = new ProductDaoImpl();
		ArrayList<Product> products = new ArrayList<Product>();

		User user = new User();
		HttpSession HttpSession = request.getSession();
		user = (User)HttpSession.getAttribute("user");
		request.setAttribute("user", user);
		
		String product_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");
		String product_status = request.getParameter("product_status");
		String product_image = request.getParameter("product_image");
		String product_desc = request.getParameter("product_desc");
		String category = request.getParameter("category");
		
		Product product = new Product();
		product.setName(product_name);
		try {
			product.setPrice(Integer.parseInt(product_price));
		}catch(NumberFormatException e) {
			
		}
		product.setStatus(product_status);
		product.setImg(product_image);
		product.setDesc(product_desc);
		product.setCategory(category);
		product.setSeller(user.getUserID());
		
		try {
			productDao.registerProduct(product);
			products = productDao.selectAllProducts();
			request.setAttribute("products", products);

			view = request.getRequestDispatcher("itemlist.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
