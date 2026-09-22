package com.example.musicgram_.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.musicgram_.R;

public class SongActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer; // variable que guardará el Reproductor MediaPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_song);

        String songName = getIntent().getStringExtra("song");
        String albumName = getIntent().getStringExtra("album");
        String artistName = getIntent().getStringExtra("artist");

        TextView txtSongName =  findViewById(R.id.txtSongName);
        TextView txtSongArtist = findViewById(R.id.txtSongArtist);
        ImageView imgSongCover = findViewById(R.id.imgSongCover);

        SeekBar seekbar = findViewById(R.id.seekBar);
        TextView txtCurrentTime = findViewById(R.id.txtCurrentTime);
        TextView txtTotalTime = findViewById(R.id.txtTotalTime);

        // Button del reproductor MediaPlayer
        Button btnPlayPause = findViewById(R.id.btnPlayPause);


        txtSongName.setText(songName);
        txtSongArtist.setText(artistName);

        // COMPROVACIONES DEL ALBUM CON SU RESPECTIVA PORTADA
        if ("After Hours".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.after_hours);

        } else if ("Dawn FM".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.dawnfm);

        } else if ("Is This It".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.isthisit);

        } else if ("The New Abnormal".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.strokes);

        } else if ("Thank U, Next".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.thanku);

        } else if ("Positions".equals(albumName)) {

            imgSongCover.setImageResource(R.drawable.positions);
        }

        mediaPlayer = MediaPlayer.create(this,R.raw.blinding_lights); // song mp4

        btnPlayPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                // se está reproduciendo? SI SI , se pausa
                mediaPlayer.pause();
                btnPlayPause.setText("▶");
            } else {
                // si no la reproduce y cambia
                mediaPlayer.start();
                btnPlayPause.setText("⏸");
            }

        });


    }
}