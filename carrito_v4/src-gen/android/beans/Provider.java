//Start of user code imports
import java.io.Serializable;
//End of user code

public class Provider  implements Serializable{
	

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
	* the ruc attribute.
	*/
	private String ruc;
	

	/**
	* Empty Constructor.
	*/
	public Provider (){
	}

	/**
	* Constructor.
	*/
	public Provider (String idProvider, String nombre, String description, String ruc){
		this.idProvider = idProvider;
		this.nombre = nombre;
		this.description = description;
		this.ruc = ruc;
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

	public String getRuc() {
       return this.ruc;
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

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }


}
