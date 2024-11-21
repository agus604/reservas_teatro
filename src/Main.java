import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el teatro
        Teatro teatro = new Teatro("Teatro Principal");
        Sala sala = new Sala("Sala 1", 10, 10); // Crear una sala de 10 filas y 10 asientos
        teatro.agregarSala(sala); // Agregar la sala al teatro

        while (true) {
            // Mostrar el mapa del teatro
            mostrarMapa(teatro);

            // Solicitar la reserva al usuario
            System.out.println("Ingrese la fila y el número de asiento que desea reservar (0 para salir): ");
            int fila = scanner.nextInt();
            if (fila == 0) {
                break; // Salir del programa
            }

            int asiento = scanner.nextInt();

            // Verificar que la fila y el asiento estén dentro del rango
            if (fila < 1 || fila > sala.getCantidadFilas() || asiento < 1 || asiento > sala.getCantidadAsientosPorFila()) {
                System.out.println("Error: Fila o asiento fuera de rango. Intente de nuevo.");
                continue;
            }

            // Realizar la reserva
            System.out.println("Ingrese el nombre del cliente:");
            String nombreCliente = scanner.next();

            // Crear cliente
            Cliente cliente = new Cliente(nombreCliente, "Documento"); // Aquí puedes agregar lógica para el documento

            // Intentar reservar el asiento
            if (sala.reservarAsiento(fila, asiento)) {
                Reserva reserva = new Reserva(cliente, new Asiento(fila, asiento));
                System.out.println("Reserva exitosa: " + reserva);
            } else {
                System.out.println("Error: El asiento ya está reservado.");
            }
        }

        scanner.close();
    }

    private static void mostrarMapa(Teatro teatro) {
        System.out.println("Mapa del Teatro:");
        for (Sala sala : teatro.getSalas()) {
            System.out.println("Sala: " + sala.getNombre());

            // Imprimir los números de las columnas
            System.out.print("   "); // Espacio para la numeración de filas
            for (int j = 1; j <= sala.getCantidadAsientosPorFila(); j++) {
                System.out.print(j + "  "); // Números de columnas
            }
            System.out.println(); // Nueva línea después de los números de las columnas

            for (int i = 1; i <= sala.getCantidadFilas(); i++) {
                System.out.print(i + " "); // Imprimir el número de la fila
                for (int j = 1; j <= sala.getCantidadAsientosPorFila(); j++) {
                    Asiento asiento = sala.getAsiento(i, j);
                    System.out.print(asiento.isReservado() ? "[X] " : "[ ] ");
                }
                System.out.println(); // Nueva línea después de cada fila
            }
            System.out.println(); // Nueva línea después de cada sala
        }
    }
}