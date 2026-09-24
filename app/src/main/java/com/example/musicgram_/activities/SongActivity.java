package com.example.musicgram_.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
    private Handler handler = new Handler(Looper.getMainLooper()); // para actualizar la barra y el tiempo

    private SeekBar seekbar;
    private TextView txtCurrentTime;

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

        seekbar = findViewById(R.id.seekBar);
        txtCurrentTime = findViewById(R.id.txtCurrentTime);
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

        mediaPlayer = MediaPlayer.create(this, R.raw.blinding_lights);

        if (mediaPlayer != null) {

            // Ponemos la duración de la canción en la barra (seekbar)
            seekbar.setMax(mediaPlayer.getDuration());

            // Mostramos la duración total
            txtTotalTime.setText(formatTime(mediaPlayer.getDuration()));

            btnPlayPause.setOnClickListener(v -> {

                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.pause();
                    btnPlayPause.setText("▶");

                } else {

                    mediaPlayer.start();
                    btnPlayPause.setText("⏸");

                    updateSeekBar();
                }
            });

            // cuando la cancion termine
            mediaPlayer.setOnCompletionListener(mp -> {

                seekbar.setProgress(0);

                txtCurrentTime.setText("0:00");

                btnPlayPause.setText("▶");
            });

            // para arrastrar la barra
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    if (fromUser && mediaPlayer != null) {

                        mediaPlayer.seekTo(progress);

                        txtCurrentTime.setText(formatTime(progress));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }


    }

    private void updateSeekBar() {

        if (mediaPlayer != null) {

            int currentPosition = mediaPlayer.getCurrentPosition();

            seekbar.setProgress(currentPosition);

            txtCurrentTime.setText(formatTime(currentPosition));

            handler.postDelayed(this::updateSeekBar, 500);
        }
    }

    private String formatTime(int milliseconds) {

        int seconds = milliseconds / 1000;

        int minutes = seconds / 60;

        seconds = seconds % 60;

        return String.format("%d:%02d", minutes, seconds);
    }

}