package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class Provider {
	

	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the ruc attribute.
	*/
	private String ruc;


	/**
	* the nombre attribute.
	*/
	private String nombre;


	/**
	* the description attribute.
	*/
	private String description;
	

	/**
	* Empty Constructor.
	*/
	public Provider provider (){
	}

	/**
	* Constructor.
	*/
	public Provider provider (
	String idProvider
,	String ruc
,	String nombre
,	String description
	){
		this.idProvider = idProvider;
		this.ruc = ruc;
		this.nombre = nombre;
		this.description = description;
	}
 
	public String getIdProvider() {
       return this.idProvider;
     }

	public String getRuc() {
       return this.ruc;
     }

	public String getNombre() {
       return this.nombre;
     }

	public String getDescription() {
       return this.description;
     }
 
     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public void setDescription(String description) {
        this.description = description;
     }


}
