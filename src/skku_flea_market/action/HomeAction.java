package skku_flea_market.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import skku_flea_market.dao.ProductDao;
import skku_flea_market.dao.ProductDaoImpl;
import skku_flea_market.model.Product;

public class HomeAction implements Action{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		execute(request, response);
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProductDao productDao;
		productDao = new ProductDaoImpl();
		
		HttpSession HttpSession = request.getSession();
		
		ArrayList<Product> all_products = productDao.selectAllProducts();
		
		request.setAttribute("all_products", all_products);
		request.setAttribute("user", HttpSession.getAttribute("user"));
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
}
