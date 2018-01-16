package asiste.incode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by garzj on 6/12/2017.
 */

public class agregarHerramienta extends Activity{
    String cant, nom, marc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.agregar_herramienta);
        // Vinculamos un boton a una accion mediante listener
        TextView cantidad = (TextView)findViewById(R.id.cantidad);
        TextView nombre = (TextView)findViewById(R.id.nombre);
        TextView marca = (TextView)findViewById(R.id.marca);




    }

    public void listo (View view)
    {
        TextView cantidad = (TextView)findViewById(R.id.cantidadH);
        TextView nombre = (TextView)findViewById(R.id.nombre);
        TextView marca = (TextView)findViewById(R.id.marca);

        cant = cantidad.getText().toString();
        nom = nombre.getText().toString();
        marc = marca.getText().toString();

        new guardar().execute();
    }

    class guardar extends AsyncTask<Void, Void, String> {

        ProgressDialog pd = new ProgressDialog(getApplicationContext());
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "https://www.thinkingmediaco.com/TFg4J1Cb1h/incode/guarda_herramienta.php";

            pd.show();
            pd.setCancelable(false);
            pd.setMax(5000);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {


                URL url = new URL(json_url);
                /*Se adquiere el link para abrir la comunicación httpURLCOnnection y se puede meter un metodo post para poder
                enviar los datos que se requieran para organizar con las variables lo que se pide del servidor, asi intercambio
                datos con el servidor al mismo tiempo que los adquiero
                 */
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("cantidad", "UTF-8") + "=" + URLEncoder.encode(cant, "UTF-8") + "&" + URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(nom, "UTF-8") + "&" +
                        URLEncoder.encode("marca", "UTF-8") + "=" + URLEncoder.encode(marc, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String result) {
            //quitamos la pantalla de carga
            pd.dismiss();
            //si el usuario y contraseña son correctos
            if(result.equals("1"))
            {
                Toast.makeText(agregarHerramienta.this, "¡Herramienta agregada", Toast.LENGTH_SHORT).show();

            }
            else if(result.equals("2"))//si hay algo incorrecto en el login
            {
                Toast.makeText(agregarHerramienta.this, nom+" "+cant+" "+marc, Toast.LENGTH_SHORT).show();
            }


        }
    }
}
