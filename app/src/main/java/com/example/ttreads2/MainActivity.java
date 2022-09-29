package com.example.ttreads2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox seleccionarChk;
    Button Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seleccionarChk = (CheckBox) findViewById(R.id.checkSeleccionar);

        Registrar= (Button) findViewById(R.id.btnregistrar);
        Registrar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }

    public void btnChek (View view){
        if (seleccionarChk.isChecked()==true){
            String mensaje = "Seleccionado";
            Toast toast = Toast.makeText(this,"Seleccionado!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.START, 90,0);
                        toast.show();
        }
        else{
            String mensaje = "No seleccionado";
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }


    }


    }
