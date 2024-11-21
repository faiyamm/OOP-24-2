public class meseroRobot extends chefRobot {

    public meseroRobot(String name, String tipoPlatillo) {
        super(name, tipoPlatillo);
    }

    @Override
    public void serve() {
        if (!Base.isCooked()) {
            System.out.println("ERROR: El robot " + getName() + " no puede servir sin cocinar.");
            return;
        } else {
            System.out.println("El robot " + getName() + " está sirviendo un " + getTipoPlatillo() + ".");
        }
    }
}