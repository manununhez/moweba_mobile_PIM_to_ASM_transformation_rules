package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class Product {
	

	/**
	* the idImageProduct attribute.
	*/
	private String idImageProduct;


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
	* the price attribute.
	*/
	private String price;


	/**
	* the idProducto attribute.
	*/
	private String idProducto;


	/**
	* the description attribute.
	*/
	private String description;
	

	/**
	* Empty Constructor.
	*/
	public Product product (){
	}

	/**
	* Constructor.
	*/
	public Product product (
	String idImageProduct
,	String code
,	String idProvider
,	String name
,	String price
,	String idProducto
,	String description
	){
		this.idImageProduct = idImageProduct;
		this.code = code;
		this.idProvider = idProvider;
		this.name = name;
		this.price = price;
		this.idProducto = idProducto;
		this.description = description;
	}
 
	public String getIdImageProduct() {
       return this.idImageProduct;
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

	public String getPrice() {
       return this.price;
     }

	public String getIdProducto() {
       return this.idProducto;
     }

	public String getDescription() {
       return this.description;
     }
 
     public void setIdImageProduct(String idImageProduct) {
        this.idImageProduct = idImageProduct;
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

     public void setPrice(String price) {
        this.price = price;
     }

     public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public String getProductPriceWithCurrency() {
       //Start of user code getProductPriceWithCurrency
       // TODO should be implemented
       //End of user code

     }

}
