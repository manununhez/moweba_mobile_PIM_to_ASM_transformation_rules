//Start of user code imports
import java.io.Serializable;
//End of user code

public class ImageProduct  implements Serializable{
	

	/**
	* the idImageProduct attribute.
	*/
	private Integer idImageProduct;


	/**
	* the image attribute.
	*/
	private String image;
	

	/**
	* Empty Constructor.
	*/
	public ImageProduct (){
	}

	/**
	* Constructor.
	*/
	public ImageProduct (Integer idImageProduct, String image){
		this.idImageProduct = idImageProduct;
		this.image = image;
	}

	public Integer getIdImageProduct() {
       return this.idImageProduct;
     }

	public String getImage() {
       return this.image;
     }
 
     public void setIdImageProduct(Integer idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setImage(String image) {
        this.image = image;
     }


}
