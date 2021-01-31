package com.example.comichub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.comichub.MainActivity;
import com.example.comichub.R;
import com.example.comichub.listener.OnItemClickListener;
import com.example.comichub.model.characters.Character;
import com.example.comichub.model.comics.Comic;
import com.google.gson.Gson;

import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

    private List<Comic> comics;
    private OnItemClickListener<Comic> listener;

    public ComicsAdapter(List<Comic> comics) {
        this.comics = comics;
    }

    public void updateComics(List<Comic> comics) {
        this.comics = comics;
        this.notifyDataSetChanged();
    }

    public void attachListener(OnItemClickListener<Comic> listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ComicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new ComicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicsViewHolder holder, int position) {
        Gson gs = new Gson();
        String js = gs.toJson(comics.get(position));
        Comic comic = gs.fromJson(js, Comic.class);
        String characterName = comic.getTitle();
        String imageSrc = comic.getThumbnail().getPath() + "." +comic.getThumbnail().getExtension();

        Glide.with(holder.itemView.getContext())
                .load(imageSrc)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
        holder.resourceTitle.setText(characterName);
        if (listener != null) {
            holder.itemView.setOnClickListener(view -> {
                MainActivity.currentPosition = position;
                listener.onItemClick(comic);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return comics != null ? comics.size() : 0;
    }

    public static class ComicsViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView resourceTitle;

        public ComicsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_image);
            resourceTitle = itemView.findViewById(R.id.item_name);
        }
    }
}
