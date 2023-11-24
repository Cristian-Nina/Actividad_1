package Actividad1;

import java.util.Scanner;

public class RegistroPersonas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Almacenar los datos de las personas
        String[][] personas = new String[100][4]; // Máximo 100 personas, cada una con 4 atributos

        int opcion;
        do {
            // Menú de la aplicación
            System.out.println("\n1. Ingresar datos de una persona");
            System.out.println("2. Listar todas las personas registradas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarDatosPersona(personas);
                    break;
                case 2:
                    listarPersonas(personas);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    // Método para ingresar datos de una persona
    private static void ingresarDatosPersona(String[][] personas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese los datos de la persona:");

        // Pedir y validar nombre y apellido
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        // Verificar si la persona ya está registrada
        for (int i = 0; i < personas.length; i++) {
            if (personas[i][0] != null && personas[i][1] != null) {
                if (personas[i][0].equalsIgnoreCase(nombre) && personas[i][1].equalsIgnoreCase(apellido)) {
                    System.out.println("Esta persona ya está registrada. No se permiten duplicados.");
                    return; // Salir del método si la persona ya está registrada
                }
            }
        }

        // Pedir y validar DNI
        System.out.print("DNI (8 dígitos): ");
        String dni = scanner.nextLine();
        while (!dni.matches("\\d{8}")) {
            System.out.println("El DNI debe ser un número válido de 8 dígitos. Intente de nuevo.");
            System.out.print("DNI (8 dígitos): ");
            dni = scanner.nextLine();
        }

        // Pedir y validar fecha de nacimiento
        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        while (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Fecha de nacimiento no válida. Use el formato dd/mm/yyyy. Intente de nuevo.");
            System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
            fechaNacimiento = scanner.nextLine();
        }

        // Guardar los datos en el array
        for (int i = 0; i < personas.length; i++) {
            if (personas[i][0] == null) {
                personas[i][0] = nombre;
                personas[i][1] = apellido;
                personas[i][2] = dni;
                personas[i][3] = fechaNacimiento;
                System.out.println("Datos de la persona guardados exitosamente.");
                break;
            }
        }
    }

    // Método para listar todas las personas registradas
    private static void listarPersonas(String[][] personas) {
        System.out.println("\nLista de personas registradas:");

        for (int i = 0; i < personas.length; i++) {
            if (personas[i][0] != null) {
                System.out.println("Nombre: " + personas[i][0]);
                System.out.println("Apellido: " + personas[i][1]);
                System.out.println("DNI: " + personas[i][2]);
                System.out.println("Fecha de nacimiento: " + personas[i][3]);
                System.out.println("------------------------");
            }
        }
    }
}
