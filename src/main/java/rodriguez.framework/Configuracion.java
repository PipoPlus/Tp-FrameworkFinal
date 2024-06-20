package rodriguez.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Configuracion {

    public List<Accion> configToActionsList(String path) {
        List<Accion> acciones = new ArrayList<>();

        try (InputStream input = new FileInputStream(path)) {
            if (path.endsWith(".properties")) {
                // Manejar archivo .properties
                Properties properties = new Properties();
                properties.load(input);

                for (String key : properties.stringPropertyNames()) {
                    acciones.add(crearAccion(properties.getProperty(key)));
                }

            } else if (path.endsWith(".json")) {
                // Manejar archivo .json
                JSONObject jsonObject = new JSONObject(new JSONTokener(input));
                JSONArray accionesArray = jsonObject.getJSONArray("acciones");

                for (int i = 0; i < accionesArray.length(); i++) {
                    acciones.add(crearAccion(accionesArray.getString(i)));
                }

            } else {
                System.out.println("Formato de archivo no soportado.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración.");
            e.printStackTrace();
        }

        return acciones;
    }

    private Accion crearAccion(String nombreDeClase) {
        try {
            Class<?> clazz = Class.forName(nombreDeClase);
            return (Accion) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Error al cargar la clase: " + nombreDeClase);
            e.printStackTrace();
            return null; // O lanzar una excepción personalizada
        }
    }
}
