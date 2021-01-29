package com.example.comichub.adapter;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

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
public class CustomGridAdapter extends RecyclerView.Adapter<CustomGridHolder> {

    private OnItemClickListener<Character> listener;
    private List<Character> characters;

    public CustomGridAdapter(List<Character> methods) {
        this.characters = methods;
    }

    public void attachListener(OnItemClickListener<Character> listener) {
        this.listener = listener;
    }


    public void addUpdate(List<Character> characters) {
        this.characters = characters;
        Log.e("DDD", "characters ==>" + characters.size());
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
        String imageSrc = model.getThumbnail().getPath();
        holder.image.setImageURI(Uri.parse(imageSrc));
        holder.resourceName.setText(characterName);
        if (listener != null) {
            holder.itemView.setOnClickListener(view -> {
                listener.onItemClick(model);
                notifyDataSetChanged();

            });
        }

    }


    @Override
    public int getItemCount() {
        return characters != null ? characters.size() : 0;
    }
}