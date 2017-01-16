
package com.example.carritodecompras.beans;

//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class ImageProduct  implements Serializable{
	

	/**
	* the image attribute.
	*/
	private String image;


	/**
	* the idImageProduct attribute.
	*/
	private Integer idImageProduct;
	

	/**
	* Empty Constructor.
	*/
	public ImageProduct (){
	}

	/**
	* Constructor.
	*/
	public ImageProduct (String image, Integer idImageProduct){
		this.image = image;
		this.idImageProduct = idImageProduct;
	}

	public String getImage() {
       return this.image;
     }

	public Integer getIdImageProduct() {
       return this.idImageProduct;
     }
 
     public void setImage(String image) {
        this.image = image;
     }

     public void setIdImageProduct(Integer idImageProduct) {
        this.idImageProduct = idImageProduct;
     }


}
