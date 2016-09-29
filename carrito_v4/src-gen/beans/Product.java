//Start of user code imports
import java.io.Serializable;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the code attribute.
	*/
	private String code;


	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


	/**
	* the price attribute.
	*/
	private String price;


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
	public Product (String code, String idProvider, String name, String description, String idImageProduct, String price, String idProducto){
		this.code = code;
		this.idProvider = idProvider;
		this.name = name;
		this.description = description;
		this.idImageProduct = idImageProduct;
		this.price = price;
		this.idProducto = idProducto;
	}
 
	public String getCode() {
       return this.code;
     }

	public String getIdProvider() {
       return this.idProvider;
     }

	public String getName() {
       return this.name;
     }

	public String getDescription() {
       return this.description;
     }

	public String getIdImageProduct() {
       return this.idImageProduct;
     }

	public String getPrice() {
       return this.price;
     }

	public String getIdProducto() {
       return this.idProducto;
     }
 
     public void setCode(String code) {
        this.code = code;
     }

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setPrice(String price) {
        this.price = price;
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
