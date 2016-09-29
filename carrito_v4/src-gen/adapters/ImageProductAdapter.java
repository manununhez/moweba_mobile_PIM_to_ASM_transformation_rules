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

public class ImageProductAdapter extends RecyclerView.Adapter<ImageProductAdapter.MyViewHolder> {

    private List<ImageProduct> imageProductList;
    private Context context;
    private ImageProductDAO imageProductDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvImage;
		private TextView tvIdImageProduct;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvImage = (TextView) view.findViewById(R.id.tvImage);
			tvIdImageProduct = (TextView) view.findViewById(R.id.tvIdImageProduct);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivEdit = (ImageView) view.findViewById(R.id.ivEdit);
        }
    }


    public ImageProductAdapter(Context context, List<ImageProduct> imageProductList, ImageProductDAO imageProductDAO) {
        this.context = context;
		this.imageProductList = imageProductList;
        this.imageProductDAO = imageProductDAO;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_imageproduct, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ImageProduct imageProduct = imageProductList.get(position);
		holder.tvImage.setText(imageProduct.getImage());
		holder.tvIdImageProduct.setText(imageProduct.getIdImageProduct());


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageProductFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("imageProduct", imageProduct);
                ((ImageProductActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageProductDAO.deleteImageProduct(imageProduct);
                imageProductList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                ((ImageProductActivity) context).getImageProductCount();
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageProductList.size();
    }
}

