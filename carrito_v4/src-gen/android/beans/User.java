//Start of user code imports
import java.io.Serializable;
//End of user code

public class User  implements Serializable{
	

	/**
	* the password attribute.
	*/
	private String password;


	/**
	* the username attribute.
	*/
	private String username;
	

	/**
	* Empty Constructor.
	*/
	public User (){
	}

	/**
	* Constructor.
	*/
	public User (String password, String username){
		this.password = password;
		this.username = username;
	}
 
	public String getPassword() {
       return this.password;
     }

	public String getUsername() {
       return this.username;
     }
 
     public void setPassword(String password) {
        this.password = password;
     }

     public void setUsername(String username) {
        this.username = username;
     }


}
