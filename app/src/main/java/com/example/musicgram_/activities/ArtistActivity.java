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

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_artist);

        String artistName = getIntent().getStringExtra("artist");

        TextView txtArtistName = findViewById(R.id.txtArtistName);
        TextView txtArtistBiography = findViewById(R.id.txtArtistBiography);
        ImageView imgArtist = findViewById(R.id.imgArtist);

        TextView txtMonthlyListeners = findViewById(R.id.txtMonthlyListeners); // oyentes mensuales

        // SONGS
        TextView txtSong1 = findViewById(R.id.txtSong1);
        TextView txtSong2 = findViewById(R.id.txtSong2);
        TextView txtSong3 = findViewById(R.id.txtSong3);

        // IMAGES AND TEXT OF ALBUMS
        ImageView imgAlbum1 = findViewById(R.id.imgAlbum1);
        ImageView imgAlbum2 = findViewById(R.id.imgAlbum2);

        TextView txtAlbum1 = findViewById(R.id.txtAlbum1);
        TextView txtAlbum2 = findViewById(R.id.txtAlbum2);

        LinearLayout album1 = findViewById(R.id.album1);
        LinearLayout album2 = findViewById(R.id.album2);

        txtArtistName.setText(artistName);

        // ALBUMS PULSABLES (abre el AlbumActivity)
        album1.setOnClickListener(v -> {
            Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
            intent.putExtra("album", txtAlbum1.getText().toString());
            intent.putExtra("artist", artistName);
            startActivity(intent);
        });

        album2.setOnClickListener(v -> {
            Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
            intent.putExtra("album", txtAlbum2.getText().toString());
            intent.putExtra("artist", artistName);
            startActivity(intent);
        });

        // comprovación del Artista
        if(artistName.equals("The Weeknd")) {
            imgArtist.setImageResource(R.drawable.weeknd); // la ruta donde está la foto del artista

            txtMonthlyListeners.setText("Más de 100 M de oyentes mensuales"); // oyentes mensuales

            // songs
            txtSong1.setText("▶  Blinding Lights");
            txtSong2.setText("▶  Save Your Tears");
            txtSong3.setText("▶  Starboy");

            // Albums + images
            txtAlbum1.setText("After Hours");
            txtAlbum2.setText("Dawn FM");

            imgAlbum1.setImageResource(R.drawable.after_hours); // image del album
            imgAlbum2.setImageResource(R.drawable.dawnfm);


            txtArtistBiography.setText( // text para la bio

                    "The Weeknd took over pop music & culture on his own terms filtering R&B, Pop,& hip-hop through an ambitious widescreen lens. The multi-platinum 4X GRAMMY Award winner has emerged as one of the most successful & significant artists of the modern era."
            );
        }
        else if (artistName.equals("The Strokes")) {

            imgArtist.setImageResource(R.drawable.thestrokes);
            txtMonthlyListeners.setText("Más de 17 M de oyentes mensuales");

            txtSong1.setText("▶  Reptilia");
            txtSong2.setText("▶  Last Nite");
            txtSong3.setText("▶  Someday");

            txtAlbum1.setText("Is This It");
            txtAlbum2.setText("The New Abnormal");

            imgAlbum1.setImageResource(R.drawable.isthisit);
            imgAlbum2.setImageResource(R.drawable.strokes);

            txtArtistBiography.setText(
                    "By bringing style, fun, and catchy songwriting back to rock music, the Strokes became one of the most influential bands of the early 21st century."
            );
        }
        else if (artistName.equals("Ariana Grande")) {

            imgArtist.setImageResource(R.drawable.ariana);
            txtMonthlyListeners.setText("Más de 100 M de oyentes mensuales");

            txtSong1.setText("▶  7 rings");
            txtSong2.setText("▶  thank u, next");
            txtSong3.setText("▶  Into You");

            txtAlbum1.setText("Thank U, Next");
            txtAlbum2.setText("Positions");

            imgAlbum1.setImageResource(R.drawable.thanku);
            imgAlbum2.setImageResource(R.drawable.positions);

            txtArtistBiography.setText(
                    "With her four-octave vocal acrobatics and iconic image, American singer, songwriter, and actress Ariana Grande has solidified her place as one of the quintessential pop stars of her generation, racking up stacks of awards and chart records in the process."
            );
        }

    }
}