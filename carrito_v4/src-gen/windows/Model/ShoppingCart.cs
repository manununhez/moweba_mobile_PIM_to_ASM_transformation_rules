//Start of user code imports
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
		public double syncTime { get; set; }

		[DataMember]
		public int quantity { get; set; }

		[DataMember]
		public int idCart { get; set; }

		/**
		* Empty Constructor.
		*/
		public ShoppingCart (){
		}
	
		/**
		* Constructor.
		*/
		public ShoppingCart (double syncTime, int quantity, int idCart){
			this.syncTime = syncTime;     
			this.quantity = quantity;     
			this.idCart = idCart;     
		}
    }
}

