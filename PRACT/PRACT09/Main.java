package PRACT09;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // crear una lista de empleados y y añadir instancias de EmpleadoTiempoCompleto, EmpleadoMedioTiempo y Empleado
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(20000));
        empleados.add(new EmpleadoTiempoCompleto(28000));
        empleados.add(new EmpleadoMedioTiempo(15000));

        for (Empleado emp : empleados) {
            System.out.println("\n-----------------------------------------");
            emp.mostrarDetalles();

            // calcular el bono de cada empleado
            double estandar = emp.calcularBono();
            System.out.println("Bono estándar: $" + estandar);

            // calcular bono ajustado por rendimiento
            double rendimiento = emp.calcularBono(1.3);
            System.out.println("Bono ajustado por rendimiento: $" + rendimiento);
        }
    }
}
