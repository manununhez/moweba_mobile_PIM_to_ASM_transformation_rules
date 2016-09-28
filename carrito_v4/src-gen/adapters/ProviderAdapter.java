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

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder> {

    private List<Provider> providerList;
    private Context context;
    private ProviderDAO providerDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvRuc;
		private TextView tvIdProvider;
		private TextView tvNombre;
		private TextView tvDescription;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvRuc = (TextView) view.findViewById(R.id.tvRuc);
			tvIdProvider = (TextView) view.findViewById(R.id.tvIdProvider);
			tvNombre = (TextView) view.findViewById(R.id.tvNombre);
			tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivEdit = (ImageView) view.findViewById(R.id.ivEdit);
        }
    }


    public ProviderAdapter(Context context, List<Provider> providerList, ProviderDAO providerDAO) {
        this.context = context;
		this.providerList = providerList;
        this.providerDAO = providerDAO;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_provider, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Provider provider = providerList.get(position);
		holder.tvRuc.setText(provider.getRuc());
		holder.tvIdProvider.setText(provider.getIdProvider());
		holder.tvNombre.setText(provider.getNombre());
		holder.tvDescription.setText(provider.getDescription());

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                providerDAO.deleteProvider(provider);
                providerList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                ((ProviderActivity) context).getProviderCount();
            }
        });

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProviderFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("provider", provider);
                ((ProviderActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return providerList.size();
    }
}

