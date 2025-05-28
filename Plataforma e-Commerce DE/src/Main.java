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
	}
	
	
	

}
