import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PagoTest {

    @Test
    public void testPagoPaypalValido() {
        ProcesoPago pago = new PagoPaypal();
        assertDoesNotThrow(() -> {
            pago.iniciarPago(50.0);
            assertTrue(pago.verificarPago());
            pago.confirmarPago();
        });
    }

    @Test
    public void testPagoPaypalInvalido() {
        ProcesoPago pago = new PagoPaypal();
        Exception exception = assertThrows(PagoFallidoExcepcion.class, () -> {
            pago.iniciarPago(0);
        });
        assertEquals("El monto del pago no es válido.", exception.getMessage());
    }

    @Test
    public void testPagoTarjetaValido() {
        ProcesoPago pago = new PagoTarjeta();
        assertDoesNotThrow(() -> {
            pago.iniciarPago(75.0);
            assertTrue(pago.verificarPago());
            pago.confirmarPago();
        });
    }

    @Test
    public void testPagoTarjetaInvalido() {
        ProcesoPago pago = new PagoTarjeta();
        Exception exception = assertThrows(PagoFallidoExcepcion.class, () -> {
            pago.iniciarPago(-10);
        });
        assertEquals("El monto del pago no es válido.", exception.getMessage());
    }
}
