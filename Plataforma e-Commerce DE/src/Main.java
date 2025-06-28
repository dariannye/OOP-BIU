import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1. CREACIÓN DE USUARIO ADMINISTRADOR Y BIENVENIDA
        Usuario admin = FabricaEntidades.crearUsuario("administrador", "Ana", "ana@admin.com", "123456");
        System.out.println("Bienvenida administradora: " + admin.getNombre());

        // 2. CREACIÓN DE PRODUCTOS MANUALMENTE
        Producto p1 = new ProductoDigital("PD1", "E-book", 12.99, 1, "PDF", 12);
        Producto p2 = new ProductoFisico("PF1", "Libro", 29.99, 2, 1.5, "12x5");
        Producto p3 = new ProductoFisico("PF2", "Libro de colorear", 15.65, 3, 1.0, "12x5");

        // 3. CREACIÓN DE PRODUCTO CON FÁBRICA
        Producto p4 = FabricaEntidades.crearProducto("digital", "PD4", "Curso Java", 15.99, 4);

        // 4. CATÁLOGO
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(p1);
        catalogo.add(p2);
        catalogo.add(p3);
        catalogo.add(p4);

        // 5. CREACIÓN DE CLIENTE Y MOSTRAR PRODUCTOS DISPONIBLES
        Cliente cliente = (Cliente) FabricaEntidades.crearUsuario("cliente", "Carlos", "carlos@mail.com", "1234");
        System.out.println("\nBienvenido " + cliente.getNombre() + ", estos son los productos disponibles:");
        for (Producto prod : catalogo) {
            prod.mostrarDetalle();
        }

        // 6. CARRITO Y AGREGADO DE PRODUCTOS
        CarritoDeCompras carrito = new CarritoDeCompras(catalogo);
        carrito.agregarProducto("PD1", 2); // por ID
        carrito.agregarProducto("Libro", 29.99, 1); // por nombre y precio
        carrito.agregarProducto(p3, 3); // por objeto producto

        // 7. MOSTRAR TOTAL Y DETALLE DEL CARRITO
        System.out.println("\nContenido del carrito:");
        for (ItemCarrito item : carrito.getProductos()) {
            item.getProducto().mostrarDetalle();
            System.out.println("Cantidad: " + item.getCantidad());
        }
        carrito.calcularTotal();
        System.out.println("\nTotal del carrito: $" + carrito.getTotal());

        // 8. ELIMINAR PRODUCTO DEL CARRITO Y MOSTRAR NUEVO TOTAL
        carrito.removerProducto("PF1"); // Eliminar por ID
        System.out.println("\nContenido actualizado del carrito:");
        for (ItemCarrito item : carrito.getProductos()) {
            System.out.println(item.getProducto().getNombre() + " - Cantidad: " + item.getCantidad());
        }
        System.out.println("Total actualizado: $" + carrito.getTotal());

     // 9. CREACIÓN DE PEDIDO + OBSERVADORES (NOTIFICACIONES)
        String idPedido = "PED-" + UUID.randomUUID(); // Generar ID único
        double totalPedido = carrito.getTotal();
        Pedido pedido = new Pedido(idPedido, cliente, carrito.getProductos(), totalPedido);

        PedidoObservable pedidoObservable = new PedidoObservable();
        pedidoObservable.agregarObservador(new NotificadorUI());
        pedidoObservable.agregarObservador(new GestorNotificacionesInventario());

        pedidoObservable.setEstado("Pedido creado");
        pedidoObservable.setEstado("Procesando pedido...");


        // 10. PAGO CON TARJETA
        ProcesoPago pago = new PagoTarjeta();
        try {
            double total = carrito.getTotal();
            pago.iniciarPago(total);

            if (pago.verificarPago()) {
                pago.confirmarPago();
                pedidoObservable.setEstado("Pago confirmado");
                System.out.println("Pedido realizado exitosamente por " + cliente.getNombre());
            }
        } catch (PagoFallidoExcepcion e) {
            System.out.println("Error durante el pago: " + e.getMessage());
        }

        // 11. ADMIN ACTUALIZA INVENTARIO (FÍSICO)
        System.out.println("Bienvenida de vuelta administradora: " + admin.getNombre());
        GestorInventarioFisico gestor = new GestorInventarioFisico();
        gestor.añadirProducto(p2, 5); // Agrega 5 unidades más del libro
        gestor.actualizarStock(p2.getId(), 20); // Reemplaza el stock

        // 12. SINGLETON: CONFIGURACIÓN DEL SISTEMA
        ConfiguracionSistema config = ConfiguracionSistema.getInstancia();
        System.out.println("\nConfiguración inicial del sistema:");
        System.out.println("Conexión: " + config.getConexionBaseDatos());
        System.out.println("Tema: " + config.getTemaUI());
        config.setTemaUI("modo_oscuro");
        System.out.println("Nuevo tema aplicado: " + config.getTemaUI());

        // 13. MANEJO DE EXCEPCIÓN DE INVENTARIO
        try {
            gestor.consumirStock("PF1", 100); // Mucho más del stock actual lanza excepción
        } catch (InventarioInsuficienteExcepcion e) {
            System.out.println("Error de inventario: " + e.getMessage());
        }

        // 14. MANEJO DE EXCEPCIÓN DE PAGO
        try {
            ProcesoPago pagoErroneo = new PagoTarjeta();
            pagoErroneo.iniciarPago(-25); // Pago inválido lanza excepción
        } catch (PagoFallidoExcepcion e) {
            System.out.println("Error en el pago: " + e.getMessage());
        }
    }
}
