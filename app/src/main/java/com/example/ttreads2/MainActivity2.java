package com.example.ttreads2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

     Button Valorarbtn;
     Button Mapabtn;
     Button Buscarbtn;
     Button Registrarm;
     private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        Valorarbtn= (Button) findViewById(R.id.valorarbtn);
        Valorarbtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, ValoracionActivity.class);
                startActivity(i);
            }
        });

        Mapabtn= (Button) findViewById(R.id.btnmapa);
        Mapabtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MapsActivity.class);
                startActivity(i);
            }
        });



        Buscarbtn= (Button) findViewById(R.id.buscarbtn);
        Buscarbtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MapaActivity.class);
                startActivity(i);
            }
        });

        Registrarm = (Button) findViewById(R.id.RegistrarM);
        Registrarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity2.this,CrearMascota.class);
                startActivity(i);
            }
        });


        TextView textView = (TextView)findViewById(R.id.tv1);

        Intent intent =getIntent();

        textView.setText(intent.getStringExtra("nombre"));



       // String dato = getIntent().getStringExtra("dato");
        //tv1.setText("Hola"+dato);




    }
}