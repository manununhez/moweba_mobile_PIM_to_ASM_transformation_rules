//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    class Product 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public int idProvider { get; set; }

		[DataMember]
		public string price { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public int idProducto { get; set; }

		[DataMember]
		public int code { get; set; }

		[DataMember]
		public string name { get; set; }

		[DataMember]
		public int idImageProduct { get; set; }

		/**
		* Empty Constructor.
		*/
		public Product (){
		}
	
		/**
		* Constructor.
		*/
		public Product (int idProvider, string price, string description, int idProducto, int code, string name, int idImageProduct){
			this.idProvider = idProvider;     
			this.price = price;     
			this.description = description;     
			this.idProducto = idProducto;     
			this.code = code;     
			this.name = name;     
			this.idImageProduct = idImageProduct;     
		}
    }
}

