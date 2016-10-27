//Start of user code imports
import java.io.Serializable;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


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
	private Integer idProducto;


	/**
	* the code attribute.
	*/
	private Integer code;


	/**
	* the name attribute.
	*/
	private String name;


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
	public Product (Integer idProvider, String price, String description, Integer idProducto, Integer code, String name, Integer idImageProduct){
		this.idProvider = idProvider;
		this.price = price;
		this.description = description;
		this.idProducto = idProducto;
		this.code = code;
		this.name = name;
		this.idImageProduct = idImageProduct;
	}

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public String getPrice() {
       return this.price;
     }

	public String getDescription() {
       return this.description;
     }

	public Integer getIdProducto() {
       return this.idProducto;
     }

	public Integer getCode() {
       return this.code;
     }

	public String getName() {
       return this.name;
     }

	public Integer getIdImageProduct() {
       return this.idImageProduct;
     }
 
     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setPrice(String price) {
        this.price = price;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
     }

     public void setCode(Integer code) {
        this.code = code;
     }

     public void setName(String name) {
        this.name = name;
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

}
