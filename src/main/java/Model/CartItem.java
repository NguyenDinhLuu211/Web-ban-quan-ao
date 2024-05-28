package Model;

public class CartItem {
    private Product product;
    private int quantity;
    //
	private int accountID;
	private int productID;
	private int maCart;
	private String size;
	
	

	public CartItem(int quantity, int accountID, int productID, int maCart, String size) {
		super();
		this.quantity = quantity;
		this.accountID = accountID;
		this.productID = productID;
		this.maCart = maCart;
		this.size = size;
	}

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getMaCart() {
		return maCart;
	}

	public void setMaCart(int maCart) {
		this.maCart = maCart;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
