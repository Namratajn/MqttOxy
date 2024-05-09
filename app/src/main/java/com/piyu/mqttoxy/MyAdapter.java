package com.piyu.mqttoxy;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{

    Context context ;
    List<ModelClass> items ;

    public MyAdapter(Context context, List<ModelClass> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclercardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mname.setText(items.get(position).getName());
        holder.monOff.setText(items.get(position).getOnOff());
        holder.mQuestion.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
