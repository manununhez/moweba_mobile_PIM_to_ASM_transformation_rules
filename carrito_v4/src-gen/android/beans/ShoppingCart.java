//Start of user code imports
import java.io.Serializable;
//End of user code

public class ShoppingCart  implements Serializable{
	

	/**
	* the syncTime attribute.
	*/
	private BigDecimal syncTime;


	/**
	* the quantity attribute.
	*/
	private Integer quantity;


	/**
	* the idCart attribute.
	*/
	private Integer idCart;
	

	/**
	* Empty Constructor.
	*/
	public ShoppingCart (){
	}

	/**
	* Constructor.
	*/
	public ShoppingCart (BigDecimal syncTime, Integer quantity, Integer idCart){
		this.syncTime = syncTime;
		this.quantity = quantity;
		this.idCart = idCart;
	}

	public BigDecimal getSyncTime() {
       return this.syncTime;
     }

	public Integer getQuantity() {
       return this.quantity;
     }

	public Integer getIdCart() {
       return this.idCart;
     }
 
     public void setSyncTime(BigDecimal syncTime) {
        this.syncTime = syncTime;
     }

     public void setQuantity(Integer quantity) {
        this.quantity = quantity;
     }

     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }

	public String getTotalCartPrice() {
	// Start of user code getTotalCartPrice
	// TODO should be implemented
	// End of user code
		return;
	}

	public int getCartProductCount() {
	// Start of user code getCartProductCount
	// TODO should be implemented
	// End of user code
		return;
	}

}
