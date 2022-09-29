package com.example.ttreads2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

     Button Valorarbtn;
     Button Mapabtn;
     Button Catalogobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
                Intent i = new Intent(MainActivity2.this, MapaActivity.class);
                startActivity(i);
            }
        });

        Catalogobtn= (Button) findViewById(R.id.catalogobtn);
        Catalogobtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, CatalogoActivity.class);
                startActivity(i);
            }
        });
    }
}