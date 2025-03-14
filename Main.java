import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapOption = 0;
        boolean entradaValida = false;

        // Solicita al usuario seleccionar el tipo de Map válido
        while (!entradaValida) {
            System.out.println("Seleccione la implementación de Map:");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.print("Ingrese su opcion: ");

            String entrada = scanner.nextLine().trim();

            if (entrada.matches("[1-3]")) {
                mapOption = Integer.parseInt(entrada);
                entradaValida = true;
            } else {
                System.out.println("Opcion inválida. ingrese solo numeros entre 1 y 3");
            }
        }

        try {
            PokemonGestor gestor = new PokemonGestor(mapOption);

            // Menú de opciones
            while (true) {
                System.out.println("\nOpciones:");
                System.out.println("1. Agregar un Pokemon a tu coleccion");
                System.out.println("2. Mostrar datos de un Pokemon");
                System.out.println("3. Mostrar colección");
                System.out.println("4. Mostrar todos los Pokemon");
                System.out.println("5. Mostrar Pokemon por habilidad");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opcion: ");

                int opcion;
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.next();
                    System.out.println("Opcion invalida.");
                    continue;
                }

                // Ejecuta la opción seleccionada
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del Pokemon que desea agregar: ");
                        String nom = scanner.nextLine().trim().toLowerCase();
                        gestor.agregarPkm(nom);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa... Vuelve pronto :D");
                        scanner.close();
                        return;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
