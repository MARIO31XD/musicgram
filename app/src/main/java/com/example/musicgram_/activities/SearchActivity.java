package com.example.musicgram_.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import android.os.Handler;
import android.os.Looper;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.musicgram_.R;
import com.example.musicgram_.api.YouTubeService;

public class SearchActivity extends AppCompatActivity {

    private EditText edtSearch;
    private Button btnSearch;
    private TextView txtSearchStatus;
    private LinearLayout resultsContainer;

    private ExecutorService executor = Executors.newFixedThreadPool(3); // permite Descargar las images en segundo plano sin bloquear la app
    private Handler mainHandler = new Handler(Looper.getMainLooper()); // Handler nos permite mostrar las imagenes

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

                        // Creamos la tarjeta principal
                        LinearLayout row = new LinearLayout(SearchActivity.this);
                        row.setOrientation(LinearLayout.HORIZONTAL);
                        row.setPadding(12, 12, 12, 12);
                        row.setGravity(android.view.Gravity.CENTER_VERTICAL);
                        row.setClickable(true);
                        row.setFocusable(true);
                        row.setBackgroundResource(R.drawable.search_result_selector);

                        LinearLayout.LayoutParams rowParams =
                                new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                );

                        rowParams.setMargins(0, 0, 0, 12);

                        row.setLayoutParams(rowParams);


                        // MINIATURA
                        ImageView thumbnail = new ImageView(SearchActivity.this);

                        LinearLayout.LayoutParams imageParams =
                                new LinearLayout.LayoutParams(120, 90);

                        thumbnail.setLayoutParams(imageParams);
                        thumbnail.setScaleType(ImageView.ScaleType.CENTER_CROP);

                        // INFO CONTAINER
                        LinearLayout infoContainer =
                                new LinearLayout(SearchActivity.this);

                        infoContainer.setOrientation(LinearLayout.VERTICAL);

                        LinearLayout.LayoutParams infoParams =
                                new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        1
                                );

                        infoParams.setMargins(16, 0, 0, 0);

                        infoContainer.setLayoutParams(infoParams);


                        // TITULO
                        TextView title = new TextView(SearchActivity.this);

                        title.setText(video.title);
                        title.setTextColor(0xFFFFFFFF);
                        title.setTextSize(16);
                        title.setMaxLines(3);


                        // TEXTO SECUNDARIO
                        TextView source = new TextView(SearchActivity.this);

                        source.setText("Vídeo de YouTube");
                        source.setTextColor(0xFFAAAAAA);
                        source.setTextSize(13);
                        source.setPadding(0, 6, 0, 0);

                        // AÑADIR TEXTOS A LA TARJETA
                        infoContainer.addView(title);
                        infoContainer.addView(source);

                        row.addView(thumbnail);
                        row.addView(infoContainer);


                        // CLIC EN LA TARJETA
                        row.setOnClickListener(v -> {

                            Intent intent = new Intent(
                                    SearchActivity.this,
                                    VideoActivity.class
                            );

                            intent.putExtra("videoId", video.videoId);
                            intent.putExtra("videoTitle", video.title);

                            startActivity(intent);
                        });

                        // Añadimos la tarjeta a la lista
                        resultsContainer.addView(row);


                        // DESCARGAMOS LA MINIATURA
                        executor.execute(() -> {

                            try {

                                URL url = new URL(video.thumbnailUrl);

                                Bitmap bitmap = BitmapFactory.decodeStream(
                                        url.openConnection().getInputStream()
                                );

                                mainHandler.post(() -> {

                                    if (bitmap != null) {
                                        thumbnail.setImageBitmap(bitmap);
                                    }

                                });

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
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