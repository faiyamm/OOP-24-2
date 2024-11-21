public class chefRobot extends Base {
    private String tipoPlatillo;

    public chefRobot(String name, String tipoPlatillo) {
        super(name);
        this.tipoPlatillo = tipoPlatillo;
    }

    @Override
    public void cook() {
        if (!Base.areIngredientsReady()) {
            System.out.println("ERROR: El robot " + getName() + " no puede cocinar sin los ingredientes.");
            return;
        }
        System.out.println("El robot " + getName() + " está cocinando un " + tipoPlatillo + ".");
        Base.setCooked(true);
    }


    public String getTipoPlatillo() {
        return tipoPlatillo;
    }

    public void setTipoPlatillo(String tipoPlatillo) {
        this.tipoPlatillo = tipoPlatillo;
    }
}