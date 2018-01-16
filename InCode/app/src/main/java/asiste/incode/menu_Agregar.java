package asiste.incode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by garzj on 6/12/2017.
 */

public class menu_Agregar extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.menu_agregar);
        // Vinculamos un boton a una accion mediante listener

    }
    public void cajaH (View view) {

        Toast.makeText(this, "Agregar caja", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Agregar.this,agregarCaja.class);
        startActivity(intent);
    }
    public void herramienta (View view) {

        Toast.makeText(this, "Agregar Herramienta", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Agregar.this,agregarHerramienta.class);
        startActivity(intent);
    }
    public void equipo (View view) {

        Toast.makeText(this, "Agregar Equipo", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Agregar.this,agregarEquipo.class);
        startActivity(intent);
    }
    public void proyecto (View view) {

        Toast.makeText(this, "Agregar Proyecto", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Agregar.this,agregarProyecto.class);
        startActivity(intent);
    }
    public void personal (View view) {

        Toast.makeText(this, "Agregar Personal", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Agregar.this,agregarPersonal.class);
        startActivity(intent);
    }

}
