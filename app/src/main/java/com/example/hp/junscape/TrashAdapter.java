package com.example.hp.junscape;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class TrashAdapter extends RecyclerView.Adapter<TrashAdapter.ViewHolder> {
    private ArrayList<Trash> trashes;

    ItemClicked activity;


    public interface ItemClicked {
        void onItemClicked(int index);
    }


    public TrashAdapter(Context context, ArrayList<Trash> list) {
        trashes = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMake;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = (ImageView) itemView.findViewById(R.id.ivMake);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(trashes.indexOf(view.getTag()));

                }
            });
        }
    }

    @NonNull
    @Override
    public TrashAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TrashAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(trashes.get(i));


        if (trashes.get(i).gettrash_name().equals("banana peel")) {
            viewHolder.ivMake.setImageResource(R.drawable.bbb);
        } else if (trashes.get(i).gettrash_name().equals("leaf")) {
            viewHolder.ivMake.setImageResource(R.drawable.leaf2);
        } else if (trashes.get(i).gettrash_name().equals("milk box")) {
            viewHolder.ivMake.setImageResource(R.drawable.milkkk);
        } else if (trashes.get(i).gettrash_name().equals("crumpled paper")) {
            viewHolder.ivMake.setImageResource(R.drawable.paper);
        } else if (trashes.get(i).gettrash_name().equals("soda can")) {
            viewHolder.ivMake.setImageResource(R.drawable.can);
        } else if (trashes.get(i).gettrash_name().equals("chips")) {
            viewHolder.ivMake.setImageResource(R.drawable.chips2);
        } else if (trashes.get(i).gettrash_name().equals("tire")) {
            viewHolder.ivMake.setImageResource(R.drawable.tire2);
        }else {
            viewHolder.ivMake.setImageResource(R.drawable.fish);
        }

    }

    @Override
    public int getItemCount() {
        return trashes.size();
    }
}
