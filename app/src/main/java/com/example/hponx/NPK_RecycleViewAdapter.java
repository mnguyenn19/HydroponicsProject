package com.example.hponx;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NPK_RecycleViewAdapter<onCreate> extends RecyclerView.Adapter<NPK_RecycleViewAdapter.MyViewHolder> {
    //private final RViewInterface rViewInterface;
    Context context;
    ArrayList<ElementsModel> elementsModels;

    //public NPK_RecycleViewAdapter(Context context, ArrayList<ElementsModel> elementsModels,
    //                              RViewInterface rViewInterface){

    public NPK_RecycleViewAdapter(Context context, ArrayList<ElementsModel> elementsModels){
        this.context = context;
        this.elementsModels = elementsModels;
        //this.rViewInterface = rViewInterface;
    }

    @NonNull
    @Override
    public NPK_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleview_rows, parent, false);
        //return new NPK_RecycleViewAdapter.MyViewHolder(view, rViewInterface);
        return new NPK_RecycleViewAdapter.MyViewHolder(view);
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
        TextView standAloneValue;

        //public MyViewHolder(@NonNull View itemView, RViewInterface rViewInterface) {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            eFullName = itemView.findViewById(R.id.textViewTop);
            eAbrevName = itemView.findViewById(R.id.textViewBottomLeft);
            //eDescription = itemView.findViewById(R.id.textViewBottomRight);
            standAloneValue = itemView.findViewById(R.id.textViewBottomRight);


            //itemView.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View view) {
            //        if (rViewInterface != null){
            //            int pos = getAdapterPosition();

            //            if(pos != RecyclerView.NO_POSITION){
            //                rViewInterface.onItemClick(pos);
            //                                        }
            //        }
            //    }
            //});
        }
    }
}
