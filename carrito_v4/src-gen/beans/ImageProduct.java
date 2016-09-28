//Start of user code imports
import java.io.Serializable;
//End of user code

public class ImageProduct  implements Serializable{
	

	/**
	* the image attribute.
	*/
	private String image;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;
	

	/**
	* Empty Constructor.
	*/
	public ImageProduct (){
	}

	/**
	* Constructor.
	*/
	public ImageProduct (String image, String idImageProduct){
		this.image = image;
		this.idImageProduct = idImageProduct;
	}
 
	public String getImage() {
       return this.image;
     }

	public String getIdImageProduct() {
       return this.idImageProduct;
     }
 
     public void setImage(String image) {
        this.image = image;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }


}
