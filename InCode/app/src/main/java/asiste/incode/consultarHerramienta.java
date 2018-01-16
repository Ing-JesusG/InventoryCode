package asiste.incode;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

/*
  Created by garzj on 6/12/2017.
  Consulta de herramientas con conexion a base de datos
  mediante candenas JSON datos para servidor thinkingmediaco.com
*/

public class consultarHerramienta extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String JSON_STRING;
    String busqueda="";
    convertidor_busqueda filtradoadaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Para desaparacer la barra con el titulo que es el nombre de la aplicacion
        super.onCreate(savedInstanceState);
        // Volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Pone en la pantalla la vista (R:layout.nombre_de_la_vista)
        setContentView(R.layout.consulta_herramientas);
        // Vinculamos un boton a una accion mediante listener
        ListView lista = (ListView)findViewById(R.id.lista_herramientas);

        new busqueda().execute();
        filtradoadaptador = new convertidor_busqueda(this,R.layout.elemento_herramienta);
        lista.setAdapter(filtradoadaptador);
    }

    class busqueda extends AsyncTask<Void, Void, String> {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "https://www.thinkingmediaco.com/TFg4J1Cb1h/incode/ver_herramientas.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                /*Se adquiere el link para abrir la comunicación httpURLCOnnection y se puede meter un metodo post para poder
                enviar los datos que se requieran para organizar con las variables lo que se pide del servidor, asi intercambio
                datos con el servidor al mismo tiempo que los adquiero
                 */
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("busqueda" , "UTF-8") +"="+URLEncoder.encode(busqueda , "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*Termina la comunicación de envio a el servidor para la obtención de los datos y comienza la comunicación
                con él para recibir datos
                 */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) == null);{
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

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
            json_string = result;
            if (json_string == null) {
                Toast.makeText(getApplicationContext(), "No  hay conexión a internet", Toast.LENGTH_SHORT).show();
            } else {
                //inicializa objeto json
                try {
                    jsonObject = new JSONObject(json_string);
                    jsonArray = new JSONObject(json_string).getJSONArray("server_response");
                    int count = 0;

                    if (jsonArray.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Sin resultados", Toast.LENGTH_SHORT).show();
                    }
                    //INSERTA STRINGS NUEVOS
                    String nombre, cantidad, marca;

                    //llena la lista

                    while (count < jsonArray.length()) {
                        //Se obtiene la información
                        JSONObject JO = jsonArray.getJSONObject(count);
                        //INSERTA STRINGS NUEVOS
                        nombre = JO.getString("nombre");
                        cantidad = JO.getString("cantidad");
                        marca = JO.getString("marca");
                        //INSERTA STRINGS NUEVOS
                        consulta_herramientas filtradousuario = new consulta_herramientas(cantidad, nombre, marca);
                        filtradoadaptador.add(filtradousuario);
                        count = count + 1;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




