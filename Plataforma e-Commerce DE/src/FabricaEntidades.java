public class FabricaEntidades {
    
    // Crear productos según tipo
    public static Producto crearProducto(String tipo, String id, String nombre, double precio, int idInventario) {
        if (tipo.equalsIgnoreCase("digital")) {
            return new ProductoDigital(id, nombre, precio, idInventario, "PDF", 10);
        } else if (tipo.equalsIgnoreCase("fisico")) {
            return new ProductoFisico(id, nombre, precio, idInventario, 1.2, "10x10");
        } else {
            throw new IllegalArgumentException("Tipo de producto desconocido: " + tipo);
        }
    }

    // Crear usuarios según tipo
    public static Usuario crearUsuario(String tipo, String nombre, String correo, String contrasena) {
        if (tipo.equalsIgnoreCase("cliente")) {
            return new Cliente(nombre, correo, contrasena);
        } else if (tipo.equalsIgnoreCase("administrador")) {
            return new Administrador(nombre, correo, contrasena);
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + tipo);
        }
    }
}
