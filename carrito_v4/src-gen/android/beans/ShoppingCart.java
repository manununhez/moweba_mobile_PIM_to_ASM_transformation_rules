
//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class ShoppingCart  implements Serializable{
	

	/**
	* the idCart attribute.
	*/
	private Integer idCart;


	/**
	* the quantity attribute.
	*/
	private Integer quantity;


	/**
	* the syncTime attribute.
	*/
	private BigDecimal syncTime;
	

	/**
	* Empty Constructor.
	*/
	public ShoppingCart (){
	}

	/**
	* Constructor.
	*/
	public ShoppingCart (Integer idCart, Integer quantity, BigDecimal syncTime){
		this.idCart = idCart;
		this.quantity = quantity;
		this.syncTime = syncTime;
	}

	public Integer getIdCart() {
       return this.idCart;
     }

	public Integer getQuantity() {
       return this.quantity;
     }

	public BigDecimal getSyncTime() {
       return this.syncTime;
     }
 
     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }

     public void setQuantity(Integer quantity) {
        this.quantity = quantity;
     }

     public void setSyncTime(BigDecimal syncTime) {
        this.syncTime = syncTime;
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
