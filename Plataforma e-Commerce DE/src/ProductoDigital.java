
public class ProductoDigital extends Producto {
	private String formatoArchivo;
	private double tamano;

	public ProductoDigital(String id, String nombre, double precio, int idInventario, String formatoArchivo, double tamano) {
		super(id, nombre, precio, idInventario);
		this.setFormatoArchivo(formatoArchivo);
		this.setTamanoMB(tamano);
	}
	
	//Getters
	public String getFormatoArchivo() { 
		return formatoArchivo; 
	}
	
	public double getTamanoMB() { 
		  return tamano; 
	}
	
	//Setters
	
    public void setFormatoArchivo(String formatoArchivo) { 
    	this.formatoArchivo = formatoArchivo; 
    }

    public void setTamanoMB(double tamano) { 
    	if (tamano > 0) {
    		this.tamano = tamano;}
    }
    
    
    @Override
    public void mostrarDetalle() {
        System.out.println("Digital [id=" + getId() 
            + ", nombre=" + getNombre() 
            + ", precio=" + getPrecio() 
            + ", formato=" + formatoArchivo 
            + ", tamaño=" + tamano + "MB]");
    }

}
