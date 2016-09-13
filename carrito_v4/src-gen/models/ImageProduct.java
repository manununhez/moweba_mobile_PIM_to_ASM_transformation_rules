package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class ImageProduct {
	

	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


	/**
	* the image attribute.
	*/
	private String image;
	

	/**
	* Empty Constructor.
	*/
	public ImageProduct imageProduct (){
	}

	/**
	* Constructor.
	*/
	public ImageProduct imageProduct (
	String idImageProduct
,	String image
	){
		this.idImageProduct = idImageProduct;
		this.image = image;
	}
 
	public String getIdImageProduct() {
       return this.idImageProduct;
     }

	public String getImage() {
       return this.image;
     }
 
     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setImage(String image) {
        this.image = image;
     }


}
