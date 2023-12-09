package unal.todosalau.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import unal.todosalau.ecorecicla.modelos.Metal;
import unal.todosalau.ecorecicla.modelos.Carton;

public class Statistics extends AppCompatActivity {
private TableLayout tableLayout;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_statistics);

    //Elementos de la interfaz
    Button botonRegresar = findViewById(R.id.botonRetroceso2);
    tableLayout = findViewById(R.id.myTableLayout);
    Intent intent = new Intent(this, Principal.class);

    //Carga de los archivos de agua y electricidad
    File aguaFile = new File(getFilesDir(), "agua.txt");
    File electricidadFile = new File(getFilesDir(), "electricidad.txt");

    //Listas de Agua y Electricidad
    List<Metal> listaMetal = leerArchivoAgua(aguaFile);
    List<Carton> listaCarton = leerArchivoElectricidad(electricidadFile);

    //Crear la Tabla
    addElementAgua(listaMetal);
    addElementElectricidad(listaCarton);
    addPromedioAgua(listaMetal);
    addPromedioElectricidad(listaCarton);

    //Boton Regresar
    botonRegresar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(intent);
        }
    });
    }
    private void addPromedioAgua(List<Metal> metalList){
    // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioConsumoAgua = calcularPromedioVolumenAgua(metalList);
        float promedioPrecioAgua = calcularPromedioPrecioAgua(metalList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("Agua");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioConsumoAgua));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioAgua));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addPromedioElectricidad(List<Carton> cartonList){
    // Obtén una referencia al TableLayout en tu actividad o fragmento

    float promedioConsumoElectricidad = calcularPromedioKilovatios(cartonList);
    float promedioPrecioElectricidad = calcularPromedioPrecioElectricidad(cartonList);

    TableRow row = new TableRow(this);
    //AÑADE LA INFORMACIÓN A LA CELDA 1
    TextView cell1 = new TextView(this);
    cell1.setText("Promedio");
    cell1.setPadding(10, 10, 10, 10);
    cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
    // color deseado

    //AÑADE LA INFORMACIÓN A LA CELDA 2
    TextView cell2 = new TextView(this);
    cell2.setText("electricidad");
    cell2.setPadding(10, 10, 10, 10);
    cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


    //AÑADE LA INFORMACIÓN A LA CELDA 3
    TextView cell3 = new TextView(this);
    cell3.setText(String.valueOf(promedioConsumoElectricidad));
    cell3.setPadding(10, 10, 10, 10);
    cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
    // el color

    //AÑADE LA INFORMACIÓN A LA CELDA 4
    TextView cell4 = new TextView(this);
    cell4.setText(String.valueOf(promedioPrecioElectricidad));
    cell4.setPadding(10, 10, 10, 10);
    cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
    // el color

    // Agrega las celdas a la fila
    row.addView(cell1);
    row.addView(cell2);
    row.addView(cell3);
    row.addView(cell4);
    // Agrega la fila al TableLayout
    tableLayout.addView(row);
}

    private void addElementAgua(List<Metal> metalList){
    // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Metal item: metalList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Agua");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getVolumen())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

        // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
        // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private void addElementElectricidad(List<Carton> cartonList){
    // Obtén una referencia al TableLayout en tu actividad o fragmento

    for (Carton item: cartonList) {
        // Crea una nueva fila y agrega las celdas
        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText(item.getMes());

        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("carton");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf((item.getKilovatios())));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf((item.getPrecio())));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }
}

    private static List<Metal> leerArchivoAgua(File archivo) {
    List<Metal> listaMetal = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            float volumen = Float.parseFloat(datos[0]);
            float precio = Float.parseFloat(datos[1]);
            String mes = datos[2];

            Metal metal = new Metal(volumen, precio, mes);
            listaMetal.add(metal);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return listaMetal;
    }

    private static List<Carton> leerArchivoElectricidad(File archivo) {
    List<Carton> listaCarton = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            float kilovatios = Float.parseFloat(datos[0]);
            float precio = Float.parseFloat(datos[1]);
            String mes = datos[2];

            Carton carton = new Carton(kilovatios, precio, mes);
            listaCarton.add(carton);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return listaCarton;
}

    private float calcularPromedioVolumenAgua(List<Metal> metalList) {
        float sum = 0;
        for (Metal item : metalList) {
            sum += item.getVolumen();
            }
        return sum / metalList.size();
    }
    private float calcularPromedioPrecioAgua(List<Metal> metalList) {
        float sum = 0;
        for (Metal item : metalList) {
            sum += item.getPrecio();
        }
        return sum / metalList.size();
    }

    private float calcularPromedioKilovatios(List<Carton> cartonList) {
        float sum = 0;
        for (Carton item : cartonList) {
            sum += item.getKilovatios();
        }
        return sum / cartonList.size();
    }

    private float calcularPromedioPrecioElectricidad(List<Carton> cartonList) {
        float sum = 0;
        for (Carton item : cartonList) {
            sum += item.getPrecio();
        }
        return sum / cartonList.size();
    }
}
