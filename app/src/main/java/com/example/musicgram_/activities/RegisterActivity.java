package com.example.musicgram_.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import com.example.musicgram_.R;
import com.example.musicgram_.model.User;
import android.content.SharedPreferences;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register); // xml de Activity Register

        // Los valores EditText que hay que rellenar en el Register
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);

        Button btnRegister = findViewById(R.id.btnRegister); // boton de registrarse

        btnRegister.setOnClickListener(v -> {

            String username = etUsername.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            // validaciones
            if (username.isEmpty()) {
                Toast.makeText(this, "Introduce tu Nombre de Usuario", Toast.LENGTH_SHORT).show();
            }
            else if (email.isEmpty()) {
                Toast.makeText(this, "Introduce tu Email", Toast.LENGTH_SHORT).show();
            }
            else if(password.isEmpty()) {
                Toast.makeText(this, "Introduce tu contraseña", Toast.LENGTH_SHORT).show();

            }
            else if(confirmPassword.isEmpty()) {
                Toast.makeText(this, "Repite tu contraseña", Toast.LENGTH_SHORT).show();
            }
            else if(!password.equals(confirmPassword)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
            else{
                // crear objeto User con los datos que rellenará del formulario
                User user = new User();
                user.setUsername(username); // username del user
                user.setEmail(email); // email del user
                user.setPassword(password); // password del user
                Log.d("Musicgram", user.toString()); // log de prueba

                // Preferencias METE LOS DATOS
                SharedPreferences preferences = getSharedPreferences("MusicgramPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                // meter los datos en las Preferences
                editor.putString("username", username);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.apply(); // aplicar las preferencias

                Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show(); // registro correcto

                // pasa de la pantalla de Register para ir a la pantalla de Login después de crear un User
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent); // iniciar actividad abre el Login
                finish(); // cierra RegisterActivity


            }


        });




    }
}