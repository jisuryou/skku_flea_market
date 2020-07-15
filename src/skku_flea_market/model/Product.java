package skku_flea_market.model;

public class Product {
	private int productID;
	private String product_name;
	private int product_price;
	private String product_status;
	private String product_desc;
	private String product_img;
	private String product_category;
	private String sellerID;

	public Product() {
	}

	public Product(String product_name, int product_price, String product_status, String product_desc,
			String product_img, String product_category, String sellerID) {
		super();

		this.product_name = product_name;
		this.product_price = product_price;
		this.product_status = product_status;
		this.product_desc = product_desc;
		this.product_img = product_img;
		this.product_category = product_category;
		this.sellerID = sellerID;
	}

	public Product(int productID, String product_name, int product_price, String product_status, String product_desc,
			String product_img, String product_category, String sellerID) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_status = product_status;
		this.product_desc = product_desc;
		this.product_img = product_img;
		this.product_category = product_category;
		this.sellerID = sellerID;
	}

	public int getID() {
		return productID;
	}

	public void setID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return product_name;
	}

	public void setName(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return product_price;
	}

	public void setPrice(int product_price) {
		this.product_price = product_price;
	}

	public String getImg() {
		return product_img;
	}

	public void setImg(String product_img) {
		this.product_img = product_img;
	}

	public String getStatus() {
		return product_status;
	}

	public void setStatus(String product_status) {
		this.product_status = product_status;
	}

	public String getDesc() {
		return product_desc;
	}

	public void setDesc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getCategory() {
		return product_category;
	}

	public void setCategory(String product_category) {
		this.product_category = product_category;
	}

	public String getSeller() {
		return sellerID;
	}

	public void setSeller(String sellerID) {
		this.sellerID = sellerID;
	}

}
