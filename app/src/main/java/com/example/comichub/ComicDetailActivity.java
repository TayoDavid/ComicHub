package com.example.comichub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.comichub.model.comics.Comic;

public class ComicDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_detail);

        Intent detailIntent = getIntent();
        Comic comic = detailIntent.getParcelableExtra("comicDetail");

        Toolbar toolbar = findViewById(R.id.details_toolbar);
        toolbar.setTitle(comic.getTitle());

        String thumbnail = comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension();
        String featuredComics = "Featured Comics: " + comic.getCharacters().getAvailable();
        String featuredStories = "Featured Stories: " + comic.getStories().getAvailable();
        Log.i("Comic", comic.toString());

        ImageView comicThumbnail = findViewById(R.id.character_image);
        TextView comicTitle = findViewById(R.id.character_name);
        TextView description = findViewById(R.id.character_description);
        TextView comicCharacters = findViewById(R.id.featured_comics);
        TextView relatedStories = findViewById(R.id.featured_stories);

        Glide.with(this)
                .load(thumbnail)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(comicThumbnail);
        comicTitle.setText(comic.getTitle());
        comicCharacters.setText(featuredComics);
        relatedStories.setText(featuredStories);
        description.setText(comic.getDescription());
    }
}
