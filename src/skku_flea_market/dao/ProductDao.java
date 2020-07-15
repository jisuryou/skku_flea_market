package skku_flea_market.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import skku_flea_market.model.Product;

public interface ProductDao {
	void registerProduct(Product product) throws ClassNotFoundException;

	ArrayList<Product> selectAllProducts();

	ArrayList<Product> selectProductName(String productname);

	ArrayList<Product> selectProductCategory(String productcategory);
	
	Product selectProductId(int id);

	boolean deleteProduct(int productID) throws SQLException;

	boolean updateProduct(int productID, String product_name, int product_price, String product_status,
			String product_desc, String product_img, String product_category) throws SQLException;

}
