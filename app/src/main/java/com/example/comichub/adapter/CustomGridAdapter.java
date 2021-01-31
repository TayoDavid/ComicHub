package com.example.comichub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comichub.MainActivity;
import com.example.comichub.R;
import com.example.comichub.listener.OnItemClickListener;
import com.example.comichub.model.characters.Character;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Israel Easy on 29,January,2021.
 * odunmeshileya1@gmail.com
 */
public class CustomGridAdapter extends RecyclerView.Adapter<CustomGridAdapter.CustomGridHolder> {

    private OnItemClickListener<Character> listener;
    private List<Character> characters;

    public CustomGridAdapter(List<Character> characters) {
        this.characters = characters;
    }

    public void attachListener(OnItemClickListener<Character> listener) {
        this.listener = listener;
    }


    public void addUpdate(List<Character> characters) {
        this.characters = characters;
        this.notifyDataSetChanged();
    }


    @NotNull
    @Override
    public CustomGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new CustomGridHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomGridHolder holder, final int position) {
        Gson gs = new Gson();
        String js = gs.toJson(characters.get(position));
        Character model = gs.fromJson(js, Character.class);
        String characterName = model.getName();
        String imageSrc = model.getThumbnail().getPath() + "." +model.getThumbnail().getExtension();

        Glide.with(holder.itemView.getContext())
            .load(imageSrc)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image);
        holder.resourceName.setText(characterName);
        if (listener != null) {
            holder.itemView.setOnClickListener(view -> {
                MainActivity.currentPosition = position;

                listener.onItemClick(model);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return characters != null ? characters.size() : 0;
    }

    public static class CustomGridHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView resourceName;

        public CustomGridHolder(View view) {
            super(view);
            image = view.findViewById(R.id.card_image);
            resourceName = view.findViewById(R.id.item_name);
        }

    }
}