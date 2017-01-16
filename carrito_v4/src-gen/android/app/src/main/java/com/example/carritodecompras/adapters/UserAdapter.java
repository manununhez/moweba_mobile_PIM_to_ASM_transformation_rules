
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
import com.example.carritodecompras.activities.UserActivity;
import com.example.carritodecompras.activities.UserFormActivity;
import com.example.carritodecompras.beans.User;
import com.example.carritodecompras.helpers.StorageManager;

import java.util.List;
//End of user code

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> userList;
    private Context context;
    private int REQUEST_CODE = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView tvRuc;
		private TextView tvMail;
		private TextView tvUsername;
		private TextView tvPassword;
        private ImageView ivDelete;
        private ImageView ivEdit;


        public MyViewHolder(View view) {
            super(view);
			tvRuc = (TextView) view.findViewById(R.id.tvRuc);
			tvMail = (TextView) view.findViewById(R.id.tvMail);
			tvUsername = (TextView) view.findViewById(R.id.tvUsername);
			tvPassword = (TextView) view.findViewById(R.id.tvPassword);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivEdit = (ImageView) view.findViewById(R.id.ivEdit);
        }
    }


    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
		this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final User user = userList.get(position);
		holder.tvRuc.setText(user.getRuc());
		holder.tvMail.setText(user.getMail());
		holder.tvUsername.setText(user.getUsername());
		holder.tvPassword.setText(user.getPassword());

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Go to the Form to edit an entry
                Intent intent = new Intent(context, UserFormActivity.class);
                ((UserActivity) context).startActivityForResult(intent, REQUEST_CODE);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				//Delete an entry from the sharedPreferences
				StorageManager.removeValue(context, "ruc");
				StorageManager.removeValue(context, "mail");
				StorageManager.removeValue(context, "username");
				StorageManager.removeValue(context, "password");

				// Updating the recyclerView             
				userList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

