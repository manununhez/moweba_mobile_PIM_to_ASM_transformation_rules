//Start of user code imports
using System;
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
		public string price { get; set; }

		[DataMember]
		public int code { get; set; }

		[DataMember]
		public string description { get; set; }

		[DataMember]
		public int taxPercentage { get; set; }

		[DataMember]
		public string name { get; set; }

		[DataMember]
		public int idProvider { get; set; }

		[DataMember]
		public int idProduct { get; set; }

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
		public Product (string price, int code, string description, int taxPercentage, string name, int idProvider, int idProduct, int idImageProduct){
			this.price = price;     
			this.code = code;     
			this.description = description;     
			this.taxPercentage = taxPercentage;     
			this.name = name;     
			this.idProvider = idProvider;     
			this.idProduct = idProduct;     
			this.idImageProduct = idImageProduct;     
		}

		public String getProductPriceWithCurrency() {
		// Start of user code getProductPriceWithCurrency
		// TODO should be implemented
		// End of user code
			return;
		}

		public String getPriceWithTaxes() {
		// Start of user code getPriceWithTaxes
		// TODO should be implemented
		// End of user code
			return;
		}
    }
}

