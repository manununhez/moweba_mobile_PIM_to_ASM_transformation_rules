
//Start of user code imports
import java.io.Serializable;
import java.math.BigDecimal;
//End of user code

public class User  implements Serializable{
	

	/**
	* the username attribute.
	*/
	private Float username;


	/**
	* the password attribute.
	*/
	private BigDecimal password;
	

	/**
	* Empty Constructor.
	*/
	public User (){
	}

	/**
	* Constructor.
	*/
	public User (Float username, BigDecimal password){
		this.username = username;
		this.password = password;
	}

	public Float getUsername() {
       return this.username;
     }

	public BigDecimal getPassword() {
       return this.password;
     }
 
     public void setUsername(Float username) {
        this.username = username;
     }

     public void setPassword(BigDecimal password) {
        this.password = password;
     }


}
