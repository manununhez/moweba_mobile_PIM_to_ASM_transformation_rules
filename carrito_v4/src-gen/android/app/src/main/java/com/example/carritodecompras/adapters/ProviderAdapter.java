
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
import com.example.carritodecompras.activities.ProviderActivity;
import com.example.carritodecompras.activities.ProviderFormActivity;
import com.example.carritodecompras.bd.dao.ProviderDAO;
import com.example.carritodecompras.beans.Provider;

import java.util.List;
//End of user code

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder> {

    private List<Provider> providerList;
    private Context context;
    private ProviderDAO providerDAO;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvDescription;
		private TextView tvIdProvider;
		private TextView tvRuc;
		private TextView tvNombre;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvDescription = (TextView) view.findViewById(R.id.tvDescription);
			tvIdProvider = (TextView) view.findViewById(R.id.tvIdProvider);
			tvRuc = (TextView) view.findViewById(R.id.tvRuc);
			tvNombre = (TextView) view.findViewById(R.id.tvNombre);
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
		holder.tvDescription.setText(provider.getDescription());
		holder.tvIdProvider.setText(String.valueOf(provider.getIdProvider()));
		holder.tvRuc.setText(provider.getRuc());
		holder.tvNombre.setText(provider.getNombre());


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Go to the Form to edit an entry
                Intent intent = new Intent(context, ProviderFormActivity.class);
                intent.putExtra("typeOperation", "edit");
                intent.putExtra("provider", provider);
                ((ProviderActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				//Delete an entry from the database
                providerDAO.deleteProvider(provider);
                
				// Updating the recyclerView
				providerList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

				//Updating the total items count
                ((ProviderActivity) context).getProviderCount();
            }
        });
    }

    @Override
    public int getItemCount() {
        return providerList.size();
    }
}
