	
package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class Provider {
	

	/**
	* the nombre attribute.
	*/
	private String nombre;


	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the ruc attribute.
	*/
	private String ruc;
	
 
	public String getNombre() {
       return this.nombre;
     }

	public String getIdProvider() {
       return this.idProvider;
     }

	public String getDescription() {
       return this.description;
     }

	public String getRuc() {
       return this.ruc;
     }
 
     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }


}
