package com.example.ttreads2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistro extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        username = findViewById(R.id.userRegistro1);
        password = findViewById(R.id.passUser2);
        repassword= findViewById(R.id.confPass1);
        signup = findViewById(R.id.registrar);
        DB = new DBHelper(this);




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(ActivityRegistro.this, "Todos lo campos son requeridos", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(ActivityRegistro.this, "Se ha registrado exitosamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ActivityRegistro.this, "El registro ha fallado", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Toast.makeText(ActivityRegistro.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(ActivityRegistro.this, "Las contrase??as no coinciden", Toast.LENGTH_SHORT).show();

                    }

                }


            }
        });}}

        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}*/
