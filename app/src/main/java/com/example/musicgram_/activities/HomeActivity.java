package com.example.musicgram_.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.widget.Button;
import com.example.musicgram_.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // BUTTONS DEL XML
        Button btnHome = findViewById(R.id.btnHome);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnProfile = findViewById(R.id.btnProfile);

        // BUTTON SEARCH cuando se haga click abrirá el SearchActivity
        btnSearch.setOnClickListener(v -> {
            // para abrir la SearchActivity
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);

        });

        // BUTTON PROFILE PARA CUANDO SE HAGA CLICK
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);

        });

    }
}