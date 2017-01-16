//Start of user code imports
using System;
using System.Runtime.Serialization;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Model
{
    [DataContract]
    public class ImageProduct 
    {

		[DataMember]
		public string image { get; set; }

		[DataMember]
		public int idImageProduct { get; set; }

		/**
		* Empty Constructor.
		*/
		public ImageProduct (){
		}
	
		/**
		* Constructor.
		*/
		public ImageProduct (string image, int idImageProduct){
			this.image = image;     
			this.idImageProduct = idImageProduct;     
		}

    }
}

