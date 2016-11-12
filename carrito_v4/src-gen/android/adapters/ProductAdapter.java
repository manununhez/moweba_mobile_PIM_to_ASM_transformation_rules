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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;
    private Context context;
    private ProductDAO productDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvDescription;
		private TextView tvIdProducto;
		private TextView tvName;
		private TextView tvIdProvider;
		private TextView tvIdImageProduct;
		private TextView tvPrice;
		private TextView tvCode;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvDescription = (TextView) view.findViewById(R.id.tvDescription);
			tvIdProducto = (TextView) view.findViewById(R.id.tvIdProducto);
			tvName = (TextView) view.findViewById(R.id.tvName);
			tvIdProvider = (TextView) view.findViewById(R.id.tvIdProvider);
			tvIdImageProduct = (TextView) view.findViewById(R.id.tvIdImageProduct);
			tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			tvCode = (TextView) view.findViewById(R.id.tvCode);
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
		holder.tvDescription.setText(product.getDescription());
		holder.tvIdProducto.setText(String.valueOf(product.getIdProducto()));
		holder.tvName.setText(product.getName());
		holder.tvIdProvider.setText(String.valueOf(product.getIdProvider()));
		holder.tvIdImageProduct.setText(String.valueOf(product.getIdImageProduct()));
		holder.tvPrice.setText(String.valueOf(product.getPrice()));
		holder.tvCode.setText(String.valueOf(product.getCode()));


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("product", product);
                ((ProductActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productDAO.deleteProduct(product);
                productList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                ((ProductActivity) context).getProductCount();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

