//Start of user code imports
import java.io.Serializable;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the price attribute.
	*/
	private String price;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the code attribute.
	*/
	private String code;


	/**
	* the idProducto attribute.
	*/
	private String idProducto;
	

	/**
	* Empty Constructor.
	*/
	public Product (){
	}

	/**
	* Constructor.
	*/
	public Product (String price, String description, String idProvider, String idImageProduct, String name, String code, String idProducto){
		this.price = price;
		this.description = description;
		this.idProvider = idProvider;
		this.idImageProduct = idImageProduct;
		this.name = name;
		this.code = code;
		this.idProducto = idProducto;
	}
 
	public String getPrice() {
       return this.price;
     }

	public String getDescription() {
       return this.description;
     }

	public String getIdProvider() {
       return this.idProvider;
     }

	public String getIdImageProduct() {
       return this.idImageProduct;
     }

	public String getName() {
       return this.name;
     }

	public String getCode() {
       return this.code;
     }

	public String getIdProducto() {
       return this.idProducto;
     }
 
     public void setPrice(String price) {
        this.price = price;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setCode(String code) {
        this.code = code;
     }

     public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
     }

     public String getProductPriceWithCurrency() {
       //Start of user code getProductPriceWithCurrency
       // TODO should be implemented
       //End of user code

     }

}
