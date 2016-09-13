package Carrito de compras.Persistencia
	
//Start of user code imports
//End of user code
	
public class User {
	

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
	public User user (){
	}

	/**
	* Constructor.
	*/
	public User user (
	String username
,	String password
	){
		this.username = username;
		this.password = password;
	}
 
	public String getUsername() {
       return this.username;
     }

	public String getPassword() {
       return this.password;
     }
 
     public void setUsername(String username) {
        this.username = username;
     }

     public void setPassword(String password) {
        this.password = password;
     }


}
