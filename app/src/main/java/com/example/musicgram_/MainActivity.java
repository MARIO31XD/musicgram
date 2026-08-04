package com.example.musicgram_;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.musicgram_.model.Album;
import com.example.musicgram_.model.Artist;  // importar la clase Artist que está en la carpeta Model
import com.example.musicgram_.model.Playlist;
import com.example.musicgram_.model.Song;
import com.example.musicgram_.model.User;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("LA APP HA ARRANCADO");

        Toast.makeText(this, "MainActivity iniciada", Toast.LENGTH_LONG).show();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        // Crear artista
        Artist theWeeknd = new Artist();
        theWeeknd.setName("The Weeknd"); // atributo del Artist (name)

        // Crear Album del Artista
        Album afterHours = new Album();
        afterHours.setTitle("After Hours");
        afterHours.setArtist(theWeeknd);
        afterHours.setReleaseYear(2020); // año de lanzamiento

        // relacionar album con el Artista
        theWeeknd.addAlbum(afterHours); // addAlbum metodo en Artist (le pasamos el album creado afterhours).

        // crear Song
        Song faith = new Song();
        faith.setTitle("Faith");
        faith.setArtist(theWeeknd);
        faith.setDuration(283);
        faith.setAlbum(afterHours);

        afterHours.addSong(faith); // añadir cancion al Album After Hours
        theWeeknd.addSong(faith); // añadir song al Artist
        // Crear User
        User mario = new User();
        mario.setUsername("Mario"); // UserName

        // Crear PlayList de prueba
        Playlist playlistXO = new Playlist();
        playlistXO.setTitle("Mi playlist de theweeknd"); // titulo de la playlist
        playlistXO.setOwner(mario); // dueño de la playlist (en este caso el User que hemos creado)

        playlistXO.addSong(faith); // añadir la Song a la playlist
        mario.addPlaylist(playlistXO); // addPlaylist al User mario


        // LOGS
        // mostrar por los Logs el User
        Log.d("Musicgram" , mario.toString());

        // imprimir el artista
        Log.d("Musicgram" , theWeeknd.toString());

        Log.d("Musicgram" , afterHours.toString());
        Log.d("Musicgram" , faith.toString());

        Log.d("Musicgram" , playlistXO.toString());





    }
}