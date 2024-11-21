import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // instanciar objetos de los robots
        ingredientesRobot prepcook = new ingredientesRobot("Ayudante");
        chefRobot chefDesayuno = new chefRobot("Chef de desayunos", "Hot Cakes");
        chefRobot chefLunch = new chefRobot("Chef de comidas", "Spaghetti");
        chefRobot chefCena = new chefRobot("Chef de cenas", "Pozole");
        meseroRobot mesero = new meseroRobot("Mesero", "Plato");

        int opc = 0;

        do {
            menu();
            System.out.print("Opción: ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    prepcook.chopIngredients();
                    Base.setIngredientsReady(true);
                    System.out.println("Ingredientes listos.");
                    break;
                case 2:
                    if (!Base.areIngredientsReady()) {
                        System.out.println("Error: primero debes preparar los ingredientes.");
                        break;
                    }
                    menuChef();
                    System.out.print("Opción: ");
                    int opcChef = leer.nextInt();
                    switch (opcChef) {
                        case 1:
                            chefDesayuno.cook();
                            break;
                        case 2:
                            chefLunch.cook();
                            break;
                        case 3:
                            chefCena.cook();
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    System.out.println("El plato está cocinado.");
                    break;
                case 3:
                    if (!Base.isCooked()) {
                        System.out.println("Error: no puedes servir un plato sin cocinar.");
                        break;
                    }
                    mesero.serve();
                    if (Base.isServed()) {
                        System.out.println("¡Hurra! Plato servido.");
                    }

                    // reiniciar estados para otro ciclo de preparación
                    Base.setIngredientsReady(false);
                    Base.setCooked(false);
                    System.out.println("Ciclo completado. Puedes ordenar otro platillo.");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 4);
        leer.close();
    }

    public static void menu() {
        System.out.println("\nMenú principal:");
        System.out.println("1. Preparar ingredientes");
        System.out.println("2. Cocinar");
        System.out.println("3. Servir");
        System.out.println("4. Salir");
    }

    public static void menuChef() {
        System.out.println("\nSelecciona el tipo de comida:");
        System.out.println("1. Desayuno");
        System.out.println("2. Comida");
        System.out.println("3. Cena");
    }
}
