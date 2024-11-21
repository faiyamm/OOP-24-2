package PRACT01_04;
/* 
1. Crear una clase llamada "Mexicano" que contenga como atributos: nombre, CURP, y RFC.
2. Implementar un algoritmo para calcular el CURP y RFC de una persona física.
3. Investigar las reglas oficiales para calcular el CURP y RFC.
4. Con base al punto anterior se le solicitará al usuario datos como: nombre completo, fecha de
nacimiento, sexo, entre otros.
5. Los últimos 3 caracteres del RFC, así como los últimos 2 caracteres del CURP se generarán de
manera aleatoria.
6. El programa deberá crear y mostrar 3 objetos con datos diferentes:
a. Para el objeto 1 solo se generará el CURP.
b. Para el objeto 2 solo se generará el RFC.
c. Para el objeto 3 se generarán ambos datos (CURP Y RFC). 
*/

import java.util.Random;
import java.util.Scanner;

public class PRACT04 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opt = 0;
        String[] datos = null; // guardar datos
        boolean datosIngresados = false; // verificar que se hayan ingresado datos

        do {
            menu();
            while (!leer.hasNextInt()) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                leer.next(); // limpiar buffer
                menu();
            }
            opt = leer.nextInt(); // leer opción del usuario

            switch (opt) {
                case 1: // generar CURP
                case 2: // generar RFC
                case 3: // generar CURP y RFC
                    if (!datosIngresados) { // obligar al usuario ingresar los datos si no lo ha hecho
                        datos = solicitarDatos(leer);
                        datosIngresados = true;
                    }
                    if (opt == 1) { // generar CURP
                        String curp = generarCurp(datos);
                        System.out.println("CURP: " + curp);
                    } else if (opt == 2) { // generar RFC
                        String rfc = generarRfc(datos);
                        System.out.println("RFC: " + rfc);
                    } else if (opt == 3) { // generar ambos
                        String curp = generarCurp(datos);
                        System.out.println("CURP: " + curp);
                        String rfc = generarRfc(datos);
                        System.out.println("RFC: " + rfc);
                    }
                    break;
                case 4: // reiniciar datos
                    datos = solicitarDatos(leer); // volver a pedir datos
                    datosIngresados = true;
                    System.out.println("Datos reiniciados.");
                    break;
                case 5: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intentar de nuevo.");
            }
        } while (opt != 5); // repetir hasta que el usuario decida salir

        leer.close();
    }

    public static void menu() {
        System.out.println("1. Generar CURP");
        System.out.println("2. Generar RFC");
        System.out.println("3. Generar CURP y RFC");
        System.out.println("4. Ingresar nuevos datos");
        System.out.println("5. Salir");
        System.out.println("Elegir opción: ");
    }

    // solicitar datos al usuario y retornar un array con nombre, apellidos, fecha, sexo, y estado
    public static String[] solicitarDatos(Scanner leer) {
        leer.nextLine(); // limpiar buffer
        System.out.println("Nombre: ");
        String nombre = leer.nextLine().trim();
        System.out.println("Apellido Paterno: ");
        String paterno = leer.nextLine().trim();
        System.out.println("Apellido Materno: ");
        String materno = leer.nextLine().trim();

        System.out.println("Fecha de Nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = leer.nextLine().trim();

        System.out.println("Sexo (M/F): ");
        String sexo = leer.nextLine().trim().toUpperCase();

        // arreglo: lista de estados
        String[] estados = {
            "AS = Aguascalientes", "BC = Baja California", "BS = Baja California Sur", "CC = Campeche", "CL = Coahuila",
            "CM = Colima", "CS = Chiapas", "CH = Chihuahua", "DF = Ciudad de México", "DG = Durango",
            "GT = Guanajuato", "GR = Guerrero", "HG = Hidalgo", "JC = Jalisco", "MC = Estado de México",
            "MN = Michoacán", "MS = Morelos", "NT = Nayarit", "NL = Nuevo León", "OC = Oaxaca",
            "PL = Puebla", "QT = Querétaro", "QR = Quintana Roo", "SP = San Luis Potosí", "SL = Sinaloa",
            "SR = Sonora", "TC = Tabasco", "TS = Tamaulipas", "TL = Tlaxcala", "VZ = Veracruz",
            "YN = Yucatán", "ZS = Zacatecas", "NE = Nacido en el extranjero"
        };

        System.out.println("Seleccione su estado de nacimiento (0-31): ");
        for (int i = 0; i < estados.length; i++) {
            System.out.println(i + ": " + estados[i]);
        }

        int estadoIndex = leer.nextInt();
        String estado = estados[estadoIndex].substring(0, 2); // solo extraer el código de estado

        return new String[] { nombre, paterno, materno, fechaNacimiento, sexo, estado };
    }

    public static String generarCurp(String[] datos) {
        // primeras 4 letras: inicial del primer apellido + primera vocal interna del primer apellido + inicial del segundo apellido + inicial del nombre
        String curp = datos[1].charAt(0) + "" + obtenerVocalInterna(datos[1]) +
                      datos[2].charAt(0) + datos[0].charAt(0);

        // fecha de nacimiento: YYMMDD
        curp += datos[3].substring(8, 10) + datos[3].substring(3, 5) + datos[3].substring(0, 2);

        // sexo (M/F)
        curp += datos[4];

        // estado de nacimiento
        curp += datos[5];

        // consonantes internas: del primer apellido, segundo apellido y primer nombre
        curp += obtenerConsonanteInterna(datos[1]); // Consonante interna del primer apellido
        curp += obtenerConsonanteInterna(datos[2]); // Consonante interna del segundo apellido
        curp += obtenerConsonanteInterna(datos[0]); // Consonante interna del primer nombre

        // caracteres random aka homoclave (últimos dos caracteres del CURP)
        curp += generarAleatorio(2);

        return curp.toUpperCase();
    }

    public static String generarRfc(String[] datos) {
        String rfc = datos[1].charAt(0) + "" + obtenerVocalInterna(datos[1]) +
                     datos[2].charAt(0) + datos[0].charAt(0); // primeras 4 letras

        rfc += datos[3].substring(8, 10) + datos[3].substring(3, 5) + datos[3].substring(0, 2); // fecha de nacimiento: YYMMDD
        rfc += generarAleatorio(3); // 3 caracteres randoms

        return rfc.toUpperCase();
    }

    // generar caracteres aleatorios
    public static String generarAleatorio(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }

    // obtener primera vocal interna
    public static char obtenerVocalInterna(String palabra) {
        for (int i = 1; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if ("AEIOUaeiou".indexOf(letra) != -1) {
                return letra;
            }
        }
        return 'X'; // default si no encuentra vocal
    }

    // obtener consonante interna
    public static char obtenerConsonanteInterna(String palabra) {
        for (int i = 1; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if ("BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(letra) != -1) {
                return letra;
            }
        }
        return 'X'; // default si no encuentra consonante
    }
}
