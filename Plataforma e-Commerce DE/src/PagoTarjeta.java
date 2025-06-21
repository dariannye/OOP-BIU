public class PagoTarjeta implements ProcesoPago {
	

    @Override
    public void iniciarPago(double monto) throws PagoFallidoExcepcion {
        if (monto <= 0) {
            throw new PagoFallidoExcepcion("El monto del pago no es válido.");
        }
        System.out.println("Pago iniciado por $" + monto);
    }


    @Override
    public boolean verificarPago() {
        System.out.println("Verificando fondos de la tarjeta...");
        return true; // Simulación 
    }

    @Override
    public void confirmarPago() {
        System.out.println("Pago con tarjeta confirmado.");
    }
    
}
