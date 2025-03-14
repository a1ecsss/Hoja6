import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapOption = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Seleccione la implementación de Map:");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.print("Ingrese su opcion: ");

            String entrada = scanner.nextLine().trim();

            if (entrada.matches("[1-3]")) { // Verifica si la entrada es un número entre 1 y 3
                mapOption = Integer.parseInt(entrada);
                entradaValida = true;
            } else {
                System.out.println("Opcion inválida. ingrese solo numeros entre 1 y 3");
            }
        }

        try {
            PokemonGestor gestor = new PokemonGestor(mapOption);

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

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del Pokemon que desea agregar: ");
                        String nom = scanner.nextLine();
                        gestor.agregarPkm(nom);
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del Pokemon: ");
                        String nomMostrar = scanner.nextLine();
                        gestor.mostrarPkm(nomMostrar);
                        break;
                    case 3:
                        gestor.mostrarColeccion();
                        break;
                    case 4:
                        gestor.mostrarTodos();
                        break;
                    case 5:
                        System.out.print("Ingrese la habilidad a buscar: ");
                        String hab = scanner.nextLine();
                        gestor.buscarPorHab(hab);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa... Vuelve pronto :D");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opcion invalida.");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
