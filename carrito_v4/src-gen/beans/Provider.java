//Start of user code imports
import java.io.Serializable;
//End of user code

public class Provider  implements Serializable{
	

	/**
	* the ruc attribute.
	*/
	private String ruc;


	/**
	* the idProvider attribute.
	*/
	private String idProvider;


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
	public Provider (){
	}

	/**
	* Constructor.
	*/
	public Provider (String ruc, String idProvider, String nombre, String description){
		this.ruc = ruc;
		this.idProvider = idProvider;
		this.nombre = nombre;
		this.description = description;
	}
 
	public String getRuc() {
       return this.ruc;
     }

	public String getIdProvider() {
       return this.idProvider;
     }

	public String getNombre() {
       return this.nombre;
     }

	public String getDescription() {
       return this.description;
     }
 
     public void setRuc(String ruc) {
        this.ruc = ruc;
     }

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public void setDescription(String description) {
        this.description = description;
     }


}
