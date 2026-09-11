package com.example.musicgram_.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
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

        // codigo para mejorar la View para que no esté debajo de la barra de estado ni navegación
        View root = findViewById(R.id.homeRoot); // view de la Home
        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(0,
                            systemBars.top,
                            0,
                            systemBars.bottom);

                    return insets;
                });
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

        // Para abrir la playlist de After Hours
        LinearLayout playlistAfterHours = findViewById(R.id.playlistAfterHours);
        playlistAfterHours.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PlaylistActivity.class);
            startActivity(intent);
        });



    }
}