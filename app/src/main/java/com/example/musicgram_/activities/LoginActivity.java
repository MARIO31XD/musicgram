package com.example.musicgram_.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicgram_.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login); // activity_login.xml es la interfaz donde podremos hacer login

        // fields of form
        Button btnLogin = findViewById(R.id.btnLogin); // boton para hacer Login y iniciar sesión

        EditText etEmail = findViewById(R.id.etEmail); // field email variable etEmail
        EditText etPassword = findViewById(R.id.etPassword); // field Password variable etPassword

        TextView txtRegister = findViewById(R.id.txtRegister); // TextView Register que si tocamos nos lleva a la Register Activity

        // Logica cuando hagamos Click en el btnLogin
        btnLogin.setOnClickListener(v ->{

          String email = etEmail.getText().toString(); // cogemos los datos de los Strings
          String password = etPassword.getText().toString(); // tanto del email como del password

            // if el email está vacio // y la contraseña // SINO HACES EL LOGIN CORRECTAMENTE
        if(email.isEmpty()) {
            Toast.makeText(this, "Introduce tu correo electrónico", Toast.LENGTH_SHORT).show();

        } else if(password.isEmpty()) {
            Toast.makeText(this,"Introduce tu contraseña", Toast.LENGTH_SHORT).show();
        } else{
             Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show();
            }

        });

        // textview para ir a la pantalla de Register
        txtRegister.setOnClickListener(v -> {

            // Intent es para abrir una nueva pantalla (en este caso RegisterActivity)
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent); // le decimos que inicie la nueva Activity (pantalla de Registro)

        });

    }
}