public class ConfiguracionSistema {
    private static ConfiguracionSistema instancia;
    private String conexionBaseDatos;
    private String temaUI;

    private ConfiguracionSistema() {
        // valores por defecto
        this.conexionBaseDatos = "Base de datos simulada";
        this.temaUI = "modo_claro";
    }

    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public String getConexionBaseDatos() {
        return conexionBaseDatos;
    }

    public void setConexionBaseDatos(String conexionBaseDatos) {
        this.conexionBaseDatos = conexionBaseDatos;
    }

    public String getTemaUI() {
        return temaUI;
    }

    public void setTemaUI(String temaUI) {
        this.temaUI = temaUI;
    }
}
