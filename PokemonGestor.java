import java.io.IOException;
import java.util.*;

public class PokemonGestor {
    private Map<String, Pokemon> pkmData;
    private List<Pokemon> pkmCol;

    // Constructor que inicializa el tipo de Map y carga los Pokémon desde el archivo
    public PokemonGestor(int tipoMapa) throws IOException {
        this.pkmData = MapFactory.getMap(tipoMapa);
        this.pkmCol = new ArrayList<>();
        this.pkmData.putAll(Lector.cargarPokemones("pokemon_data.csv"));
    }

    // Agrega un Pokémon a la colección del usuario si no está repetido
    public void agregarPkm(String nom) {
        System.out.println();
        if (!pkmData.containsKey(nom)) {
            System.out.println("Error: El Pokemon '"+nom+"' no existe en la base de datos.");
            return;
        }

        Pokemon pkm = pkmData.get(nom);
        if (pkmCol.contains(pkm)) {
            System.out.println("El Pokemon '"+nom+"' ya está en tu colección.");
        } else {
            pkmCol.add(pkm);
            System.out.println("Pokemon '"+nom+"' agregado a tu colección: " + nom);
        }
    }

    // Muestra la información de un Pokémon si existe en la base de datos
    public void mostrarPkm(String nom) {
        System.out.println();
        if (pkmData.containsKey(nom)) {
            System.out.println(pkmData.get(nom));
        } else {
            System.out.println("El Pokemon '"+nom+"' no existe en la base de datos.");
        }
    }

    // Muestra la colección del usuario ordenada por tipo
    public void mostrarColeccion() {
        System.out.println();
        pkmCol.sort(Comparator.comparing(Pokemon::getTp1));
        if(pkmCol.size() == 0){
            System.out.println("Su coleccion esta actualmente vacía");
        }
        for (Pokemon p : pkmCol) {
            System.out.println("Nombre: " + p.getNom() + ", Tipo1: " + p.getTp1() + ", Tipo2: " + p.getTp2() + ", Habilidades: " + p.getHabs());
        }
    }

    // Muestra todos los Pokémon disponibles en la base de datos, ordenados por tipo
    public void mostrarTodos() {
        System.out.println();
        List<Pokemon> pkmOrdenados = new ArrayList<>(pkmData.values());
        pkmOrdenados.sort(Comparator.comparing(Pokemon::getTp1));
        for (Pokemon p : pkmOrdenados) {
            System.out.println("Nombre: " + p.getNom() + ", Tipo1: " + p.getTp1() + ", Tipo2: " + p.getTp2() + ", Habilidades: " + p.getHabs());
        }
    }

    // Muestra los Pokémon que tienen una habilidad específica
    public void buscarPorHab(String hab) {
        System.out.println();
        for (Pokemon p : pkmData.values()) {
            if (p.getHabs().contains(hab)) {
                System.out.println(p.getNom() + " tiene la habilidad " + hab);
            }
        }
    }
}
