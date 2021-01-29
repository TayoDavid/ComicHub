package com.example.comichub.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.comichub.R;

/**
 * Created by Israel Easy on 29,January,2021.
 * odunmeshileya1@gmail.com
 */
public class CustomGridHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView resourceName;

    public CustomGridHolder(View view) {
        super(view);
        image = view.findViewById(R.id.card_image);
        resourceName = view.findViewById(R.id.item_name);
    }

}
