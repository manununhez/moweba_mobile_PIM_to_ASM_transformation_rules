//Start of user code imports
import java.io.Serializable;
//End of user code

public class Provider  implements Serializable{
	

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
	* the idProvider attribute.
	*/
	private String idProvider;
	

	/**
	* Empty Constructor.
	*/
	public Provider (){
	}

	/**
	* Constructor.
	*/
	public Provider (String nombre, String description, String ruc, String idProvider){
		this.nombre = nombre;
		this.description = description;
		this.ruc = ruc;
		this.idProvider = idProvider;
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

	public String getIdProvider() {
       return this.idProvider;
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

     public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
     }


}
