package skku_flea_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import skku_flea_market.utils.JDBCUtils;
import skku_flea_market.model.User;

public class UserDaoImpl implements UserDao {
	private static final String INSERT_USERS_SQL = "INSERT INTO USER"
			+ "  (userID, userPW, user_email, user_type) VALUES " + " (?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select userID,userPW,user_email,user_type from USER where userID =?";
	private static final String SELECT_ALL_USERS = "select * from USER";
	private static final String DELETE_USER_BY_ID = "delete from USER where userID = ?;";
	private static final String UPDATE_USER = "update USER set userPW= ?, user_email =?, user_type =? where userID = ?;";

	public UserDaoImpl() {
	}

	@Override
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUserID());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getType());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public User selectUser(String userID) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, userID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String id = rs.getString("userID");
				String pw = rs.getString("userPW");
				String email = rs.getString("user_email");
				String type = rs.getString("user_type");
				user = new User(id, pw, email, type);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return user;
	}

	@Override
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String id = rs.getString("userID");
				String pw = rs.getString("userPW");
				String email = rs.getString("user_email");
				String type = rs.getString("user_type");
				users.add(new User(id, pw, email, type));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return users;
	}

	@Override
	public boolean deleteUser(String userID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);) {
			statement.setString(1, userID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getType());
			statement.setString(4, user.getUserID());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
