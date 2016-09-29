//Start of user code imports
import java.io.Serializable;
//End of user code

public class ShoppingCart  implements Serializable{
	

	/**
	* the quantity attribute.
	*/
	private String quantity;


	/**
	* the idCart attribute.
	*/
	private Integer idCart;


	/**
	* the syncTime attribute.
	*/
	private String syncTime;
	

	/**
	* Empty Constructor.
	*/
	public ShoppingCart (){
	}

	/**
	* Constructor.
	*/
	public ShoppingCart (String quantity, Integer idCart, String syncTime){
		this.quantity = quantity;
		this.idCart = idCart;
		this.syncTime = syncTime;
	}
 
	public String getQuantity() {
       return this.quantity;
     }

	public Integer getIdCart() {
       return this.idCart;
     }

	public String getSyncTime() {
       return this.syncTime;
     }
 
     public void setQuantity(String quantity) {
        this.quantity = quantity;
     }

     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }

     public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
     }


}
