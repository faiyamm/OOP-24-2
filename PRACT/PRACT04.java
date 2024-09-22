/* 2. Implementar un algoritmo para calcular el CURP y RFC de una persona física.
3. Investigar las reglas oficiales para calcular el CURP y RFC.
4. Con base al punto anterior se le solicitará al usuario datos como: nombre completo, fecha de
nacimiento, sexo, entre otros.
5. Los últimos 3 caracteres del RFC, así como los últimos 2 caracteres del CURP se generarán de
manera aleatoria.
6. El programa deberá crear y mostrar 3 objetos con datos diferentes:
a. Para el objeto 1 solo se generará el CURP.
b. Para el objeto 2 solo se generará el RFC.
c. Para el objeto 3 se generarán ambos datos (CURP Y RFC). */

import java.util.Scanner;

public class PRACT04 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // leer datos de entrada

        // declarar variables
        int opt = 0;

        do{
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
                    Curp(leer);
                    break;
                case 2:
                    RFC(leer);
                    break;
                case 3:
                    CurpRFC(leer);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intentar de nuevo.");
            }

        } while (opt != 4);
        
    }

    // método del menú principal
    public static void menu(){
    System.out.println("1. Generar CURP");
    System.out.println("2. Generar RFC");
    System.out.println("3. Generar CURP y RFC");
    System.out.println("4. Salir");
    }

    // método para leer los datos de la persona
    public static String Datos(Scanner leer){
        //nombre completo
        System.out.println("Nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Apellido Paterno: ");
        String paterno = leer.nextLine();
        System.out.println("Apellido Materno: ");
        String materno = leer.nextLine();
        
        System.out.println("Fecha de Nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = leer.nextLine();
    
        System.out.println("Sexo (M/F): ");
        String sexo = leer.nextLine();
    
        // Lista de estados
        String[] estado = {
            "AS = Aguascalientes", "BC = Baja California", "BS = Baja California Sur", "CC", "CL", "CM", "CS", "CH", "DF", "DG", 
            "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", 
            "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TS", "TL", "VZ", 
            "YN", "ZS", "SM", "NE = Nacido en el extranjero"
        };
    
        // Mostrar opciones de estado
        System.out.println("Seleccione su estado de nacimiento (0-31): ");
        for (int i = 0; i < estado.length; i++) {
            System.out.println(i + ": " + estado[i]);
        }
        int estadoIndex = leer.nextInt();
        String estadoSeleccionado = estado[estadoIndex];
        
        // Concatenar datos para formar la cadena final
        return nombre + " " + paterno + " " + materno + ", " + fechaNacimiento + ", " + sexo + ", Estado: " + estadoSeleccionado;
    }

    // método para generar CURP
    public static void Curp(Scanner leer){
        String datos = Datos(leer);
        String curp = datos.replaceAll("[^A-Za-z0-9]", "");
        System.out.println("CURP: " + curp);
    }
    

    
    
}
