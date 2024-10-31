import java.util.Scanner;
import java.util.ArrayList;

public class Banco {  
    private ArrayList<Cuenta> cuenta;

    public Banco(){
        cuenta = new ArrayList<Cuenta>();
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Banco banco = new Banco(); // banco
        int opc;
    
        // imprimir menú en un do-while
        do {
            menu();
            System.out.println("Opción: ");
            opc = leer.nextInt();
    
            switch(opc) {
                case 1:
                    banco.crearCuenta();
                    break;
                case 2:
                    banco.accederCuenta();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while(opc != 3);
        
        leer.close();
    }
    

    public static void menu(){
        System.out.println("1. Crear cuenta");
        System.out.println("2. Acceder a cuenta");
        System.out.println("3. Salir");
    }

    // método para crear una cuenta y guardar la cuenta (recordarla en un ArrayList)
    public void crearCuenta(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre del titular: ");
        String titular = leer.nextLine();

        System.out.println("Tipo de cuenta: "); // ahorro
        String tipoCuenta = leer.nextLine();

        System.out.println("Saldo: ");
        double saldo = leer.nextDouble();
        leer.nextLine(); 

        // hacer el número de cuenta aleatorio de 7 dígitos e imprimirlo
        int numeroCuenta = (int)(Math.random() * 9000000) + 1000000;
        System.out.println("Número de cuenta: " + numeroCuenta);
        
        // hacer la CLABE interbancaria aleatoria de 10 dígitos e imprimirlo
        long clabe = (long)(Math.random() * 9000000000L) + 1000000000L;
        System.out.println("CLABE interbancaria: " + clabe);
        
        // validar que sea solo de 4 dígitos
        System.out.println("PIN (4 dígitos): ");
        String pin = leer.nextLine(); // no me deja ingresar el pin, se lo salta
        while (!pin.matches("\\d{4}")) { 
            System.out.println("PIN inválido. Ingrese un PIN de 4 dígitos:");
            pin = leer.nextLine();
        }

        Cuenta usuario = new Cuenta(titular, tipoCuenta, saldo, numeroCuenta, clabe, pin);
        cuenta.add(usuario);
    }

    // método para acceder a una cuenta y validar el pin
    // usar el método consultarSaldo
    public void accederCuenta(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su PIN: ");
        String pin = leer.nextLine(); 
        // hacer la validación del pin, que coincida con el pin de la cuenta
        while (!pin.equals(cuenta.get(0).getPin())) {
            System.out.println("PIN incorrecto. Intente de nuevo:");
            pin = leer.nextLine();
        }


        for (Cuenta usuario : cuenta){
            if (usuario.getPin().equals(pin)){
                System.out.println("1. Retirar");
                System.out.println("2. Depositar");
                System.out.println("3. Salir");
                int opcion = leer.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Retirar: ");
                        double retiro = leer.nextDouble();
                        usuario.retirar(retiro);
                        // mostrar el saldo después de retirar
                        System.out.println("Saldo: " + usuario.getSaldo());
                        break;
                    case 2:
                        System.out.println("Depositar: ");
                        double deposito = leer.nextDouble();
                        usuario.depositar(deposito);
                        // mostrar el saldo después de depositar
                        System.out.println("Saldo: " + usuario.getSaldo());
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }
    }
}