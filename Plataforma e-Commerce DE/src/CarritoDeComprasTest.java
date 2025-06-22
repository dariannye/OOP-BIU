import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarritoDeComprasTest {

    private CarritoDeCompras carrito;
    private Producto producto1;
    private Producto producto2;
    private List<Producto> catalogo;

    @BeforeEach
    public void setUp() {
        producto1 = new ProductoFisico("PF1", "Laptop", 1200.0, 8, 10, "15x15");
        producto2 = new ProductoFisico("PF2", "Mouse", 25.0, 9, 2, "5X8");
        catalogo = new ArrayList<>();
        catalogo.add(producto1);
        catalogo.add(producto2);
        carrito = new CarritoDeCompras(catalogo);
    }

    @Test
    public void testAgregarProductoPorObjeto() {
        carrito.agregarProducto(producto1, 2);
        assertEquals(1, carrito.getProductos().size());
    }

    @Test
    public void testAgregarProductoPorIdValido() {
        carrito.agregarProducto("PF2", 3);
        assertEquals(1, carrito.getProductos().size());
        assertEquals("Mouse", carrito.getProductos().get(0).getProducto().getNombre());
    }

    @Test
    public void testAgregarProductoPorIdInvalido() {
        carrito.agregarProducto("P999", 1);
        assertEquals(0, carrito.getProductos().size());
    }

    @Test
    public void testAgregarProductoPorNombreYPrecio() {
        carrito.agregarProducto("Laptop", 1200.0, 1);
        assertEquals(1, carrito.getProductos().size());
    }

    @Test
    public void testAgregarProductoPorNombreYPrecioInvalido() {
        carrito.agregarProducto("Laptop", 100.0, 1);
        assertEquals(0, carrito.getProductos().size());
    }
}
