import java.util.List;

public class Pokemon {
    private String nom;
    private String tp1;
    private String tp2;
    private List<String> habs;

    // Constructor que inicializa los atributos del Pokemon
    public Pokemon(String nom, String tp1, String tp2, List<String> habs) {
        this.nom = nom;
        this.tp1 = tp1;
        this.tp2 = tp2;
        this.habs = habs;
    }

    // Retorna el nombre del Pokemon
    public String getNom() {
        return nom;
    }

    // Retorna el tipo primario del Pokemon
    public String getTp1() {
        return tp1;
    }

    // Retorna el tipo secundario del Pokemon
    public String getTp2() {
        return tp2;
    }

    // Retorna la lista de habilidades del Pokemon
    public List<String> getHabs() {
        return habs;
    }
}
