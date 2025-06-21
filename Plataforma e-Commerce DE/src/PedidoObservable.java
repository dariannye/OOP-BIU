
import java.util.ArrayList;
import java.util.List;

public class PedidoObservable {
    private List<Observador> observadores = new ArrayList<>();
    private String estado;

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores("El estado del pedido cambió a: " + nuevoEstado);
    }

    private void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }

    public String getEstado() {
        return estado;
    }
}
