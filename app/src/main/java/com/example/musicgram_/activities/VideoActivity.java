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

            // Creamos el HTML del reproductor donde cargaremos el video + nuevas funciones play/pause video
            String html =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
                            "</head>" +
                            "<body style='margin:0; background-color:black;'>" +

                            "<div id='player'></div>" +

                            "<script>" +
                            "var tag = document.createElement('script');" +
                            "tag.src = 'https://www.youtube.com/iframe_api';" +
                            "document.body.appendChild(tag);" +

                            "var player;" +

                            "function onYouTubeIframeAPIReady() {" +
                            "player = new YT.Player('player', {" +
                            "height: '230'," +
                            "width: '100%'," +
                            "videoId: '" + videoId + "'," +
                            "playerVars: {" +
                            "playsinline: 1" +
                            "}" +
                            "});" +
                            "}" +

                            "function pauseVideo() {" +
                            "if (player) player.pauseVideo();" +
                            "}" +

                            "function playVideo() {" +
                            "if (player) player.playVideo();" +
                            "}" +

                            "</script>" +
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

    public void controlarVideo(boolean reproducir) {

        String funcion;
         // ejecuta el video
        if (reproducir) {
            funcion = "playVideo";
        } else {
            funcion = "pauseVideo"; // pausa el video
        }

        // evaluate envia la orden desde java a la pagina cargada en html (webview)
        videoWebView.evaluateJavascript(
                "if (typeof " + funcion + " === 'function') {"
                        + funcion + "();"
                        + "}",
                null
        );
    }



    @Override
    protected void onDestroy() {
        videoWebView.destroy();
        super.onDestroy();
    }
}