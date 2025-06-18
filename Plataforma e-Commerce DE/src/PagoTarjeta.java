public class PagoTarjeta implements ProcesoPago {
	
    @Override
    public void iniciarPago(double monto) {
        System.out.println("Pago con tarjeta iniciado por $" + monto);
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
