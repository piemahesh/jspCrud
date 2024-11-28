package curd_proj.model;

public class WishList {
	private Integer id, count;
	private String productName, productDetails, email, endDate;

	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", count=" + count + ", productName=" + productName + ", productDetails="
				+ productDetails + ", email=" + email + ", endDate=" + endDate + "]";
	}
	
	public WishList() {
		// TODO Auto-generated constructor stub
	}

	public WishList(Integer count, String productName, String productDetails) {

		this.count = count;
		this.productName = productName;
		this.productDetails = productDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
