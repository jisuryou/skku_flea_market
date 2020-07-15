package skku_flea_market.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import skku_flea_market.model.LoginBean;
import skku_flea_market.model.User;
import skku_flea_market.action.Action;
import skku_flea_market.dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("user_login_id");
		String PW = request.getParameter("user_login_pw");

		LoginBean loginBean = new LoginBean();

		loginBean.setID(ID);
		loginBean.setPassword(PW);

		LoginDao loginDao = new LoginDao();

		User user = null;
		
		HttpSession session = request.getSession();

		try {
			String userValidate = loginDao.validate(loginBean);

			if (userValidate.equals("Admin_Role")) {
				System.out.println("Admin's Home");

				user = new User(ID, PW, "ADMINISTRATOR");

				session.setAttribute("user", user);

				request.setAttribute("user", user);

				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else if (userValidate.equals("Buyer_Role")) {
				System.out.println("Buyer's Home");

				user = new User(ID, PW, "BUYER");

				session.setAttribute("user", user);

				request.setAttribute("user", user);

				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else if (userValidate.equals("Seller_Role")) {
				System.out.println("Seller's Home");

				user = new User(ID, PW, "SELLER");

				session.setAttribute("user", user);

				request.setAttribute("user", user);

				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				System.out.println("Error message = " + userValidate);
				request.setAttribute("errMessage", userValidate);

				request.getRequestDispatcher("login&register.jsp").forward(request, response);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
