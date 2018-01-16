package asiste.incode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/*
    Created by Jesus Manuel Garcia Zavala on 4/12/2017.
    Redireccionamiento para el menu y opciones posibles de la aplicacion.
    Se busca mejorar el diseño y la distribucion de las opciones.
 */

public class menu extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)

    }
    public void menuAgregar(View view) {

        Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu.this,menu_Agregar.class);
        startActivity(intent);
    }
    public void menuConsultar(View view) {

        Toast.makeText(this, "Consultar", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu.this,menu_Consultar.class);
        startActivity(intent);
    }
    public void escanear_codigo (View view) {

        Toast.makeText(this, "Escanear Codigo QR", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu.this,escanear_codigo.class);
        startActivity(intent);
    }
    public void cerrarSesion (View view) {

        Toast.makeText(this, "Cerrarando Sesión", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu.this,Login.class);
        startActivity(intent);
    }
}

