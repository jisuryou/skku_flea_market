package skku_flea_market.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import skku_flea_market.dao.UserDao;
import skku_flea_market.dao.UserDaoImpl;
import skku_flea_market.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession HttpSession = request.getSession();
		request.setAttribute("user", HttpSession.getAttribute("user"));

		try {
			switch (action) {

			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login_register.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("userID");
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("selected_user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		String email = request.getParameter("user_email");
		String type = request.getParameter("uer_type");

		User newUser = new User(id, pw, email, type);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		String email = request.getParameter("user_email");
		String type = request.getParameter("user_type");

		User updateUser = new User(id, pw, email, type);

		userDAO.updateUser(updateUser);

		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("userID");
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}

}
