package com.example.musicgram_;

public class MusicPlayerManager {

    // variables que se utilizarán en el Reproductor
    private static String videoId; // id del video
    private static String videoTitle; // title del video

    private static boolean isPlaying = false; // y si se está reproduciendo o no (true/false)


    // esta clase estatica, guarda el video actual (currentVideo) recibe el id y el titulo del video
    public static void setCurrentVideo(String id, String title) {
        videoId = id;
        videoTitle = videoTitle;
        isPlaying = true; // estado en True ya que en ese momento se está reproduciendo el current video
    }

    public static String getVideoId() {
        return videoId;
    }

    public static String getVideoTitle() {
        return videoTitle;
    }

    // change status
    public static boolean isPlaying() {
        return isPlaying;
    }

    // actualizar el estado desde otra clase
    public static void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
