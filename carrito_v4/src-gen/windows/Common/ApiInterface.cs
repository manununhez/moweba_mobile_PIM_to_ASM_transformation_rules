
//Start of user code imports
using Kulman.WPA81.BaseRestService.Services.Abstract;
using CarritoDeCompras.Model;
using System;
using System.Threading.Tasks;
using System.Collections.Generic;
//End of user code

namespace CarritoDeCompras.Common
{
    class ApiInterface : BaseRestService
    {
        protected override string GetBaseUrl()
        {
            return "http://www.api2.cart.com.py";
        }

		 public Task<Boolean> login( User user)  
        {
			return Post<Boolean>("POST" , user );
		}

		 public Task<Boolean> logout()  
        {
			return Post<Boolean>("POST" , null);
		}

		 public Task<List<Product>> getAllProducts()  
        {
			return Get<List<Product>>("GET");
		}

		 public Task<Product> getProduct()  
        {
			return Get<Product>("GET");
		}

		 public Task<List<Provider>> getAllProviders()  
        {
			return Get<List<Provider>>("GET");
		}

		 public Task<Provider> getProvider()  
        {
			return Get<Provider>("GET");
		}

		 public Task<Boolean> confirmCart( Product products)  
        {
			return Post<Boolean>("POST" , products );
		}

		 public Task<List<ShoppingCart>> getUserCart()  
        {
			return Get<List<ShoppingCart>>("GET");
		}
    }
}
