public class ingredientesRobot extends Base {
    public ingredientesRobot(String name) {
        super(name);
    }

    @Override
    public void chopIngredients() {
        System.out.println("El robot " + getName() + " está preparando los ingredientes.");
        Base.setIngredientsReady(true);
    }
}