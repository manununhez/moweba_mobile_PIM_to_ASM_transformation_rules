
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
import com.example.carritodecompras.activities.ShoppingCartActivity;
import com.example.carritodecompras.activities.ShoppingCartFormActivity;
import com.example.carritodecompras.bd.dao.ShoppingCartDAO;
import com.example.carritodecompras.beans.ShoppingCart;

import java.util.List;
//End of user code

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> {

    private List<ShoppingCart> shoppingCartList;
    private Context context;
    private ShoppingCartDAO shoppingCartDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvIdCart;
		private TextView tvPrice;
		private TextView tvQuantity;
		private TextView tvIdProduct;
		private TextView tvSyncTime;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvIdCart = (TextView) view.findViewById(R.id.tvIdCart);
			tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			tvQuantity = (TextView) view.findViewById(R.id.tvQuantity);
			tvIdProduct = (TextView) view.findViewById(R.id.tvIdProduct);
			tvSyncTime = (TextView) view.findViewById(R.id.tvSyncTime);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivEdit = (ImageView) view.findViewById(R.id.ivEdit);
        }
    }


    public ShoppingCartAdapter(Context context, List<ShoppingCart> shoppingCartList, ShoppingCartDAO shoppingCartDAO) {
        this.context = context;
		this.shoppingCartList = shoppingCartList;
        this.shoppingCartDAO = shoppingCartDAO;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_shoppingcart, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ShoppingCart shoppingCart = shoppingCartList.get(position);
		holder.tvIdCart.setText(String.valueOf(shoppingCart.getIdCart()));
		holder.tvPrice.setText(shoppingCart.getPrice());
		holder.tvQuantity.setText(String.valueOf(shoppingCart.getQuantity()));
		holder.tvIdProduct.setText(String.valueOf(shoppingCart.getIdProduct()));
		holder.tvSyncTime.setText(String.valueOf(shoppingCart.getSyncTime()));


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Go to the Form to edit an entry
                Intent intent = new Intent(context, ShoppingCartFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("shoppingCart", shoppingCart);
                ((ShoppingCartActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				//Delete an entry from the database
                shoppingCartDAO.deleteShoppingCart(shoppingCart);
                
				// Updating the recyclerView
				shoppingCartList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

				//Updating the total items count
                ((ShoppingCartActivity) context).getShoppingCartCount();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }
}

