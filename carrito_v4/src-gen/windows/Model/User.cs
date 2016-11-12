//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class User 
    {

		[DataMember]
		public float username { get; set; }

		[DataMember]
		public double password { get; set; }

		/**
		* Empty Constructor.
		*/
		public User (){
		}
	
		/**
		* Constructor.
		*/
		public User (float username, double password){
			this.username = username;     
			this.password = password;     
		}

    }
}

