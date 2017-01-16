//Start of user code imports
using System;
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class ShoppingCart 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public int idCart { get; set; }

		[DataMember]
		public string price { get; set; }

		[DataMember]
		public int quantity { get; set; }

		[DataMember]
		public int idProduct { get; set; }

		[DataMember]
		public double syncTime { get; set; }

		/**
		* Empty Constructor.
		*/
		public ShoppingCart (){
		}
	
		/**
		* Constructor.
		*/
		public ShoppingCart (int idCart, string price, int quantity, int idProduct, double syncTime){
			this.idCart = idCart;     
			this.price = price;     
			this.quantity = quantity;     
			this.idProduct = idProduct;     
			this.syncTime = syncTime;     
		}

		public String getTotalCarPrice() {
		// Start of user code getTotalCarPrice
		// TODO should be implemented
		// End of user code
			return;
		}

		public int getCartProductCount() {
		// Start of user code getCartProductCount
		// TODO should be implemented
		// End of user code
			return;
		}
    }
}

