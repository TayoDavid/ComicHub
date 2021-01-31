package com.example.comichub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.comichub.model.characters.Character;

public class CharacterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_detail);

        Intent detailIntent = getIntent();
        Character comicCharacter = detailIntent.getParcelableExtra("details");

        Toolbar toolbar = findViewById(R.id.details_toolbar);
        toolbar.setTitle(comicCharacter.getName());

        String thumbnail = comicCharacter.getThumbnail().getPath() + "." + comicCharacter.getThumbnail().getExtension();
        String featuredComics = "Featured Comics: " + comicCharacter.getComics().getAvailable();
        String featuredStories = "Featured Stories: " + comicCharacter.getStories().getAvailable();
        Log.i("Character", comicCharacter.toString());

        ImageView charImage = findViewById(R.id.character_image);
        TextView charName = findViewById(R.id.character_name);
        TextView description = findViewById(R.id.character_description);
        TextView charFeaturedComics = findViewById(R.id.featured_comics);
        TextView charFeaturedStories = findViewById(R.id.featured_stories);

        Glide.with(this)
                .load(thumbnail)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(charImage);
        charName.setText(comicCharacter.getName());
        description.setText(comicCharacter.getDescription());
        charFeaturedComics.setText(featuredComics);
        charFeaturedStories.setText(featuredStories);
    }
}