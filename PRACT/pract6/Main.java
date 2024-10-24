// clase pública, es decir, accesible desde cualquier lugar
public class Main {
    public static void main(String[] args) {
        // instancia de la clase Producto
        Producto producto = new Producto();
        
        // quiero usar solo los métodos para imprimir
        producto.mostrarNombrePublico();
        producto.mostrarPrecioProtegido();
        producto.mostrarCantidadDefault();

        /* 
        // miembros públicos
        System.out.println("Nombre del producto: " + producto.nombrePublico);
        producto.mostrarNombrePublico();
        
        // miembros protegidos
        System.out.println("Precio del producto: " + producto.precioProtegido);
        producto.mostrarPrecioProtegido();
        
        // miembros con acceso por default (package-private)
        System.out.println("Cantidad en stock: " + producto.cantidadDefault);
        producto.mostrarCantidadDefault();
        
        // no se puede acceder a los miembros privados directamente porque causaría un error
        // System.out.println("Código del producto: " + producto.codigoPrivado);
        // producto.mostrarCodigoPrivado(); */
    }
}

// clase en el mismo paquete
class Producto {
    // variable pública
    public String nombrePublico = "Cheetos";
    
    // variable protegida
    protected double precioProtegido = 17.50;
    
    // variable con acceso por defecto (package-private)
    int cantidadDefault = 37;
    
    // variable privada
    private String codigoPrivado = "CHEETOS123";
    
    // método público
    public void mostrarNombrePublico() {
        System.out.println("Nombre del producto: " + nombrePublico);
    }
    
    // método protegido
    protected void mostrarPrecioProtegido() {
        System.out.println("Precio del producto: $" + precioProtegido);
    }
    
    // método con acceso por default
    void mostrarCantidadDefault() {
        System.out.println("Cantidad en stock: " + cantidadDefault);
    }
    
    // método privado
    private void mostrarCodigoPrivado() {
        System.out.println("Código del producto: " + codigoPrivado);
    }
}
