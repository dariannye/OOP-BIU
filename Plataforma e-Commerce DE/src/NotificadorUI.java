public class NotificadorUI implements Observador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Interfaz Usuario -> Notificación recibida: " + mensaje);
    }
}