//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    public class User 
    {

		[DataMember]
		public string password { get; set; }

		[DataMember]
		public string username { get; set; }

		/**
		* Empty Constructor.
		*/
		public User (){
		}
	
		/**
		* Constructor.
		*/
		public User (string password, string username){
			this.password = password;     
			this.username = username;     
		}
    }
}

