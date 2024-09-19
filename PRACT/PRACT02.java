/* Ejercicio: Implementar un menú con sus respectivas opciones:
1 Captura de nombre y calificaciones.
2 Imprimir calificaciones y promedio de calificaciones.
3 Imprimir calificaciones y calificación más baja.
4 Imprimir calificaciones y calificación más alta.
5 Salir
Actividades:
● Capturar 5 calificaciones, base 100 considerando punto decimal.
● Crear variables y constantes de diferentes tipos de datos (strings, enteros, flotantes, etc).
● Crear diversas expresiones (operadores, declaraciones, etc.).
● Implementar estructuras de control de flujo (if/else, switch, for, while, etc.).
● El programa deberá repetirse mientras el usuario lo desee. 

Puntos extras (+5):
○ Validaciones en menú y captura de calificaciones.
*/

import java.util.Scanner;

public class PRACT02 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer datos de entrada

        // declarar variables
        String nombre = "";
        double calificacion1 = 0, calificacion2 = 0, calificacion3 = 0, calificacion4 = 0, calificacion5 = 0;
        double promedio;
        double calificacionMin = Double.MAX_VALUE;
        double calificacionMax = Double.MIN_VALUE;
        int opt = 0;

        do {
            menu(); // menú
            // Validar la opción del menú
            while (!leer.hasNextInt()) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                leer.next(); // limpiar buffer
                menu();
            }
            opt = leer.nextInt(); // leer opción del usuario

            switch (opt) {
                case 1:
                    // pedir el nombre y las calificaciones
                    System.out.print("Ingrese el nombre: ");
                    nombre = leer.next();
                    
                    calificacion1 = leerCalificacion("Ingrese la calificación 1: ", leer);
                    calificacion2 = leerCalificacion("Ingrese la calificación 2: ", leer);
                    calificacion3 = leerCalificacion("Ingrese la calificación 3: ", leer);
                    calificacion4 = leerCalificacion("Ingrese la calificación 4: ", leer);
                    calificacion5 = leerCalificacion("Ingrese la calificación 5: ", leer);
                    
                    // acomodar
                    calificacionMin = Math.min(Math.min(calificacion1, calificacion2), 
                                               Math.min(Math.min(calificacion3, calificacion4), calificacion5));
                    calificacionMax = Math.max(Math.max(calificacion1, calificacion2), 
                                               Math.max(Math.max(calificacion3, calificacion4), calificacion5));
                    break;

                case 2:
                    // imprimir promedio
                    promedio = (calificacion1 + calificacion2 + calificacion3 + calificacion4 + calificacion5) / 5;
                    System.out.println("Promedio: " + promedio);
                    break;

                case 3:
                    // imprimir calificación más baja
                    System.out.println("Calificación más baja: " + calificacionMin);
                    break;

                case 4:
                    // imprimir calificación más alta
                    System.out.println("Calificación más alta: " + calificacionMax);
                    break;

                case 5:
                    // exit
                    System.out.println("Saliendo del programa...");
                    break;

                default: // PUNTOS EXTRAS: validación del menú
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        } while (opt != 5);

        // cerrar scanner para que se vea bonito el código
        leer.close();
    }

    public static void menu() {
        System.out.println("1. Captura de nombre y calificaciones.");
        System.out.println("2. Promedio.");
        System.out.println("3. Imprimir calificación más baja.");
        System.out.println("4. Imprimir calificación más alta.");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
    }

    // PUNTOS EXTRAS: validar calificaciones
    public static double leerCalificacion(String mensaje, Scanner scanner) {
        double calificacion = -1;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextDouble()) {
                System.out.println("Ingresar un número.");
                scanner.next(); // limpiar buffer :DDD
                System.out.print(mensaje);
            }
            calificacion = scanner.nextDouble();
            if (calificacion < 0 || calificacion > 100) {
                System.out.println("La calificación debe estar entre 0 y 100!!");
            }
        } while (calificacion < 0 || calificacion > 100);
        return calificacion;
    }
}