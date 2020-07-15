package skku_flea_market.dao;

import java.sql.SQLException;
import java.util.List;

import skku_flea_market.model.User;

public interface UserDao {
	void insertUser(User user) throws SQLException;

	User selectUser(String UserID);

	List<User> selectAllUsers();

	boolean deleteUser(String UserID) throws SQLException;

	boolean updateUser(User user) throws SQLException;
}
