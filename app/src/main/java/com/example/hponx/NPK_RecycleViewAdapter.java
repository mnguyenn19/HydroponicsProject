package com.example.hponx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NPK_RecycleViewAdapter extends FirebaseRecyclerAdapter<npk_model,NPK_RecycleViewAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NPK_RecycleViewAdapter(@NonNull FirebaseRecyclerOptions<npk_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull npk_model model) {
        holder.eFullName.setText(model.getName());
        holder.eAbrevName.setText((model.getAbrev()));
        holder.standAloneValue.setText(model.getValue());

        Glide.with(holder.imageView.getContext())
                .load(model.getImage())
                .placeholder((com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark))
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.imageView);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_rows,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView eAbrevName,eFullName,standAloneValue;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            eFullName = itemView.findViewById(R.id.textViewTop);
            eAbrevName = itemView.findViewById(R.id.textViewBottomLeft);
            standAloneValue = itemView.findViewById(R.id.textViewBottomRight);
        }
    }
}
