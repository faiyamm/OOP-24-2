package PRACT01_04;
/* Gestión de Tareas Pendientes 
Crea un programa que gestione una lista de tareas pendientes. El programa debe permitir al usuario:
Agregar una nueva tarea.
Marcar una tarea como completada.
Eliminar una tarea.
Mostrar todas las tareas pendientes.
Cada tarea debe tener un nombre y un estado que puede ser "pendiente" o "completada".

Requisitos:
Usa un ArrayList para almacenar las tareas.
Cada tarea puede representarse como un objeto de una clase Tarea que tenga dos atributos: el nombre de la tarea y su estado.
Usa un menú para que el usuario pueda elegir las diferentes opciones (agregar, completar, eliminar, mostrar).
Usa ciclos y condiciones para controlar el flujo del programa. */

import java.util.Scanner;
import java.util.ArrayList;

public class Tarea {
    String tarea;
    String status;

    public Tarea(String tarea, String status){
        this.tarea = tarea;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarea [tarea=" + tarea + ", status=" + status + "]";
    }


    public static void menu() {
        System.out.println("=============================");
        System.out.println("1. Agregar");
        System.out.println("2. Completar");
        System.out.println("3. Eliminar");
        System.out.println("4. Mostrar"); // solo mostrar las tareas pendientes
        System.out.println("5. Salir");
        System.out.println("=============================");

    }

    public static void main(String[] args) {
        ArrayList<Tarea> tareaList = new ArrayList<>();

        Scanner leer = new Scanner(System.in);
        int opc = 0;
        int num = 0;

        do{
            menu();
            System.out.print("Ingrese una opcion: ");
            opc = leer.nextInt();
            leer.nextLine();

            switch(opc){
                case 1:
                    // agregar tarea
                    if (num < 2){
                        System.out.println("Ingresar nombre de la tarea: ");
                        String nuevo = leer.nextLine();
                        tareaList.add(new Tarea(nuevo, "Pendiente"));
                        num++;
                    } else System.out.println("solo 2 tareas");
        
                    break;
                case 2:
                    // marcar tarea como completada
                    System.out.println("¿Qué tarea desea marcar como completada?: ");
                    for (int i = 0; i < tareaList.size(); i++) {
                        System.out.println(i + 1 + ". " + tareaList.get(i));
                    }
                    int completar = leer.nextInt();
                    try {
                        tareaList.get(completar - 1).status = "Completada";
                        System.out.println("Tarea completada :)");
                    } 
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Esa tarea ni existe >:(");
                    }
                    break;
                case 3:
                    // eliminar tarea
                    System.out.println("¿Qué tarea desea eliminar?: ");
                    for (int i = 0; i < tareaList.size(); i++) {
                        System.out.println(i + 1 + ". " + tareaList.get(i));
                    }
                    int eliminar = leer.nextInt();

                    try {
                        tareaList.remove(eliminar - 1);
                        System.out.println("Tarea eliminada :(");
                    } 
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Esa tarea ni existe >:(");
                    }

                    break;
                case 4:
                    // mostrar todas las tareas PENDIENTES
                    System.out.println("Tareas pendientes:");
                    for (Tarea t : tareaList) {
                        if (t.status.equals("Pendiente")) {
                            System.out.println(t);
                        }
                    }

                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while(opc != 5);
        leer.close();
    }
}
