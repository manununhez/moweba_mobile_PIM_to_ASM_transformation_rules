//Start of user code imports
import java.io.Serializable;
//End of user code

public class User  implements Serializable{
	

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
	public User (String username, String password){
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
