package skku_flea_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import skku_flea_market.utils.JDBCUtils;
import skku_flea_market.model.User;

public class RegisterDao {
	public int registerUser(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO USER" + "  (userID, userPW, user_email, user_type) VALUES "
				+ " (?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUserID());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getType());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCUtils.printSQLException(e);
		}
		return result;
	}
}
