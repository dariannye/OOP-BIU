public interface ProcesoPago {
	
    void iniciarPago(double monto) throws PagoFallidoExcepcion;
    
    boolean verificarPago();
    
    void confirmarPago();
    
}
