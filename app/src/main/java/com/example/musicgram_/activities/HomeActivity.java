package com.example.musicgram_.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.musicgram_.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // new LinearLayout
        LinearLayout navSearch = findViewById(R.id.navSearch);
        LinearLayout navProfile = findViewById(R.id.navProfile);

        //  SEARCH cuando se haga click abrirá el SearchActivity
        navSearch.setOnClickListener(v -> {
            // para abrir la SearchActivity
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);

        });

        // PROFILE PARA CUANDO SE HAGA CLICK
        navProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);

        });

    }
}