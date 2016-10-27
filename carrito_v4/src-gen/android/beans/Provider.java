//Start of user code imports
import java.io.Serializable;
//End of user code

public class Provider  implements Serializable{
	

	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


	/**
	* the ruc attribute.
	*/
	private String ruc;


	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the nombre attribute.
	*/
	private String nombre;
	

	/**
	* Empty Constructor.
	*/
	public Provider (){
	}

	/**
	* Constructor.
	*/
	public Provider (Integer idProvider, String ruc, String description, String nombre){
		this.idProvider = idProvider;
		this.ruc = ruc;
		this.description = description;
		this.nombre = nombre;
	}

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public String getRuc() {
       return this.ruc;
     }

	public String getDescription() {
       return this.description;
     }

	public String getNombre() {
       return this.nombre;
     }
 
     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }


}
