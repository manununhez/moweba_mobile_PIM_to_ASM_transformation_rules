package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class ShoppingCart {
	

	/**
	* the syncTime attribute.
	*/
	private String syncTime;


	/**
	* the quantity attribute.
	*/
	private String quantity;


	/**
	* the idCart attribute.
	*/
	private Integer idCart;
	

	/**
	* Empty Constructor.
	*/
	public ShoppingCart shoppingCart (){
	}

	/**
	* Constructor.
	*/
	public ShoppingCart shoppingCart (
	String syncTime
,	String quantity
,	Integer idCart
	){
		this.syncTime = syncTime;
		this.quantity = quantity;
		this.idCart = idCart;
	}
 
	public String getSyncTime() {
       return this.syncTime;
     }

	public String getQuantity() {
       return this.quantity;
     }

	public Integer getIdCart() {
       return this.idCart;
     }
 
     public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
     }

     public void setQuantity(String quantity) {
        this.quantity = quantity;
     }

     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }


}
