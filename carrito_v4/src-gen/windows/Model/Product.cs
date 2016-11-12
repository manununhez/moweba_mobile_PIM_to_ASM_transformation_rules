//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class Product 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public int idProducto { get; set; }

		[DataMember]
		public string name { get; set; }

		[DataMember]
		public int idProvider { get; set; }

		[DataMember]
		public int idImageProduct { get; set; }

		[DataMember]
		public double price { get; set; }

		[DataMember]
		public int code { get; set; }

		/**
		* Empty Constructor.
		*/
		public Product (){
		}
	
		/**
		* Constructor.
		*/
		public Product (string description, int idProducto, string name, int idProvider, int idImageProduct, double price, int code){
			this.description = description;     
			this.idProducto = idProducto;     
			this.name = name;     
			this.idProvider = idProvider;     
			this.idImageProduct = idImageProduct;     
			this.price = price;     
			this.code = code;     
		}

		public String getProductPriceWithCurrency() {
		// Start of user code getProductPriceWithCurrency
		// TODO should be implemented
		// End of user code
			return;
		}
    }
}

