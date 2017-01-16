
package com.example.carritodecompras.beans;

//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class Provider  implements Serializable{
	

	/**
	* the description attribute.
	*/
	private String description;


	/**
	* the idProvider attribute.
	*/
	private Integer idProvider;


	/**
	* the ruc attribute.
	*/
	private String ruc;


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
	public Provider (String description, Integer idProvider, String ruc, String nombre){
		this.description = description;
		this.idProvider = idProvider;
		this.ruc = ruc;
		this.nombre = nombre;
	}

	public String getDescription() {
       return this.description;
     }

	public Integer getIdProvider() {
       return this.idProvider;
     }

	public String getRuc() {
       return this.ruc;
     }

	public String getNombre() {
       return this.nombre;
     }
 
     public void setDescription(String description) {
        this.description = description;
     }

     public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
     }

     public void setRuc(String ruc) {
        this.ruc = ruc;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
     }


}
