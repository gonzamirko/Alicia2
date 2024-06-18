package ar.edu.unlam.pb2.dominio;

public class Achicador extends Alimento {
	private TipoAchicador tipoDeAchicador;

	public Achicador(Double precio, TipoAchicador tipoDeAchicador,String nombre) {
		super(50.0, precio, nombre);
		this.tipoDeAchicador = tipoDeAchicador;
	}

}
