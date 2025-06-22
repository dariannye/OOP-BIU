import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorInventarioTest {

    private GestorInventarioFisico gestorFisico;
    private GestorInventarioDigital gestorDigital;
    private Producto productoFisico;
    private Producto productoDigital;

    @BeforeEach
    public void setUp() {
        gestorFisico = new GestorInventarioFisico();
        gestorDigital = new GestorInventarioDigital();
        productoFisico = new ProductoFisico("PF1", "Impresora", 150.0, 1, 5.0, "30x30x20");
        productoDigital = new ProductoDigital("PD1", "Licencia Windows", 99.0, 2, "EXE", 512);
    }

    //Pruebas para Inventario Físico 

    @Test
    public void testAñadirProductoFisico() {
        gestorFisico.añadirProducto(productoFisico, 10);
        assertDoesNotThrow(() -> gestorFisico.consumirStock("PF1", 5));
    }

    @Test
    public void testActualizarStockFisico() throws InventarioInsuficienteExcepcion {
        gestorFisico.añadirProducto(productoFisico, 5);
        gestorFisico.actualizarStock("PF1", 20);
        gestorFisico.consumirStock("PF1", 15); // no debería lanzar excepción
        assertThrows(InventarioInsuficienteExcepcion.class, () -> gestorFisico.consumirStock("PF1", 6)); // sí lanza
    }

    @Test
    public void testEliminarProductoFisico() {
        gestorFisico.añadirProducto(productoFisico, 5);
        gestorFisico.eliminarProducto("PF1");
        assertThrows(InventarioInsuficienteExcepcion.class, () -> gestorFisico.consumirStock("PF1", 1));
    }

    //Pruebas para Inventario Digital

    @Test
    public void testAñadirProductoDigital() {
        gestorDigital.añadirProducto(productoDigital, 50);
        assertDoesNotThrow(() -> gestorDigital.consumirStock("PD1", 10));
    }

    @Test
    public void testActualizarStockDigital() throws InventarioInsuficienteExcepcion {
        gestorDigital.añadirProducto(productoDigital, 50);
        gestorDigital.actualizarStock("PD1", 25);
        gestorDigital.consumirStock("PD1", 24); 
        assertThrows(InventarioInsuficienteExcepcion.class, () -> gestorDigital.consumirStock("PD1", 2)); // ya no hay
    }

    @Test
    public void testEliminarProductoDigital() {
        gestorDigital.añadirProducto(productoDigital, 100);
        gestorDigital.eliminarProducto("PD1");
        assertThrows(InventarioInsuficienteExcepcion.class, () -> gestorDigital.consumirStock("PD1", 1));
    }
}

