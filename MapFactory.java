import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    
    // Devuelve una implementación de Map según el tipo seleccionado por el usuario
    public static Map<String, Pokemon> getMap(int type) {
        switch (type) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
        }
    }
}
