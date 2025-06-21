public class GestorNotificacionesInventario implements Observador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Inventario -> Actualización recibida: " + mensaje);
    }
}