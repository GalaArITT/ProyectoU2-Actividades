package com.example.oliver.proyectou2_actividades;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    FloatingActionButton fab;
    DBAdapter bd;
    int idAux[];

    AdaptadorListView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        fab=(FloatingActionButton)findViewById(R.id.floatingActionButton);

        activity_agregar();

        bd=new DBAdapter(getApplicationContext());
        llenarLista();
    }

    private void llenarLista(){
        bd.open();

        int n=bd.lengthQuery();
        String [] nombre = new String[n];
        String [] email = new String[n];
        String [] telefono = new String[n];
        String [] carrera = new String[n];
        int ids[] = new int[n];
        int i=0;
        Cursor result=bd.getAllContactsAZ();
        result.moveToFirst();
        while (!result.isAfterLast()) {
            int id=result.getInt(0);
            String name=result.getString(1);
            String email1=result.getString(2);
            String phone=result.getString(3);
            String carrera1 = result.getString(4);

            ids[i]=id;
            nombre[i]=name;
            email[i]=email1;
            telefono[i]=phone;
            carrera[i]=carrera1;

            i++;

            result.moveToNext();
        }
        result.close();
        idAux=ids;
        adapter = new AdaptadorListView(this, nombre,email,telefono,carrera);
        lista.setAdapter(adapter);
        bd.close();
    }

    public void activity_agregar(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Insert.class));
            }
        });
    }

}
