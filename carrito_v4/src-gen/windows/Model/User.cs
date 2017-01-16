//Start of user code imports
using System;
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class User 
    {

		[DataMember]
		public string ruc { get; set; }

		[DataMember]
		public string mail { get; set; }

		[DataMember]
		public string username { get; set; }

		[DataMember]
		public string password { get; set; }

		/**
		* Empty Constructor.
		*/
		public User (){
		}
	
		/**
		* Constructor.
		*/
		public User (string ruc, string mail, string username, string password){
			this.ruc = ruc;     
			this.mail = mail;     
			this.username = username;     
			this.password = password;     
		}

    }
}

