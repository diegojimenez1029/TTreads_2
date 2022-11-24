package com.example.ttreads2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrearMascota extends AppCompatActivity {

    private List<Animal> animalList = new ArrayList<Animal>();
    ArrayAdapter <Animal> animalArrayAdapter;

    EditText nameM, tipoM, razaM;
    ListView listV_mascotas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Animal animalSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_mascota);





        nameM = findViewById(R.id.txtnombrem);
        tipoM = findViewById(R.id.txttipom);
        razaM = findViewById(R.id.txtrazam);
        listV_mascotas = findViewById(R.id.listM);
        iniciarFireBase ();
        listarDatos();
        listV_mascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                animalSelected =(Animal) parent.getItemAtPosition(position);
                nameM.setText(animalSelected.getNombre());
                tipoM.setText(animalSelected.getTipo());
                razaM.setText(animalSelected.getRaza());
            }
        });

    }

    private void listarDatos() {
        databaseReference.child("Animal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                animalList.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()) {
                    Animal a = objSnaptshot.getValue(Animal.class);
                   animalList.add(a);

                    animalArrayAdapter = new ArrayAdapter<Animal>(CrearMascota.this, android.R.layout.simple_list_item_1, animalList);
                    listV_mascotas.setAdapter(animalArrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_crear, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String nombre = nameM.getText().toString();
        String tipo = tipoM.getText().toString();
        String raza = razaM.getText().toString();


        switch (item.getItemId()) {
            case R.id.icon_add: {
                if (nombre.equals("") || tipo.equals("") || raza.equals("")) {
                    validacion();
                } else {

                    Animal a = new Animal();
                    a.setUid(UUID.randomUUID().toString());
                    a.setNombre(nombre);
                    a.setTipo(tipo);
                    a.setRaza(raza);
                    databaseReference.child ("Animal").child(a.getUid()).setValue(a);
                    Toast.makeText(this, "Agregado exitosamente", Toast.LENGTH_LONG).show();
                    limpiarcajas();

                }
                break;
            }

            case R.id.icon_save: {
                Animal a = new Animal ();
                a.setUid(animalSelected.getUid());
                a.setNombre(nameM.getText().toString().trim());
                a.setTipo(tipoM.getText().toString().trim());
                a.setRaza(razaM.getText().toString().trim());
                databaseReference.child("Animal").child(a.getUid()).setValue(a);
                Toast.makeText(this, "Actualizado exitosamente", Toast.LENGTH_LONG).show();
                limpiarcajas();
                break;
            }


            case R.id.icon_delete: {
                Animal a = new Animal ();
                a.setUid(animalSelected.getUid());
                databaseReference.child("Animal").child(a.getUid()).removeValue();
                Toast.makeText(this, "Eliminado exitosamente", Toast.LENGTH_LONG).show();
                limpiarcajas();
                break;

            }

            default:
                break;
        }
        return true;
    }

    private void limpiarcajas() {
        nameM.setText("");
        tipoM.setText("");
        razaM.setText("");
    }


    private void validacion() {
        String nombre = nameM.getText().toString();
        String tipo = tipoM.getText().toString();
        String raza = razaM.getText().toString();


        if (nombre.equals("")) {
            nameM.setError("Required");
        } else if (tipo.equals("")) {
            tipoM.setError("Required");
        } else if (raza.equals("")) {
            razaM.setError("Required");
        }
    }
}