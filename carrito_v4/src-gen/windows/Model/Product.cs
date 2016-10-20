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
		public string code { get; set; }

		[DataMember]
		public string idImageProduct { get; set; }

		[DataMember]
		public string idProvider { get; set; }

		[DataMember]
		public string idProducto { get; set; }

		[DataMember]
		public string name { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public string price { get; set; }

		/**
		* Empty Constructor.
		*/
		public Product (){
		}
	
		/**
		* Constructor.
		*/
		public Product (string code, string idImageProduct, string idProvider, string idProducto, string name, string description, string price){
			this.code = code;     
			this.idImageProduct = idImageProduct;     
			this.idProvider = idProvider;     
			this.idProducto = idProducto;     
			this.name = name;     
			this.description = description;     
			this.price = price;     
		}
    }
}

