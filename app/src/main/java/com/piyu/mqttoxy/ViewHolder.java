package com.piyu.mqttoxy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView mQuestion;
    TextView mname , monOff ;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mQuestion=itemView.findViewById(R.id.question);
        mname=itemView.findViewById(R.id.name);
        monOff=itemView.findViewById(R.id.onOff);
    }
}
