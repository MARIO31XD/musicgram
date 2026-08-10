package com.example.musicgram_.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;

import com.example.musicgram_.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // fields of form
        EditText etEmail = findViewById(R.id.etEmail); // field email
        EditText etPassword = findViewById(R.id.etPassword); // field Password

        Button btnLogin = findViewById(R.id.btnLogin); // boton para hacer Login y iniciar sesión


        btnLogin.setOnClickListener(v ->{
          String email = etEmail.getText().toString(); // cogemos los datos de los Strings
          String password = etPassword.getText().toString(); // tanto del email como del password
        });

    }
}