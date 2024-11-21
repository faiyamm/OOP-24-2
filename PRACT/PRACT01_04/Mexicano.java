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

public class Mexicano {
    String nombre;
    String apellidoMaterno;
    String apellidoPaterno;
    String fechaNacimiento; // convert int to string
    String sexo;
    String estado; 
    String curp;
    String rfc;

    public Mexicano(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaNacimiento, String sexo, String estado) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estado = estado;
        this.curp = "";
        this.rfc = "";
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Apellido Paterno: ");
        String apellidoPaterno = leer.nextLine();
        System.out.println("Apellido Materno: ");
        String apellidoMaterno = leer.nextLine();
        System.out.println("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = leer.nextLine();
        System.out.println("Sexo (Hombre/Mujer): ");
        String sexo = leer.nextLine();
        System.out.println("Estado (clave de 2 letras): ");
        String estado = leer.nextLine();

        Mexicano mexicano1 = new Mexicano(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo, estado);
        Mexicano mexicano2 = new Mexicano(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo, estado);
        Mexicano mexicano3 = new Mexicano(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo, estado);

        System.out.println("===========================================");
        System.out.println("CURP: " + mexicano1.calcularCurp(apellidoPaterno, apellidoMaterno, nombre, fechaNacimiento, sexo, estado));
        System.out.println("===========================================");
        System.out.println("RFC: " + mexicano2.calcularRFC(apellidoPaterno, apellidoMaterno, nombre, fechaNacimiento));
        System.out.println("===========================================");
        System.out.println("CURP: " + mexicano3.calcularCurp(apellidoPaterno, apellidoMaterno, nombre, fechaNacimiento, sexo, estado) + " RFC: " + mexicano3.calcularRFC(apellidoPaterno, apellidoMaterno, nombre, fechaNacimiento));
    }

    // calcular curp
    public String calcularCurp(String apellidoPaterno, String apellidoMaterno, String nombre, String fechaNacimiento, String sexo, String estado) {
        String inicialAP = String.valueOf(apellidoPaterno.charAt(0));
        String vocalAP = firstVowel(apellidoPaterno);
        String inicialAM = String.valueOf(apellidoMaterno.charAt(0));
        String inicialN = String.valueOf(nombre.charAt(0));
        String fecha = fechaNacimiento.replace("-", "");
        char letraSexo = sexo.toUpperCase().charAt(0);
        String letraEstado = estado.substring(0, 2).toUpperCase();
        String consonanteAP = consonants(apellidoPaterno);
        String consonanteAM = consonants(apellidoMaterno);
        String consonanteN = consonants(nombre);


         // caracteres randoms
         Random random = new Random();
         char randomChar1 = (char) (random.nextInt(26) + 'A');
         char randomChar2 = (char) (random.nextInt(26) + 'A');

         String curp = inicialAP + vocalAP + inicialAM + inicialN + fecha.substring(2, 8) + letraSexo + letraEstado + consonanteAP + consonanteAM + consonanteN + randomChar1 + randomChar2;
         return curp.toUpperCase();
    }

    // calcular rfc
    public String calcularRFC(String apellidoPaterno, String apellidoMaterno, String nombre, String fechaNacimiento) {
        // implementar reglas de calculo rfc
        String inicialAP = String.valueOf(apellidoPaterno.charAt(0));
        String vocalAP = firstVowel(apellidoPaterno);
        String inicialAM = String.valueOf(apellidoMaterno.charAt(0));
        String inicialN = String.valueOf(nombre.charAt(0));
        String fecha = fechaNacimiento.replace("-", "");

        // caracteres randoms
        Random random = new Random();
        char randomChar1 = (char) (random.nextInt(26) + 'A');
        char randomChar2 = (char) (random.nextInt(26) + 'A');
        char randomChar3 = (char) (random.nextInt(26) + 'A');

        String rfc = inicialAP + vocalAP + inicialAM + inicialN + fecha.substring(2) + randomChar1 + randomChar2 + randomChar3;
        return rfc.toUpperCase();
    }

    // metodo para obtener las vocales del string
    private String firstVowel(String word){
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                return String.valueOf(word.charAt(i));
            }
        }
        return "";
    }

    // metodo para obtener las consonantes del string
    private String consonants(String word) {
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if ("BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(c) != -1) {
                return Character.toString(c).toUpperCase();
            }
        }
        return "X";
    }
}
