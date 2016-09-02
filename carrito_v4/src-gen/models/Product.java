	
package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class Product {
	

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
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


	/**
	* the price attribute.
	*/
	private String price;


	/**
	* the code attribute.
	*/
	private String code;
	
 
	public String getIdProducto() {
       return this.idProducto;
     }

	public String getName() {
       return this.name;
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

	public String getPrice() {
       return this.price;
     }

	public String getCode() {
       return this.code;
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

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
     }

     public void setPrice(String price) {
        this.price = price;
     }

     public void setCode(String code) {
        this.code = code;
     }

     public String getProductPriceWithCurrency() {
       //Start of user code getProductPriceWithCurrency
       // TODO should be implemented
       //End of user code

     }

}
