package com.example.musicgram_.activities;

import android.os.Bundle;
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
        TextView txtAlbumName = findViewById(R.id.txtAlbumName);
        txtAlbumName.setText(albumName);
    }
}