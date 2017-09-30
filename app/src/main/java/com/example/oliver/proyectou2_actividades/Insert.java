package com.example.oliver.proyectou2_actividades;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Insert extends AppCompatActivity {

    TextView registro;
    EditText nombre, celular, correo,carrera;
    Button agregar;
    DBAdapter bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        registro = (TextView) findViewById(R.id.textView);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        celular = (EditText) findViewById(R.id.txt_cel);
        correo = (EditText) findViewById(R.id.txt_correo);
        carrera = (EditText) findViewById(R.id.txt_carrera);
        agregar = (Button) findViewById(R.id.btn_agregar);

        bd=new DBAdapter(getApplicationContext());
        insertarDatos();

    }
    public void insertarDatos(){
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.open();
                String name = nombre.getText().toString();
                String phone = celular.getText().toString();
                String mail = correo.getText().toString();
                String career = carrera.getText().toString();
                long val = bd.insertContact(name,mail,phone,career);
                Log.d("MyDB",val+"");
                Toast.makeText(getApplicationContext(),"Se insertó un nuevo contacto",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Insert.this, MainActivity.class));
                bd.close();
            }
        });
    }


}
