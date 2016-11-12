//Start of user code imports
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class ImageProduct 
    {

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

