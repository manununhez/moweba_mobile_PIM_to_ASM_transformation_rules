
package com.example.carritodecompras.beans;

//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class User  implements Serializable{
	

	/**
	* the ruc attribute.
	*/
	private String ruc;


	/**
	* the mail attribute.
	*/
	private String mail;


	/**
	* the username attribute.
	*/
	private String username;


	/**
	* the password attribute.
	*/
	private String password;
	

	/**
	* Empty Constructor.
	*/
	public User (){
	}

	/**
	* Constructor.
	*/
	public User (String ruc, String mail, String username, String password){
		this.ruc = ruc;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}

	public String getRuc() {
       return this.ruc;
     }

	public String getMail() {
       return this.mail;
     }

	public String getUsername() {
       return this.username;
     }

	public String getPassword() {
       return this.password;
     }
 
     public void setRuc(String ruc) {
        this.ruc = ruc;
     }

     public void setMail(String mail) {
        this.mail = mail;
     }

     public void setUsername(String username) {
        this.username = username;
     }

     public void setPassword(String password) {
        this.password = password;
     }


}
