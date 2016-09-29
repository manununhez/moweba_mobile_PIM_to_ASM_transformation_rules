//Start of user code imports
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
//End of user code

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> {

    private List<ShoppingCart> shoppingCartList;
    private Context context;
    private ShoppingCartDAO shoppingCartDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvSyncTime;
		private TextView tvIdCart;
		private TextView tvQuantity;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvSyncTime = (TextView) view.findViewById(R.id.tvSyncTime);
			tvIdCart = (TextView) view.findViewById(R.id.tvIdCart);
			tvQuantity = (TextView) view.findViewById(R.id.tvQuantity);
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
		holder.tvSyncTime.setText(shoppingCart.getSyncTime());
		holder.tvIdCart.setText(String.valueOf(shoppingCart.getIdCart()));
		holder.tvQuantity.setText(shoppingCart.getQuantity());

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCartDAO.deleteShoppingCart(shoppingCart);
                shoppingCartList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                ((ShoppingCartActivity) context).getShoppingCartCount();
            }
        });

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShoppingCartFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("shoppingCart", shoppingCart);
                ((ShoppingCartActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }
}

