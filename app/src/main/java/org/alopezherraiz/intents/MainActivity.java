package org.alopezherraiz.intents;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ejemplo de uso de la función playMedia con una Uri de un archivo de medios
        Uri mediaUri = Uri.parse("file:///sdcard/video.mp4");
        playMedia(mediaUri);
    }

    public void playMedia(Uri file) {
        // Crear un intent con la acción ACTION_VIEW y establecer la Uri del archivo de medios
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(file, "video/*"); // Especificar el tipo de medios que se abrirá

        // Comprobar si hay aplicaciones disponibles para manejar el intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Si hay aplicaciones disponibles, iniciar la actividad con el intent
            startActivity(intent);
        } else {
            // Si no hay aplicaciones disponibles, mostrar un mensaje de error
            Toast.makeText(this, "No se encontró una aplicación para reproducir el archivo de medios.", Toast.LENGTH_SHORT).show();
        }
    }
}
