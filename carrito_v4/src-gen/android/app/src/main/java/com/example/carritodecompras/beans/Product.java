
package com.example.carritodecompras.beans;

//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the price attribute.
	*/
	private String price;


	/**
	* the code attribute.
	*/
	private Integer code;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the taxPercentage attribute.
	*/
	private Integer taxPercentage;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


	/**
	* the idProduct attribute.
	*/
	private Integer idProduct;


	/**
	* the idImageProduct attribute.
	*/
	private Integer idImageProduct;
	

	/**
	* Empty Constructor.
	*/
	public Product (){
	}

	/**
	* Constructor.
	*/
	public Product (String price, Integer code, String description, Integer taxPercentage, String name, Integer idProvider, Integer idProduct, Integer idImageProduct){
		this.price = price;
		this.code = code;
		this.description = description;
		this.taxPercentage = taxPercentage;
		this.name = name;
		this.idProvider = idProvider;
		this.idProduct = idProduct;
		this.idImageProduct = idImageProduct;
	}

	public String getPrice() {
       return this.price;
     }

	public Integer getCode() {
       return this.code;
     }

	public String getDescription() {
       return this.description;
     }

	public Integer getTaxPercentage() {
       return this.taxPercentage;
     }

	public String getName() {
       return this.name;
     }

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public Integer getIdProduct() {
       return this.idProduct;
     }

	public Integer getIdImageProduct() {
       return this.idImageProduct;
     }
 
     public void setPrice(String price) {
        this.price = price;
     }

     public void setCode(Integer code) {
        this.code = code;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setTaxPercentage(Integer taxPercentage) {
        this.taxPercentage = taxPercentage;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
     }

     public void setIdImageProduct(Integer idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

	public String getProductPriceWithCurrency() {
	// Start of user code getProductPriceWithCurrency
	// TODO should be implemented
	// End of user code
		return;
	}

	public String getPriceWithTaxes() {
	// Start of user code getPriceWithTaxes
	// TODO should be implemented
	// End of user code
		return;
	}

}
