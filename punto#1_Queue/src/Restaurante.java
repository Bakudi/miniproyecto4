import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Restaurante {




    public static void menu(){
        Queue<String> cola = cargarColaDesdeArchivo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Llega una persona");
            System.out.println("2. Atender persona");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la persona que llega: ");
                    String nombre = scanner.nextLine();
                    cola.add(nombre);
                    guardarColaEnArchivo(cola);
                    System.out.println(nombre + " ha sido agregado a la cola.\n");
                    break;
                case 2:
                    if (!cola.isEmpty()) {
                        String personaAtendida = cola.poll();
                        guardarColaEnArchivo(cola);
                        System.out.println("Atendiendo a " + personaAtendida + ".\n");
                    } else {
                        System.out.println("La cola está vacía. No hay personas para atender.\n");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }
    }

    private static Queue<String> cargarColaDesdeArchivo() {
        Queue<String> cola = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Files/cola.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                cola.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cola;
    }

    private static void guardarColaEnArchivo(Queue<String> cola) {
        try (FileWriter fw = new FileWriter("Files/cola.txt")) {
            for (String nombre : cola) {
                fw.write(nombre + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
        menu();
    }
}

