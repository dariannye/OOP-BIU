import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> historialPedidos;
    private List<String> preferencias;

    public Cliente(String nombre, String correoElectronico, String contrasena) {
        super(nombre, correoElectronico, contrasena);
        this.historialPedidos = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public List<Pedido> getHistorialPedidos() { 
    	return historialPedidos; 
    }
    
    public List<String> getPreferencias() { 
    	return preferencias; 
    }
    
    public void agregarPedido(Pedido pedido) {
    	historialPedidos.add(pedido);
    }
    
    public void agregarPreferencia(String preferencia) { 
    	preferencias.add(preferencia); 
    }
}
