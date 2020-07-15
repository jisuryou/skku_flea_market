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
import skku_flea_market.dao.RegisterDao;
import skku_flea_market.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	private RegisterDao userDao;

	public void init() {
		userDao = new RegisterDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userID = request.getParameter("user_register_id");
		String userPW = request.getParameter("user_register_pw");
		String userPWC = request.getParameter("user_register_pwc");
		String user_email = request.getParameter("user_register_email");
		String user_type = request.getParameter("signupcheck");

		User user = new User();
		user.setUserID(userID);
		if (!userPWC.equals(userPW)) {
			request.setAttribute("NOTIFICATION", "Wrong Password!");
			HttpSession session = request.getSession();
			session.setAttribute("user_register_id", userID);
			session.setAttribute("user_register_pw", userPW);
			session.setAttribute("user_register_email", user_email);
			session.setAttribute("signupcheck", user_type);
			response.sendRedirect("login&register.jsp");
		} else {
			user.setPassword(userPW);
		}
		user.setEmail(user_email);
		user.setType(user_type);

		try {
			int result = userDao.registerUser(user);
			if (result == 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully! Login please");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("login&register.jsp");
		dispatcher.forward(request, response);
	}

}
