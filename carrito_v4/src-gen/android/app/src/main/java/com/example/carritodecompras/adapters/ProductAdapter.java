
package com.example.carritodecompras.adapters;

//Start of user code imports
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carritodecompras.R;
import com.example.carritodecompras.activities.ProductActivity;
import com.example.carritodecompras.activities.ProductFormActivity;
import com.example.carritodecompras.bd.dao.ProductDAO;
import com.example.carritodecompras.beans.Product;

import java.util.List;
//End of user code

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;
    private Context context;
    private ProductDAO productDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvPrice;
		private TextView tvCode;
		private TextView tvDescription;
		private TextView tvTaxPercentage;
		private TextView tvName;
		private TextView tvIdProvider;
		private TextView tvIdProduct;
		private TextView tvIdImageProduct;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			tvCode = (TextView) view.findViewById(R.id.tvCode);
			tvDescription = (TextView) view.findViewById(R.id.tvDescription);
			tvTaxPercentage = (TextView) view.findViewById(R.id.tvTaxPercentage);
			tvName = (TextView) view.findViewById(R.id.tvName);
			tvIdProvider = (TextView) view.findViewById(R.id.tvIdProvider);
			tvIdProduct = (TextView) view.findViewById(R.id.tvIdProduct);
			tvIdImageProduct = (TextView) view.findViewById(R.id.tvIdImageProduct);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivEdit = (ImageView) view.findViewById(R.id.ivEdit);
        }
    }


    public ProductAdapter(Context context, List<Product> productList, ProductDAO productDAO) {
        this.context = context;
		this.productList = productList;
        this.productDAO = productDAO;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Product product = productList.get(position);
		holder.tvPrice.setText(product.getPrice());
		holder.tvCode.setText(String.valueOf(product.getCode()));
		holder.tvDescription.setText(product.getDescription());
		holder.tvTaxPercentage.setText(String.valueOf(product.getTaxPercentage()));
		holder.tvName.setText(product.getName());
		holder.tvIdProvider.setText(String.valueOf(product.getIdProvider()));
		holder.tvIdProduct.setText(String.valueOf(product.getIdProduct()));
		holder.tvIdImageProduct.setText(String.valueOf(product.getIdImageProduct()));


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Go to the Form to edit an entry
                Intent intent = new Intent(context, ProductFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("product", product);
                ((ProductActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				//Delete an entry from the database
                productDAO.deleteProduct(product);
                
				// Updating the recyclerView
				productList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

				//Updating the total items count
                ((ProductActivity) context).getProductCount();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

