//Start of user code imports
import java.io.Serializable;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the code attribute.
	*/
	private String code;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the idProducto attribute.
	*/
	private String idProducto;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the price attribute.
	*/
	private String price;
	

	/**
	* Empty Constructor.
	*/
	public Product (){
	}

	/**
	* Constructor.
	*/
	public Product (String code, String idImageProduct, String idProvider, String idProducto, String name, String description, String price){
		this.code = code;
		this.idImageProduct = idImageProduct;
		this.idProvider = idProvider;
		this.idProducto = idProducto;
		this.name = name;
		this.description = description;
		this.price = price;
	}
 
	public String getCode() {
       return this.code;
     }

	public String getIdImageProduct() {
       return this.idImageProduct;
     }

	public String getIdProvider() {
       return this.idProvider;
     }

	public String getIdProducto() {
       return this.idProducto;
     }

	public String getName() {
       return this.name;
     }

	public String getDescription() {
       return this.description;
     }

	public String getPrice() {
       return this.price;
     }
 
     public void setCode(String code) {
        this.code = code;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setPrice(String price) {
        this.price = price;
     }

	public String getProductPriceWithCurrency() {
	// Start of user code getProductPriceWithCurrency
	// TODO should be implemented
	// End of user code
	    }

}
