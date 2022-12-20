package com.example.redessolidarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/* Autor: Carlos Alberto Rey Ardila
Grupo 103 Desarrollo Movil
Unab Mision TIC 2022
Sprint 4
Otros miembros del Equipo 6: Maria Fernanda Sosa, Cristian Avila, Alex Rueda -104- y Leonardo Gonzalez
 */

public class MainActivity extends AppCompatActivity {
    private Button buttonScreenSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonScreenSplash = (Button) findViewById(R.id.buttonScreenSplash);
        buttonScreenSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}