
//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class Provider  implements Serializable{
	

	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


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
	private Float ruc;
	

	/**
	* Empty Constructor.
	*/
	public Provider (){
	}

	/**
	* Constructor.
	*/
	public Provider (Integer idProvider, String nombre, String description, Float ruc){
		this.idProvider = idProvider;
		this.nombre = nombre;
		this.description = description;
		this.ruc = ruc;
	}

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public String getNombre() {
       return this.nombre;
     }

	public String getDescription() {
       return this.description;
     }

	public Float getRuc() {
       return this.ruc;
     }
 
     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public void setDescription(String description) {
        this.description = description;
     }

     public void setRuc(Float ruc) {
        this.ruc = ruc;
     }


}
