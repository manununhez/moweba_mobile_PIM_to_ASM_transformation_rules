//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class Provider 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public int idProvider { get; set; }

		[DataMember]
		public string ruc { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public string nombre { get; set; }

		/**
		* Empty Constructor.
		*/
		public Provider (){
		}
	
		/**
		* Constructor.
		*/
		public Provider (int idProvider, string ruc, string description, string nombre){
			this.idProvider = idProvider;     
			this.ruc = ruc;     
			this.description = description;     
			this.nombre = nombre;     
		}
    }
}

