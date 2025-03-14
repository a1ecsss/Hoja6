import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class PokemonGestorTest {
    private PokemonGestor gestor;

    // Se ejecuta antes de cada prueba para inicializar un PokemonGestor con un mapa vacío
    @Before
    public void setUp() throws IOException {
        gestor = new PokemonGestor(1);
    }

    // Prueba para verificar si se agrega un Pokémon correctamente
    @Test
    public void testAgregarPkm() {
        gestor.agregarPkm("pikachu");
        assertEquals(1, gestor.getPkmCol().size());
    }

    // Debería no agregar ningun pokemon ya quen oexiste en la base de datos por lo que el map queda vacio
    @Test
    public void testAgregarPkmNoExistente() {
        gestor.agregarPkm("pokemonFalso");
        assertEquals(0, gestor.getPkmCol().size());
    }

    // Deberia agregar pikachu, mostrarlo y verificar que el map tenga la key pikachu
    @Test
    public void testMostrarPkm() {
        gestor.agregarPkm("pikachu");
        gestor.mostrarPkm("pikachu"); 
        assertNotNull(gestor.getPkmData().get("pikachu")); // Pikachu debería existir en los datos
    }
}
