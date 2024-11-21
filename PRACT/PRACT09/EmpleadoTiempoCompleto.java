package PRACT09;

public class EmpleadoTiempoCompleto extends Empleado {

    public EmpleadoTiempoCompleto(double salarioAnual) {
        super(salarioAnual);
    }

    @Override
    public double calcularBono() {
        return getSalarioAnual() * 0.2; // 20% del salario anual
    }

    // sobrecarga del método calcularBono que ajusta el bono según el rendimiento
    public double calcularBono(double rendimiento) {
        return getSalarioAnual() * 0.2 * rendimiento;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado de tiempo completo con salario anual de $" + getSalarioAnual());
    }
}
