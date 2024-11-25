# Manejo de Calificaciones

Este proyecto en Java lee un archivo CSV con calificaciones de estudiantes, las procesa y calcula el promedio de cada estudiante, luego guarda la información en un archivo de texto.

## Archivos

1. **Main.java**: Contiene el flujo principal del programa que maneja la lectura de los datos del archivo CSV, la creación de objetos `Alumno`, y la escritura de los resultados en un archivo de texto.
   
2. **Alumno.java**: Contiene la clase `Alumno`, que representa a cada estudiante con su nombre, matrícula e información de calificaciones. Además, tiene un método para calcular el promedio de las calificaciones.

3. **proyecto.csv**: Archivo de entrada con las calificaciones de los estudiantes.

4. **alumnos.txt**: Archivo de salida que contiene la información de los alumnos junto con sus promedios.

## Explicación

El código está diseñado para realizar las siguientes tareas:

- **Leer el archivo CSV**: La función `readCSV` lee las calificaciones desde un archivo CSV, limpiando y transformando los datos para almacenarlos en una lista de `Double`.
  
- **Crear objetos `Alumno`**: A partir de las calificaciones leídas, se crean objetos `Alumno`, donde se asignan las calificaciones correspondientes a cada estudiante.
  
- **Calcular el promedio**: Para cada alumno, se calcula el promedio de las calificaciones usando el método `calcularProm`.

- **Guardar el archivo de salida**: Los detalles de cada alumno, incluyendo su nombre, matrícula, calificaciones y promedio, se escriben en el archivo `alumnos.txt`.

## Excepciones en el Código

Se utilizan excepciones en varias partes del código para manejar posibles errores durante la ejecución:

1. **Excepción de lectura/escritura de archivos**:
   - Se utilizan bloques `try-catch` para capturar y manejar excepciones relacionadas con la lectura o escritura de archivos.
   - En el bloque principal (`main`), se captura la excepción `IOException` si ocurre algún error al leer el archivo CSV o escribir el archivo de salida.
   ```java
   catch (IOException e) {
       System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
   }

2. **Excepción genérica:**
    - Se utiliza una excepción genérica en el bloque principal para capturar cualquier otro error inesperado que no haya sido manejado previamente.
    ```java
        catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
        }

3. **NumberFormatException:**
    - Se maneja en el método readCSV para capturar cualquier error al intentar convertir un valor del CVS file en un número Double.
    ```java
    try {
        calf.add(Double.parseDouble(cleanedPart));
    } catch (NumberFormatException e) {
        System.out.println("Dato inválido encontrado y omitido: " + part);
    }