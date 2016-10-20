//Start of user code imports
import java.io.Serializable;
//End of user code

public class ShoppingCart  implements Serializable{
	

	/**
	* the quantity attribute.
	*/
	private String quantity;


	/**
	* the syncTime attribute.
	*/
	private String syncTime;


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
	public ShoppingCart (String quantity, String syncTime, Integer idCart){
		this.quantity = quantity;
		this.syncTime = syncTime;
		this.idCart = idCart;
	}
 
	public String getQuantity() {
       return this.quantity;
     }

	public String getSyncTime() {
       return this.syncTime;
     }

	public Integer getIdCart() {
       return this.idCart;
     }
 
     public void setQuantity(String quantity) {
        this.quantity = quantity;
     }

     public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
     }

     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }


}
