package com.example.hponx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NPK_RecycleViewAdapter extends RecyclerView.Adapter<NPK_RecycleViewAdapter.MyViewHolder> {
    private final RViewInterface rViewInterface;
    Context context;
    ArrayList<ElementsModel> elementsModels;

    public NPK_RecycleViewAdapter(Context context, ArrayList<ElementsModel> elementsModels,
                                  RViewInterface rViewInterface){
        this.context = context;
        this.elementsModels = elementsModels;
        this.rViewInterface = rViewInterface;
    }

    @NonNull
    @Override
    public NPK_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleview_rows, parent, false);
        return new NPK_RecycleViewAdapter.MyViewHolder(view, rViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NPK_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.eFullName.setText(elementsModels.get(position).getElementName());
        holder.eAbrevName.setText(elementsModels.get(position).getElementAbbreviation());
        holder.imageView.setImageResource(elementsModels.get(position).getImage());
        //holder.eDescription.setText(elementsModels.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return elementsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView eFullName, eAbrevName;
        //TextView eDescription;


        public MyViewHolder(@NonNull View itemView, RViewInterface rViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            eFullName = itemView.findViewById(R.id.textViewTop);
            eAbrevName = itemView.findViewById(R.id.textViewBottom);
            //eDescription = itemView.findViewById(R.id.);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            rViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
