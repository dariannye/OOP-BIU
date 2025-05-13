
public class ProductoDigital extends Producto {
	private String formatoArchivo;
	private double tamano;

	public ProductoDigital(String id, String nombre, double precio, int idInventario, String formatoArchivo, double tamano) {
		super(id, nombre, precio, idInventario);
		this.formatoArchivo = formatoArchivo;
		this.tamano = tamano;
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
    	this.tamano = tamano; 
    }

}
