	
package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class ShoppingCart {
	

	/**
	* the id attribute.
	*/
	private String id;


	/**
	* the quantity attribute.
	*/
	private String quantity;


	/**
	* the syncTime attribute.
	*/
	private String syncTime;


	/**
	* the idProduct attribute.
	*/
	private String idProduct;
	
 
	public String getId() {
       return this.id;
     }

	public String getQuantity() {
       return this.quantity;
     }

	public String getSyncTime() {
       return this.syncTime;
     }

	public String getIdProduct() {
       return this.idProduct;
     }
 
     public void setId(String id) {
        this.id = id;
     }

     public void setQuantity(String quantity) {
        this.quantity = quantity;
     }

     public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
     }

     public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
     }


}
