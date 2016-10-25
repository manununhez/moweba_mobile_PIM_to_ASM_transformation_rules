//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    class Provider 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public string idProvider { get; set; }

		[DataMember]
		public string nombre { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public string ruc { get; set; }

		/**
		* Empty Constructor.
		*/
		public Provider (){
		}
	
		/**
		* Constructor.
		*/
		public Provider (string idProvider, string nombre, string description, string ruc){
			this.idProvider = idProvider;     
			this.nombre = nombre;     
			this.description = description;     
			this.ruc = ruc;     
		}
    }
}

