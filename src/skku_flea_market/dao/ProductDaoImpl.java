package skku_flea_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import skku_flea_market.model.Product;
import skku_flea_market.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO PRODUCT"
			+ "  (productID, product_name, product_price, product_status, product_desc, product_img, product_category, sellerID) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String CREATE_ID_SQL = "SELECT COUNT(*) FROM PRODUCT";

	// private static final String SELECT_PRODUCT_BY_NAME = "select product_name,
	// product_price, product_status, product_desc, product_img, product_category,
	// SellerID from PRODUCT where product_name =?";
	// private static final String SELECT_PRODUCT_BY_CATEGORY = "select
	// product_name, product_price, product_status, product_desc, product_img,
	// product_category, SellerID from PRODUCT where product_category =?";
	// private static final String SELECT_PRODUCT_BY_ID = "select * from PRODUCT
	// where productID = ?";
	private static final String SELECT_ALL_PRODUCTS = "select * from PRODUCT";
	private static final String DELETE_PRODUCT_BY_ID = "delete from PRODUCT where productID = ?;";
	private static final String UPDATE_PRODUCT = "update PRODUCT set product_name= ?, product_price =?, product_status =?, product_desc =?, product_img =?, product_category = ? where productID = ?;";

	public ProductDaoImpl() {
	}

	private static ProductDaoImpl instance = new ProductDaoImpl();

	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void registerProduct(Product product) throws ClassNotFoundException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rset = null;

		try {

			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(CREATE_ID_SQL);
			rset = preparedStatement.executeQuery();
			int ID = 1;
			if (rset.next()) {
				ID = rset.getInt(1) + 1;
			}
			preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL);

			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setString(4, product.getStatus());
			preparedStatement.setString(5, product.getDesc());
			preparedStatement.setString(6, product.getImg());
			preparedStatement.setString(7, product.getCategory());
			preparedStatement.setString(8, product.getSeller());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCUtils.printSQLException(e);
		}
	}

	@Override
	public ArrayList<Product> selectAllProducts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Product> products = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");
				String product_status = rs.getString("product_status");
				String product_desc = rs.getString("product_desc");
				String product_img = rs.getString("product_img");
				String product_category = rs.getString("product_category");
				String product_seller = rs.getString("sellerID");

				products.add(new Product(productID, product_name, product_price, product_status, product_desc,
						product_img, product_category, product_seller));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return products;
	}

	@Override
	public ArrayList<Product> selectProductName(String productname) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Product> products = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM PRODUCT WHERE product_name like '%" + productname + "%'");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");
				String product_status = rs.getString("product_status");
				String product_desc = rs.getString("product_desc");
				String product_img = rs.getString("product_img");
				String product_category = rs.getString("product_category");
				String product_seller = rs.getString("sellerID");

				products.add(new Product(productID, product_name, product_price, product_status, product_desc,
						product_img, product_category, product_seller));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return products;
	}

	@Override
	public ArrayList<Product> selectProductCategory(String productcategory) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Product> products = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT * FROM PRODUCT WHERE product_category = '" + productcategory + "'");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");
				String product_status = rs.getString("product_status");
				String product_desc = rs.getString("product_desc");
				String product_img = rs.getString("product_img");
				String product_category = rs.getString("product_category");
				String product_seller = rs.getString("sellerID");

				products.add(new Product(productID, product_name, product_price, product_status, product_desc,
						product_img, product_category, product_seller));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return products;
	}

	@Override
	public Product selectProductId(int id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		Product product = null;

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from PRODUCT where productID = '" + id + "'");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				product = new Product();
				product.setID(rs.getInt("productID"));
				product.setName(rs.getString("product_name"));
				product.setPrice(rs.getInt("product_price"));
				product.setStatus(rs.getString("product_status"));
				product.setDesc(rs.getString("product_desc"));
				product.setImg(rs.getString("product_img"));
				product.setCategory(rs.getString("product_category"));
				product.setSeller(rs.getString("sellerID"));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return product;
	}

	@Override
	public boolean deleteProduct(int productID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);) {
			statement.setInt(1, productID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateProduct(int productID, String product_name, int product_price, String product_status,
			String product_desc, String product_img, String product_category) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);) {
			preparedStatement.setString(1, product_name);
			preparedStatement.setInt(2, product_price);
			preparedStatement.setString(3, product_status);
			preparedStatement.setString(4, product_desc);
			preparedStatement.setString(5, product_img);
			preparedStatement.setString(6, product_category);
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
