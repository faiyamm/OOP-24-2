package polimorfismo;

public class EmpleadoMedioTiempo extends Empleado {

    public EmpleadoMedioTiempo(double salarioAnual) {
        super(salarioAnual);
    }

    @Override
    public double calcularBono() {
        return getSalarioAnual() * 0.1; // 10% del salario anual
    }

    // sobrecarga del método calcularBono que ajusta el bono según el rendimiento
    public double calcularBono(double rendimiento) {
        return getSalarioAnual() * 0.1 * rendimiento;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado de medio tiempo con salario anual de $" + getSalarioAnual());
    }
}
