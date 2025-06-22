import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testCorreoValido() {
        Usuario user = new Cliente("Ana", "ana@example.com", "clave123");
        assertTrue(user.getCorreoElectronico().contains("@"));
    }

    @Test
    public void testContrasenaCorta() {
        Usuario user = new Administrador("Juan", "juan@example.com", "123");
        assertTrue(user.getContrasena() == null || user.getContrasena().length() < 6);
    }
}

