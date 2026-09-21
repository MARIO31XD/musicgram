package com.example.musicgram_.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.musicgram_.R;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_album);

        String albumName = getIntent().getStringExtra("album");
        String artistName = getIntent().getStringExtra("artist");



        if (albumName != null) {
            albumName = albumName.trim();
        }
        final String finalAlbumName = albumName;

        LinearLayout songsContainer = findViewById(R.id.songsContainer);
        ImageView imgAlbumCover = findViewById(R.id.imgAlbumCover);
        TextView txtAlbumName = findViewById(R.id.txtAlbumName);
        TextView txtAlbumArtist = findViewById(R.id.txtAlbumArtist);
        TextView txtAlbumYear = findViewById(R.id.txtAlbumYear);

        txtAlbumName.setText(albumName);
        txtAlbumArtist.setText(artistName);

        String [] songs = new String [0]; // Array de Songs (lista  inicial vacia)

        // comprovaciones de portada de Album
        if ("After Hours".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.after_hours);
            txtAlbumYear.setText("2020");

            // Array de texto con las songs de AFTER HOURS
            songs  = new String[]  {
                    "Alone Again",
                    "Too Late",
                    "Hardest To Love",
                    "Scared To Live",
                    "Snowchild",
                    "Escape From LA",
                    "Heartless",
                    "Faith",
                    "Blinding Lights",
                    "In Your Eyes",
                    "Save Your Tears",
                    "After Hours",
                    "Until I Bleed Out"

            };

        }  else if ("Dawn FM".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.dawnfm);
            txtAlbumYear.setText("2022");

            songs =  new String[] {
                    "Dawn FM",
                    "Gasoline",
                    "How Do I Make You Love Me?",
                    "Take My Breath",
                    "Sacrifice",
                    "A Tale by Quincy",
                    "Out of Time",
                    "Here We Go... Again",
                    "Best Friends",
                    "Is There Someone Else?",
                    "Starry Eyes",
                    "Every Angel Is Terrifying",
                    "Don't Break My Heart",
                    "I Heard You're Married",
                    "Less Than Zero",
                    "Phantom Regret by Jim"

            };

        } else if ("Is This It".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.isthisit);
            txtAlbumYear.setText("2001");

            songs =  new String[] {
                    "Is This It",
                    "The Modern Age",
                    "Soma",
                    "Barely Legal",
                    "Someday",
                    "Alone, Together",
                    "Last Nite",
                    "Hard to Explain",
                    "New York City Cops",
                    "Trying Your Luck",
                    "Take It or Leave It"

            };


        } else if ("The New Abnormal".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.strokes);
            txtAlbumYear.setText("2020");

            songs = new String[] {
                    "The Adults Are Talking",
                    "Selfless",
                    "Brooklyn Bridge to Chorus",
                    "Bad Decisions",
                    "Eternal Summer",
                    "At the Door",
                    "Why Are Sundays So Depressing",
                    "Not the Same Anymore",
                    "Ode to the Mets"

            };

        } else if ("Thank U, Next".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.thanku);
            txtAlbumYear.setText("2019");

            songs = new String[]{
                    "Imagine",
                    "Needy",
                    "NASA",
                    "Bloodline",
                    "Fake Smile",
                    "Bad Idea",
                    "Make Up",
                    "Ghostin",
                    "In My Head",
                    "7 Rings",
                    "Thank U, Next",
                    "Break Up with Your Girlfriend, I'm Bored"
            };

        } else if ("Positions".equals(albumName)) {

            imgAlbumCover.setImageResource(R.drawable.positions);
            txtAlbumYear.setText("2020");

            songs = new String[]{
                    "Shut Up",
                    "34+35",
                    "Motive",
                    "Just Like Magic",
                    "Off the Table",
                    "Six Thirty",
                    "Safety Net",
                    "My Hair",
                    "Nasty",
                    "West Side",
                    "Love Language",
                    "Positions",
                    "Obvious",
                    "POV"
            };
        }
        // recorre la Array de songs (cada song)
        for (String song : songs) {

            TextView songText = new TextView(this); // crea un texto con cada cancion


            songText.setText("▶  " + song); // name de la song
            songText.setTextSize(17);
            songText.setPadding(10, 15, 10, 15);

            // al pulsar una Song
            songText.setOnClickListener(v -> {
                Intent intent = new Intent(AlbumActivity.this , SongActivity.class);
                intent.putExtra("song", song);
                intent.putExtra("album", finalAlbumName);
                intent.putExtra("artist", artistName);
                startActivity(intent);

            });

            songsContainer.addView(songText); // se añade en el container que hemos creado en el activity_Album

        }


    }
}