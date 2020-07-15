package skku_flea_market.dao;

import java.sql.Connection;
import java.sql.Statement;

import skku_flea_market.model.LoginBean;
import skku_flea_market.utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public String validate(LoginBean loginBean) throws ClassNotFoundException {

		String ID = loginBean.getID();
		String password = loginBean.getPassword();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String idDB = "";
		String passwordDB = "";
		String typeDB = "";

		try {
			con = JDBCUtils.getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select userID,userPW,user_type from USER");

			while (resultSet.next()) {
				idDB = resultSet.getString("userID");
				passwordDB = resultSet.getString("userPW");
				typeDB = resultSet.getString("user_type");

				if (ID.equals(idDB) && password.equals(passwordDB) && typeDB.equals("ADMINISTRATOR"))
					return "Admin_Role";
				else if (ID.equals(idDB) && password.equals(passwordDB) && typeDB.equals("BUYER"))
					return "Buyer_Role";
				else if (ID.equals(idDB) && password.equals(passwordDB) && typeDB.equals("SELLER"))
					return "Seller_Role";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";

	}
}
