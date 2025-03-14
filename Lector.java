import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lector {
    
    // Carga los Pokemon desde un archivo CSV y los almacena en un mapa
    public static Map<String, Pokemon> cargarPokemones(String ruta) throws IOException {
        Map<String, Pokemon> pokemones = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // Omitir encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 4) continue;

                // nombre en minusculas y sin espacios
                String nom = datos[0].trim().toLowerCase();
                String tp1 = datos[1].trim();
                String tp2 = datos[2].trim();
                List<String> habs = Arrays.asList(datos[3].split(";"));

                Pokemon pkm = new Pokemon(nom, tp1, tp2, habs);
                pokemones.put(nom, pkm);
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo: " + ruta);
        }
        return pokemones;
    }
}
