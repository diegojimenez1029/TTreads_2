package com.example.ttreads2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button  signin, crearbtn;
    DBHelper DB;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        username=findViewById(R.id.edusername);
        password=findViewById(R.id.contraseña);
        signin=findViewById(R.id.btingresar);
        DB=new DBHelper(this);

        crearbtn= (Button) findViewById(R.id.btncrear);

        crearbtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ActivityRegistro.class);
                startActivity(i);
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this,"Todos los campos son requeridos",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this,"Se ha autenticado de manera éxitosa", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent (getApplicationContext(),MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Autenticación fallida",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}









