package asiste.incode;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by garzj on 6/12/2017.
 */

public class agregarPersonal extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.agregar_personal);
        // Vinculamos un boton a una accion mediante listener
        Toast.makeText(this, "WUBBA LUBA DUB DUB!!!!!!!", Toast.LENGTH_SHORT).show();

    }
}
