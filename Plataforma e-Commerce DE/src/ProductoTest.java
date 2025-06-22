import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @Test
    public void testCreacionProducto() {
        Producto p = new ProductoFisico("PF5", "Mouse", 13.95, 5, 1.8, "7x5" );
        assertEquals("PF5", p.getId());
        assertEquals("Mouse", p.getNombre());
        assertEquals(13.95, p.getPrecio());
    }

    @Test
    public void testPrecio() {
        Producto p = new ProductoFisico("PF6", "Teclado", 20.0, 6, 2.5, "12x8");
        assertTrue(p.getPrecio() >= 0); 
    }
}
