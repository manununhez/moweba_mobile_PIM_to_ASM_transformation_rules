
//Start of user code imports
using Kulman.WPA81.BaseRestService.Services.Abstract;
using ShoppingCartApp.Model;
using System.Threading.Tasks;
//End of user code


namespace Data.Common
{
    class ApiInterface : BaseRestService
    {
        protected override string GetBaseUrl()
        {
            return "http://www.api2.cart.com.py";
        }

		 public Task<Boolean> login( User user)  
        {
			return Post<Boolean>("login" , user);
		}

		 public Task<Boolean> logout()  
        {
			return Post<Boolean>("logout");
		}

		 public Task<List<Product>> getAllProducts()  
        {
			return Get<List<Product>>("products");
		}

		 public Task<Product> getProduct()  
        {
			return Get<Product>("products");
		}

		 public Task<List<Provider>> getAllProviders()  
        {
			return Get<List<Provider>>("provider");
		}

		 public Task<Provider> getProvider()  
        {
			return Get<Provider>("provider");
		}

		 public Task<Boolean> confirmCart( Product products)  
        {
			return Post<Boolean>("cart/confirm" , products);
		}

		 public Task<List<ShoppingCart>> getUserCart()  
        {
			return Get<List<ShoppingCart>>("cart");
		}
    }
}
