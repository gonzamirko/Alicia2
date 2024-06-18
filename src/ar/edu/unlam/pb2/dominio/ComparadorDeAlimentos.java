package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;

public class ComparadorDeAlimentos implements Comparator<Alimento> {

	@Override
	public int compare(Alimento o1, Alimento o2) {
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
