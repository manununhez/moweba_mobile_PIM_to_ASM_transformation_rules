//Start of user code imports
import java.io.Serializable;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the price attribute.
	*/
	private String price;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the idProducto attribute.
	*/
	private String idProducto;


	/**
	* the code attribute.
	*/
	private String code;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;
	

	/**
	* Empty Constructor.
	*/
	public Product (){
	}

	/**
	* Constructor.
	*/
	public Product (String idProvider, String price, String description, String idProducto, String code, String name, String idImageProduct){
		this.idProvider = idProvider;
		this.price = price;
		this.description = description;
		this.idProducto = idProducto;
		this.code = code;
		this.name = name;
		this.idImageProduct = idImageProduct;
	}
 
	public String getIdProvider() {
       return this.idProvider;
     }

	public String getPrice() {
       return this.price;
     }

	public String getDescription() {
       return this.description;
     }

	public String getIdProducto() {
       return this.idProducto;
     }

	public String getCode() {
       return this.code;
     }

	public String getName() {
       return this.name;
     }

	public String getIdImageProduct() {
       return this.idImageProduct;
     }
 
     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setPrice(String price) {
        this.price = price;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
     }

     public void setCode(String code) {
        this.code = code;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

	public String getProductPriceWithCurrency() {
	// Start of user code getProductPriceWithCurrency
	// TODO should be implemented
	// End of user code
	    }

}
