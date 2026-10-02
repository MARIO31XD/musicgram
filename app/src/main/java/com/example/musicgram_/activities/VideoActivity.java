package com.example.musicgram_.activities;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.musicgram_.R;

public class VideoActivity extends AppCompatActivity {

    private WebView videoWebView;
    private TextView txtVideoTitle;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // Conectamos los elementos del XML
        videoWebView = findViewById(R.id.videoWebView);
        txtVideoTitle = findViewById(R.id.txtVideoTitle);

        // Recibimos los datos del vídeo
        String videoId = getIntent().getStringExtra("videoId");
        String videoTitle = getIntent().getStringExtra("videoTitle");

        // Mostramos el título
        if (videoTitle != null) {
            txtVideoTitle.setText(videoTitle);
        }

        // button para volver atrás
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        // Configuramos el reproductor
        videoWebView.getSettings().setJavaScriptEnabled(true); // permite que el reproductor de YouTube funcione dentro del WebView
        videoWebView.setWebChromeClient(new WebChromeClient()); // permite gestionar funciones del contenido web, como la reproducción multimedia.
        videoWebView.setWebViewClient(new WebViewClient());

        // Comprobamos que tenemos un identificador
        if (videoId != null && !videoId.isEmpty()) {

            // Creamos el HTML del reproductor donde cargaremos el video
            String html =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
                            "</head>" +
                            "<body style='margin:0; background-color:black;'>" +
                            "<iframe " +
                            "width='100%' " +
                            "height='230' " +
                            "src='https://www.youtube.com/embed/" + videoId + "' " +
                            "title='YouTube video player' " +
                            "frameborder='0' " +
                            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share' " +
                            "allowfullscreen>" +
                            "</iframe>" +
                            "</body>" +
                            "</html>";

            // Cargamos el reproductor indicando la identidad de la app
            videoWebView.loadDataWithBaseURL(
                    "https://com.example.musicgram_/",
                    html,
                    "text/html",
                    "UTF-8",
                    null
            );

        } else {
            txtVideoTitle.setText("No se ha encontrado el vídeo");
        }
    }

    @Override
    protected void onDestroy() {
        videoWebView.destroy();
        super.onDestroy();
    }
}