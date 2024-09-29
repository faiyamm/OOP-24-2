import java.util.Scanner;

public class Libro {
    String titulo;
    String autor;
    String editorial;
    int fechaPublicacion;
    int paginas;

    public Libro(String titulo, String autor, String editorial, int fechaPublicacion, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Título: " + this.titulo + "\n" +
               "Autor: " + this.autor + "\n" +
               "Editorial: " + this.editorial + "\n" +
               "Año de publicación: " + this.fechaPublicacion + "\n" +
               "Número de páginas: " + this.paginas + "\n" +
               "======================================================";
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Libro[] libros = new Libro[3];  // Array to store 3 books
        int i = 0;

        // Using a while loop to collect input
        while (i < 3) {
            System.out.println("Ingrese los datos para el libro " + (i + 1) + ":");
            System.out.print("Ingrese el título del libro: ");
            String titulo = leer.nextLine();
            System.out.print("Ingrese el autor del libro: ");
            String autor = leer.nextLine();
            System.out.print("Ingrese la editorial del libro: ");
            String editorial = leer.nextLine();
            System.out.print("Ingrese el año de publicación del libro (aaaa): ");
            int fechaPublicacion = Integer.parseInt(leer.nextLine());
            System.out.print("Ingrese el número de páginas del libro: ");
            int paginas = Integer.parseInt(leer.nextLine());

            libros[i] = new Libro(titulo, autor, editorial, fechaPublicacion, paginas);  // Save the book object
            i++;  // Increment the counter
        }

        // Using a while loop to display book details
        int j = 0;
        System.out.println("\nDetalles de los libros ingresados:");
        while (j < libros.length) {
            System.out.println(libros[j]);  // Calls the toString method
            j++;
        }
    }
}
