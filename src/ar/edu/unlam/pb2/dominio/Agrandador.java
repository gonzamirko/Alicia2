package ar.edu.unlam.pb2.dominio;

public class Agrandador extends Alimento {
 private  TipoDeAgrandador tipoDeAgrandador;
	public Agrandador(Double precio, TipoDeAgrandador tipoDeAgrandador,String nombre) {
		super(40.0, precio, nombre);
		this.tipoDeAgrandador = tipoDeAgrandador;
	}

}
