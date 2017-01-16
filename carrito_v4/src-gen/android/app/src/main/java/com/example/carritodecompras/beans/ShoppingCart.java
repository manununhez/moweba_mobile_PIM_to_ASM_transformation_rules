
package com.example.carritodecompras.beans;

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
	* the price attribute.
	*/
	private String price;


	/**
	* the quantity attribute.
	*/
	private Integer quantity;


	/**
	* the idProduct attribute.
	*/
	private Integer idProduct;


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
	public ShoppingCart (Integer idCart, String price, Integer quantity, Integer idProduct, BigDecimal syncTime){
		this.idCart = idCart;
		this.price = price;
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.syncTime = syncTime;
	}

	public Integer getIdCart() {
       return this.idCart;
     }

	public String getPrice() {
       return this.price;
     }

	public Integer getQuantity() {
       return this.quantity;
     }

	public Integer getIdProduct() {
       return this.idProduct;
     }

	public BigDecimal getSyncTime() {
       return this.syncTime;
     }
 
     public void setIdCart(Integer idCart) {
        this.idCart = idCart;
     }

     public void setPrice(String price) {
        this.price = price;
     }

     public void setQuantity(Integer quantity) {
        this.quantity = quantity;
     }

     public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
     }

     public void setSyncTime(BigDecimal syncTime) {
        this.syncTime = syncTime;
     }

	public String getTotalCarPrice() {
	// Start of user code getTotalCarPrice
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
