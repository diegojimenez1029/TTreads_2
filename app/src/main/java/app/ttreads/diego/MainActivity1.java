package app.ttreads.diego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ttreads2.R;

public class MainActivity1 extends AppCompatActivity {

    private CheckBox seleccionarChk;
    Button Registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


Button button =(Button)findViewById(R.id.btnregistrar);

final EditText editText= (EditText) findViewById(R.id.editTextTextPersonName3);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent (getApplicationContext(),MainActivity2.class);
        intent.putExtra("nombre",editText.getText().toString());
        startActivity(intent);
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


        Button button = (Button)findViewById(R.id.btnregistrar);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });


    }



    }
