import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Producto p1 = new ProductoDigital("PD1", "E-book", 12.99, 1, "PDF", 12 );
		Producto p2 = new ProductoFisico("PF1", "Libro", 29.99, 2, 1.5, "12x5" );
		Producto p3 = new ProductoFisico("PF2", "Libro de colorear", 15.65, 3, 1.0, "12x5" );
		
		p1.mostrarDetalle();
		p2.mostrarDetalle();
		
		List<Producto> catalogo = new ArrayList<>();
		catalogo.add(p1);
		catalogo.add(p2);
		catalogo.add(p3);
		
		CarritoDeCompras carrito = new CarritoDeCompras(catalogo);
	        
        carrito.agregarProducto("PD1", 2); //por Id
        carrito.agregarProducto("PF3", 1); //Prueba de que no se encuentra
        carrito.agregarProducto("Libro", 29.99, 5); //Por nombre y precio
        carrito.agregarProducto(p3, 8); //Por objeto producto
        for (ItemCarrito item : carrito.getProductos()) {
            item.getProducto().mostrarDetalle();
            System.out.println("Cantidad: " + item.getCantidad());
        }
        
        GestorInventario inventarioDigital = new GestorInventarioDigital();
        inventarioDigital.añadirProducto(p1, 15);
        inventarioDigital.actualizarStock(p1.getId(), 80);
        
        //Singleton
        ConfiguracionSistema config = ConfiguracionSistema.getInstancia();
        System.out.println("Conexión: " + config.getConexionBaseDatos());
        System.out.println("Tema actual: " + config.getTemaUI());

        config.setTemaUI("modo_oscuro"); // cambiar el tema
        System.out.println("Nuevo tema: " + config.getTemaUI());
        
        //Factory
        Producto p4 = FabricaEntidades.crearProducto("digital", "PD4", "Curso Java", 15.99, 1);
        Usuario admin = FabricaEntidades.crearUsuario("administrador", "Ana", "ana@admin.com", "123456");

        p4.mostrarDetalle();
        System.out.println("Usuario creado: " + admin.getNombre());
        
        //Observer
        PedidoObservable pedido = new PedidoObservable();
        pedido.agregarObservador(new NotificadorUI());
        pedido.agregarObservador(new GestorNotificacionesInventario());

        pedido.setEstado("Procesando");
        pedido.setEstado("Enviado");
        
        //Manejo de excepciones
        GestorInventarioFisico gestor = new GestorInventarioFisico();
        Producto p = new ProductoFisico("PF4", "Laptop", 1200.0, 101, 2.5, "30x20x5");
        gestor.añadirProducto(p, 12);

        try {
            gestor.consumirStock("001", 15);  // Esto lanza la excepcion
        } catch (InventarioInsuficienteExcepcion e) {
            System.out.println("Error de inventario: " + e.getMessage());
        }
        
        ProcesoPago pago = new PagoTarjeta();
        try {
            pago.iniciarPago(-50);  // Esto lanza PagoFallidoException
        } catch (PagoFallidoExcepcion e) {
            System.out.println("Error en el pago: " + e.getMessage());
        }
        
        
        
        
        
        
	}
	
	
	

}
