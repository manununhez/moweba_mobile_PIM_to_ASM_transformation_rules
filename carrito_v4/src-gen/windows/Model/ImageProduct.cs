//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace Data.Model
{
    [DataContract]
    class ImageProduct 
    {
		//The Id property is marked as the Primary Key
        [SQLite.PrimaryKey, SQLite.AutoIncrement]
        [DataMember]
        public int Id { get; set; }

		[DataMember]
		public int idImageProduct { get; set; }

		[DataMember]
		public string image { get; set; }

		/**
		* Empty Constructor.
		*/
		public ImageProduct (){
		}
	
		/**
		* Constructor.
		*/
		public ImageProduct (int idImageProduct, string image){
			this.idImageProduct = idImageProduct;     
			this.image = image;     
		}
    }
}

