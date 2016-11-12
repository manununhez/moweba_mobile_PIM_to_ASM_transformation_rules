
//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class Product  implements Serializable{
	

	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the idProducto attribute.
	*/
	private Integer idProducto;


	/**
	* the name attribute.
	*/
	private String name;


	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


	/**
	* the idImageProduct attribute.
	*/
	private Integer idImageProduct;


	/**
	* the price attribute.
	*/
	private BigDecimal price;


	/**
	* the code attribute.
	*/
	private Integer code;
	

	/**
	* Empty Constructor.
	*/
	public Product (){
	}

	/**
	* Constructor.
	*/
	public Product (String description, Integer idProducto, String name, Integer idProvider, Integer idImageProduct, BigDecimal price, Integer code){
		this.description = description;
		this.idProducto = idProducto;
		this.name = name;
		this.idProvider = idProvider;
		this.idImageProduct = idImageProduct;
		this.price = price;
		this.code = code;
	}

	public String getDescription() {
       return this.description;
     }

	public Integer getIdProducto() {
       return this.idProducto;
     }

	public String getName() {
       return this.name;
     }

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public Integer getIdImageProduct() {
       return this.idImageProduct;
     }

	public BigDecimal getPrice() {
       return this.price;
     }

	public Integer getCode() {
       return this.code;
     }
 
     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setIdImageProduct(Integer idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setPrice(BigDecimal price) {
        this.price = price;
     }

     public void setCode(Integer code) {
        this.code = code;
     }

	public String getProductPriceWithCurrency() {
	// Start of user code getProductPriceWithCurrency
	// TODO should be implemented
	// End of user code
		return;
	}

}
