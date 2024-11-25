package PRACT11;

import java.util.List;

public class Alumno {
    private String nombre;
    private int id; // matricula
    private List<Double> calificaciones; // calificaciones de materias

    // Constructor con todos los atributos
    public Alumno(String nombre, int id, List<Double> calificaciones) {
        this.nombre = nombre;
        this.id = id;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public double calcularProm() {
        double sum = 0;
        for (Double calificacion : calificaciones) {
            sum += calificacion;
        }
        return sum / calificaciones.size();
    }
}
