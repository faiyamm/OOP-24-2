package polimorfismo;

/*
Clase Base Empleado: Crea una clase Empleado que tenga:
Un atributo salarioAnual de tipo double para almacenar el salario anual del empleado.
Un constructor que reciba el salario anual como parámetro y lo asigne al atributo.
En la clase Empleado, define varios métodos calcularBono():
Sobrescritura básica: Crea un método calcularBono() sin parámetros que devuelva el 5% del salario anual como bono.
Sobrecarga con porcentaje: Crea otra versión de calcularBono(double porcentaje), que reciba un porcentaje y devuelva el bono calculado en función de ese porcentaje.
Sobrecarga con porcentaje y rendimiento: Crea una versión adicional calcularBono(double porcentaje, double rendimiento), que reciba tanto un porcentaje como un factor de rendimiento, y devuelva el bono calculado como salarioAnual (porcentaje) rendimiento.
Define un método mostrarDetalles() en la clase Empleado que imprima el salario anual. Este método será sobrescrito en las clases hijas.

 */

public class Empleado {
    private double salarioAnual;

    public Empleado(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public double calcularBono() {
        return salarioAnual * 0.05; // 5% del salario anual
    }

    public double calcularBono(double porcentaje) {
        return salarioAnual * porcentaje;
    }

    public double calcularBono(double porcentaje, double rendimiento) {
        return salarioAnual * porcentaje * rendimiento;
    }

    public void mostrarDetalles() {
        System.out.println("Salario anual: $" + salarioAnual);
    }
}
