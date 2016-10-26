//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    class ShoppingCart 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public decimal syncTime { get; set; }

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
		public ShoppingCart (decimal syncTime, int quantity, int idCart){
			this.syncTime = syncTime;     
			this.quantity = quantity;     
			this.idCart = idCart;     
		}
    }
}

