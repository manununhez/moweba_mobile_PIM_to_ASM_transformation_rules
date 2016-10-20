//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    class User 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

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
		public User (string username, string password){
			this.username = username;     
			this.password = password;     
		}
    }
}

