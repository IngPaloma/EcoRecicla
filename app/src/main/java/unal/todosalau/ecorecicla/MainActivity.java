package unal.todosalau.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import unal.todosalau.ecorecicla.R;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Crear archivo para usuarios y escribir los datos
    File file1 = new File(getFilesDir(), "datos.txt");
    try {
        FileWriter writer = new FileWriter(file1);
        writer.append("Daniel,daniielbeltran26@gmail.com,m,m\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Crear archivo para registro de agua
    File file2 = new File(getFilesDir(), "agua.txt");
    try {
        FileWriter writer = new FileWriter(file2);
        writer.append("15,150000,enero\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Crear archivo para registro de electricidad
    File file3 = new File(getFilesDir(), "electricidad.txt");
    try {
        FileWriter writer = new FileWriter(file3);
        writer.append("15,150000,enero\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Crear archivo para registro de consejos
    File file4 = new File(getFilesDir(), "consejos.txt");
    try {
        FileWriter writer = new FileWriter(file4);

        // Lista de consejos para ahorrar agua y electricidad en un array
        String[] consejos = {
                "Separar los residuos en distintos contenedores como orgánicos, plásticos, vidrios, metales, etc. Así se facilita su reciclaje.",
                "Enjuagar envases y recipientes antes de reciclarlos para eliminar residuos de comida u otras sustancias. Esto evita contaminación.",
                "Aplastar botellas, latas y cajas de cartón para reducir el volumen de basura y aprovechar mejor los contenedores de reciclaje.",
                "Reutilizar productos como envases de vidrio o latas para almacenar y transportar alimentos u otros artículos. Alargar su vida útil.",
                "Optar por productos con menos envoltorios al comprar, elegir a granel, llevar bolsas reutilizables. Menos desperdicios.",
                "Donar la ropa, muebles y artículos del hogar que estén en buen estado en lugar de desecharlos. Pueden ser útiles para otros.",
                "Comprar productos reciclados hechos de materiales recuperados y reciclados como papel, plástico o vidrio. Cerrar el ciclo.",
                "Llevar los RAEE (residuos de aparatos eléctricos y electrónicos) a puntos limpios para su adecuado reciclaje.",
                "Educar y concienciar sobre la importancia del reciclaje a amigos, familia, especialmente los más pequeños.",
                "Investigar y conocer dónde se ubican los contenedores para reciclaje más cercanos a nuestra vivienda/trabajo. Facilitar el proceso."
        };
        // Recorrer el array y agregar los consejos al archivo
        writer.append("Lista de consejos para reciclar:\n");
        for (String consejo : consejos) {
            writer.append(consejo).append("\n");
        }
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Intent intent = new Intent(this, Login.class);
    startActivity(intent);
    }
}