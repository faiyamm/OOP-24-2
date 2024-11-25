package PRACT11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String myFile = "C:/Users/kokow/OneDrive/Documentos/oop_java_py/PRACT11/proyecto.csv";
        String outFile = "C:/Users/kokow/OneDrive/Documentos/oop_java_py/PRACT11/alumnos.txt";

        try {
            List<Double> calificaciones = readCSV(myFile); // read csv file
            List<Alumno> alumnos = new ArrayList<>();

            int cargaMaterias = 6;
            int numAlum = calificaciones.size() / cargaMaterias;

            for (int i = 0; i < numAlum; i++) { // crear 4 alumnos con 6 calificaciones c/u
                int indx = i * cargaMaterias;
                int endinx = indx + cargaMaterias;
                List<Double> califAlumno = calificaciones.subList(indx, endinx);
                Alumno alumno = new Alumno("Alumno " + (i + 1), i + 1, califAlumno);
                alumnos.add(alumno);
            }

            // for each alumnos, imprimir datos
            for (Alumno alumno : alumnos) {
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Matrícula: " + alumno.getId());
                System.out.println("Calificaciones: " + alumno.getCalificaciones());
                System.out.println("Promedio: " + alumno.calcularProm());
                System.out.println("\n");
            }

            saveFile(outFile, alumnos);
            System.out.println("---Archivo guardado---");

        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static List<Double> readCSV(String myFile) throws IOException {
        List<Double> calf = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    try {
                        // limpiar espacios y caracteres no deseados
                        String cleanedPart = part.trim().replaceAll("[^0-9.]", "");
                        calf.add(Double.parseDouble(cleanedPart));
                    } catch (NumberFormatException e) {
                        System.out.println("Dato inválido encontrado y omitido: " + part);
                    }
                }
            }
        }
        return calf;
    }
    

    private static void saveFile(String outFile, List<Alumno> alumnos) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            for (Alumno alumno : alumnos) {
                writer.write("Nombre: " + alumno.getNombre());
                writer.newLine();
                writer.write("Matrícula: " + alumno.getId());
                writer.newLine();
                writer.write("Calificaciones: " + alumno.getCalificaciones());
                writer.newLine();
                writer.write("Promedio: " + alumno.calcularProm());
                writer.newLine();
            }
        }
    }
}
