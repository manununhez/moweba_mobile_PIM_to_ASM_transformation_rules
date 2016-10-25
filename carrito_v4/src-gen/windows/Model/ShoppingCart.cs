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
		public string syncTime { get; set; }

		[DataMember]
		public int idCart { get; set; }

		[DataMember]
		public string quantity { get; set; }

		/**
		* Empty Constructor.
		*/
		public ShoppingCart (){
		}
	
		/**
		* Constructor.
		*/
		public ShoppingCart (string syncTime, int idCart, string quantity){
			this.syncTime = syncTime;     
			this.idCart = idCart;     
			this.quantity = quantity;     
		}
    }
}

