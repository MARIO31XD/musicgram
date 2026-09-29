package com.example.musicgram_.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.musicgram_.R;
import com.example.musicgram_.api.YouTubeService;

public class SearchActivity extends AppCompatActivity {

    private EditText edtSearch;
    private Button btnSearch;
    private TextView txtSearchStatus;
    private LinearLayout resultsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        txtSearchStatus = findViewById(R.id.txtSearchStatus);
        resultsContainer = findViewById(R.id.resultsContainer);

        btnSearch.setOnClickListener(v -> {
            // obtener y guardar el texto que escribirá el usuario
            String query = edtSearch.getText().toString().trim();

            if (query.isEmpty()) {
                edtSearch.setError("Escribe algo para buscar");
                return;
            }

            resultsContainer.removeAllViews();
            txtSearchStatus.setText("Searching...");

            // Servicio de búsqueda le pedimos a YoutubeService que busque videos
            YouTubeService.searchVideos(query, new YouTubeService.SearchCallback() {

                // Youtube devuelve los results y se ejecuta el onSuccess
                @Override
                public void onSuccess(
                        java.util.ArrayList<YouTubeService.VideoResult> results) {

                    resultsContainer.removeAllViews();

                    // recorre los results  y muestra los titulos de cada video.
                    if (results.isEmpty()) {
                        txtSearchStatus.setText("No se encontraron resultados");
                        return;
                    }

                    txtSearchStatus.setText(
                            "Resultados encontrados: " + results.size()
                    );

                    for (YouTubeService.VideoResult video : results) {

                        TextView resultView = new TextView(SearchActivity.this);

                        resultView.setText(video.title);
                        resultView.setTextColor(0xFFFFFFFF);
                        resultView.setTextSize(18);
                        resultView.setPadding(12, 20, 12, 20);

                        resultsContainer.addView(resultView);
                    }
                }

                @Override
                public void onError(String error) {
                    txtSearchStatus.setText("Error: " + error);
                }
            });
        });

    }
}