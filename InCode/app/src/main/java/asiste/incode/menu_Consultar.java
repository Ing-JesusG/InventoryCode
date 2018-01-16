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

public class menu_Consultar extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.menu_consultar);

    }
    public void conCaja (View view) {

        Toast.makeText(this, "Consultar caja", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Consultar.this,consultarCaja.class);
        startActivity(intent);
    }
    public void conHerramienta (View view) {

        Toast.makeText(this, "Consultar Herramienta", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Consultar.this,consultarHerramienta.class);
        startActivity(intent);
    }
    public void conEquipo (View view) {

        Toast.makeText(this, "Consultar Equipo", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Consultar.this,consultarEquipo.class);
        startActivity(intent);
    }
    public void conProyecto (View view) {

        Toast.makeText(this, "Consultar Proyecto", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Consultar.this,consultarProyecto.class);
        startActivity(intent);
    }
    public void conPersonal (View view) {

        Toast.makeText(this, "Consultar Personal", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(menu_Consultar.this,consultarPersonal.class);
        startActivity(intent);
    }

}
