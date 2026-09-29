package com.example.musicgram_.api;

import android.os.Handler;
import android.os.Looper;

import com.example.musicgram_.BuildConfig;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class YouTubeService {

    private static final String BASE_URL =
            "https://www.googleapis.com/youtube/v3/search";

    private static final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    private static final Handler mainHandler =
            new Handler(Looper.getMainLooper());


    // esta clase representa un resultado de Youtube (cada video que nos devuelve con esos 3 datos)
    public static class VideoResult {

        public String videoId;
        public String title;
        public String thumbnailUrl;

        public VideoResult(String videoId, String title, String thumbnailUrl) {
            this.videoId = videoId;
            this.title = title;
            this.thumbnailUrl = thumbnailUrl;
        }

    }
    // Interfaz para devolver los resultados
    public interface SearchCallback {

        void onSuccess(ArrayList<VideoResult> results);

        void onError(String error);
    }

    // Method para buscar vídeos
    public static void searchVideos(String query, SearchCallback callback) {

        executor.execute(() -> {

            HttpURLConnection connection = null;

            try {

                String encodedQuery = URLEncoder.encode(
                        query,
                        StandardCharsets.UTF_8.name()
                );

                String urlString = BASE_URL
                        + "?part=snippet"
                        + "&type=video"
                        + "&maxResults=10"
                        + "&regionCode=ES"
                        + "&q=" + encodedQuery
                        + "&key=" + BuildConfig.YOUTUBE_API_KEY;

                URL url = new URL(urlString);

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Identificamos nuestra aplicación Android
                connection.setRequestProperty(
                        "X-Android-Package",
                        "com.example.musicgram_"
                );

                connection.setRequestProperty(
                        "X-Android-Cert",
                        "6C79929FA320DB9D202D2D960EE5A65A46DDF059"
                );

                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);

                int responseCode = connection.getResponseCode();

                if (responseCode != 200) {

                    InputStream errorStream = connection.getErrorStream();

                    StringBuilder errorResponse = new StringBuilder();

                    if (errorStream != null) {
                        BufferedReader errorReader = new BufferedReader(
                                new InputStreamReader(errorStream, StandardCharsets.UTF_8)
                        );

                        String errorLine;

                        while ((errorLine = errorReader.readLine()) != null) {
                            errorResponse.append(errorLine);
                        }

                        errorReader.close();
                    }

                    throw new Exception(
                            "Error HTTP: " + responseCode + " - " + errorResponse
                    );
                }

                InputStream inputStream = connection.getInputStream();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream, StandardCharsets.UTF_8)
                );

                StringBuilder response = new StringBuilder();

                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                JSONArray items = jsonResponse.getJSONArray("items");

                ArrayList<VideoResult> results = new ArrayList<>();

                for (int i = 0; i < items.length(); i++) {

                    JSONObject item = items.getJSONObject(i);

                    JSONObject id = item.getJSONObject("id");
                    JSONObject snippet = item.getJSONObject("snippet");

                    String videoId = id.getString("videoId");
                    String title = snippet.getString("title");

                    String thumbnailUrl = snippet
                            .getJSONObject("thumbnails")
                            .getJSONObject("default")
                            .getString("url");

                    VideoResult video = new VideoResult(
                            videoId,
                            title,
                            thumbnailUrl
                    );

                    results.add(video);
                }

                mainHandler.post(() -> callback.onSuccess(results));

            } catch (Exception e) {

                mainHandler.post(() ->
                        callback.onError(e.getMessage())
                );

            } finally {

                if (connection != null) {
                    connection.disconnect();
                }
            }
        });

    }
}
