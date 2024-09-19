import java.util.Scanner; // Importar solo Scanner para entrada de usuario

public class p {

    public static void main(String[] args) {
        choice(); // Llamar a la función principal
    }

    // Función principal
    public static void choice() {
        Scanner scanner = new Scanner(System.in); // Inicializar scanner para entrada de usuario
        
        while (true) {
            System.out.println("CALCULADORA ESTADÍSTICA");
            System.out.print("1. Calcular datos\t-1. No deseo continuar\t Opción: "); 
            int choice = scanner.nextInt(); // Leer la opción del usuario

            if (choice == 1) {
                System.out.print("¿Cuántos números deseas ingresar?: ");
                int cantidad = scanner.nextInt(); // Leer cantidad de números que el usuario desea ingresar
                
                // Declarar variables necesarias
                int num, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;

                // Pedir los números uno por uno
                for (int i = 1; i <= cantidad; i++) {
                    System.out.print("Ingresa el número " + i + ": ");
                    num = scanner.nextInt(); // Leer número del usuario
                    
                    // Verificar si el número es el mínimo
                    if (num < min) {
                        min = num; // Actualizar mínimo
                    }
                    
                    // Verificar si el número es el máximo
                    if (num > max) {
                        max = num; // Actualizar máximo
                    }
                    
                    // Acumular la suma
                    sum += num; // Actualizar la suma total
                }

                // Mostrar resultados
                System.out.println("Tamaño de la lista = " + cantidad); // Mostrar tamaño de la lista
                System.out.println("Num min = " + min); // Mostrar número mínimo
                System.out.println("Num max = " + max); // Mostrar número máximo
                System.out.println("Suma total = " + sum); // Mostrar suma total
                double promedio = (double) sum / cantidad; // Calcular promedio
                System.out.println("Promedio = " + promedio); // Mostrar promedio

            } else if (choice == -1) {
                break; // Salir del programa
            }
        }
        scanner.close(); // Cerrar el scanner
    }
}
