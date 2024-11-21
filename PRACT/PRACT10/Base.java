public abstract class Base implements Acciones { // clase base para los robots
    private static boolean cooked = false;
    private static boolean served = false;
    private String name;
    private static boolean ingredientsReady = false; // global para que todos los robots puedan acceder

    public static boolean isCooked() {
        return cooked;
    }
    
    public static void setCooked(boolean cooked) {
        Base.cooked = cooked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean areIngredientsReady() {
        return ingredientsReady;
    }

    public static void setIngredientsReady(boolean ready) {
        ingredientsReady = ready;
    }

    public static boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        Base.served = served;
    }

    public Base(String name) { // método constructor
        this.name = name;
    }

    @Override
    public void chopIngredients() {
        System.out.println("ERROR: El robot " + name + " no puede preparar los ingredientes.");
    }

    @Override
    public void cook() {
        System.out.println("ERROR: El robot " + name + " no puede cocinar.");
    }

    @Override
    public void serve() {
        System.out.println("ERROR: El robot " + name + " no puede servir.");
    }

}