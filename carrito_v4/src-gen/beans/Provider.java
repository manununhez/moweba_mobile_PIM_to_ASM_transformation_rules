//Start of user code imports
import java.io.Serializable;
//End of user code

public class Provider  implements Serializable{
	

	/**
	* the idProvider attribute.
	*/
	private String idProvider;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the nombre attribute.
	*/
	private String nombre;


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
	public Provider (String idProvider, String description, String nombre, String ruc){
		this.idProvider = idProvider;
		this.description = description;
		this.nombre = nombre;
		this.ruc = ruc;
	}
 
	public String getIdProvider() {
       return this.idProvider;
     }

	public String getDescription() {
       return this.description;
     }

	public String getNombre() {
       return this.nombre;
     }

	public String getRuc() {
       return this.ruc;
     }
 
     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }


}
