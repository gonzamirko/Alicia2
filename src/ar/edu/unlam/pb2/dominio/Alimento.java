package ar.edu.unlam.pb2.dominio;

public  class Alimento {
	private Double tamanioModificar;
	private Double precio;
    private String nombre;
	public Alimento(Double tamanioModificar, Double precio,String nombre) {
        this.nombre = nombre;
		this.tamanioModificar = tamanioModificar;
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getTamanioModificar() {
		return tamanioModificar;
	}

	public void setTamanioModificar(Double tamanioModificar) {
		this.tamanioModificar = tamanioModificar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

	
	
	

}
