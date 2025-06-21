
public class PagoPaypal implements ProcesoPago {
	
	 @Override
    public void iniciarPago(double monto) throws PagoFallidoExcepcion {
        if (monto <= 0) {
            throw new PagoFallidoExcepcion("El monto del pago no es válido.");
        }
        System.out.println("Redirigiendo a PayPal para el pago de  $" + monto);
    }

    @Override
    public boolean verificarPago() {
        System.out.println("Verificando cuenta PayPal...");
        return true;
    }

    @Override
    public void confirmarPago() {
        System.out.println("Pago con PayPal confirmado.");
    }
    
}
