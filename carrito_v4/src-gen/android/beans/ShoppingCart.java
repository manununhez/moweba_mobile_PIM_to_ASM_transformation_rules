//Start of user code imports
import java.io.Serializable;
//End of user code

public class ShoppingCart  implements Serializable{
	

	/**
	* the syncTime attribute.
	*/
	private String syncTime;


	/**
	* the idCart attribute.
	*/
	private Integer idCart;


	/**
	* the quantity attribute.
	*/
	private String quantity;
	

	/**
	* Empty Constructor.
	*/
	public ShoppingCart (){
	}

	/**
	* Constructor.
	*/
	public ShoppingCart (String syncTime, Integer idCart, String quantity){
		this.syncTime = syncTime;
		this.idCart = idCart;
		this.quantity = quantity;
	}
 
	public String getSyncTime() {
       return this.syncTime;
     }

	public Integer getIdCart() {
       return this.idCart;
     }

	public String getQuantity() {
       return this.quantity;
     }
 
     public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
     }

     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }

     public void setQuantity(String quantity) {
        this.quantity = quantity;
     }


}
