package PRACT01_04;
/* Escribe un programa en Java que solicite al usuario una serie de números y luego calcule y muestre las siguientes estadísticas:
El número total de elementos.
La suma de los elementos.
El promedio de los elementos.
El número más grande.
El número más pequeño.
Tu programa debe solicitar al usuario que ingrese los números uno por uno, 
y cuando el usuario ingrese  -1, el programa debería terminar la entrada y mostrar las estadísticas.
 */


 import java.util.Scanner;

 public class PRACT03 {
     public static void main(String[] args) {
         Scanner leer = new Scanner(System.in); // leer datos de entrada
 
         // declarar variables
         int num = 0;
         int total = 0;
         int mayor = Integer.MIN_VALUE;
         int menor = Integer.MAX_VALUE;
         int cont = 0;
 
         int opt = 0;
 
         do {
             menu(); // menú
             System.out.print("Ingrese su opción: "); //pedir al usuario una opción
             opt = leer.nextInt(); 
 
             if (opt == 1) {
                 System.out.println("Ingrese un número (-1 para terminar): ");
                 
                 // calcular estadísticas
                 while (true) {
                     num = leer.nextInt(); 
                     
                     if (num == -1) { // si el usuario ingresa -1, cerrar programa
                         break;
                     }
                     
                     if (num > mayor) {
                         mayor = num; // num mayor
                     }
                     if (num < menor) {
                         menor = num; // num menor
                     }
                     total += num; // sum num
                     cont++; 
                 }
                 
                 // resultados
                 if (cont > 0) {
                     System.out.println("Tamaño de la lista = " + cont); // length de la lista
                     System.out.println("Num min = " + menor); // num min
                     System.out.println("Num max = " + mayor); // num max
                     System.out.println("Suma total = " + total); // total sum
                     double promedio = (double) total / cont; // promedio
                     System.out.println("Promedio = " + promedio); // imprimir promedio
                 } else {
                     System.out.println("No se ingresaron números para calcular!!"); // por si el usuario no ingresa numeros
                 }
             }
         } while (opt != -1); // se continua mientras el usuario no eliga -1
 
         leer.close(); // cerrar scanner para que se vea bonito
     }
 
     // método del menú
     public static void menu() {
         System.out.println("CALCULADORA ESTADÍSTICA");
         System.out.println("1. Calcular datos");
         System.out.println("-1. No deseo continuar");
     }
 }
 
