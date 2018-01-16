package asiste.incode;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by garzj on 6/12/2017.
 */

public class escanear_codigo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.escanear_codigo);
        // Vinculamos un boton a una accion mediante listener

    }
}
