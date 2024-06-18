package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Alicia implements Comprador {
	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dinero;
	private List<Alimento> alimentos;
    private Map<String, List<Alimento>> alimentosMap;
	public Alicia(Double dinero) {

		this.altura = 180.0;
		this.peso = 50.0;
		this.nombre = "Alicia";
		this.edad = 15;
		this.dinero = dinero;
		alimentos = new ArrayList<>();
		alimentosMap = new TreeMap<>();

	}

	@Override
	public Boolean comprarAlimento(Alimento alimentoAgrandador) throws DineroInsuficienteExeption {
		if(this.dinero < alimentoAgrandador.getPrecio()) {
			 throw new DineroInsuficienteExeption("dinero insuficiente");
		}
		if (this.dinero >= alimentoAgrandador.getPrecio()) {
			alimentos.add(alimentoAgrandador);
			setDinero(getDinero() - alimentoAgrandador.getPrecio());
			return true;
		}
		return false;
	}
	
	public void consumirAlimento(Alimento alimentoAgrandador) throws TamanioLimiteException {
		//for (Alimento alimento : alimentos) {
		
			if(alimentos.contains(alimentoAgrandador)) {
				
				if(alimentoAgrandador instanceof Agrandador) {
					if(this.altura + alimentoAgrandador.getTamanioModificar() > 280) {
						throw new TamanioLimiteException("tamanio limite");
					}
					setAltura(this.altura + alimentoAgrandador.getTamanioModificar());
					alimentos.remove(alimentoAgrandador);
				}
				if(alimentoAgrandador instanceof Achicador) {
					if(this.altura - alimentoAgrandador.getTamanioModificar() < 50) {
						throw new TamanioLimiteException("tamanio limite");
					}
					setAltura(this.altura - alimentoAgrandador.getTamanioModificar());
					alimentos.remove(alimentoAgrandador);
				}
				
		//	}
		}
		
	}
	
	public List<Alimento> ordenarAlimentoDescendente(){
		Collections.sort(alimentos,new ComparadorDeAlimentos());
		return alimentos;
	}
	public Map<String, List<Alimento>> ordenarAlimentosMap(){
		
		return alimentosMap;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
	

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public void agregarAMap(String key, List<Alimento> alimentos2) {
		alimentosMap.put(key, alimentos2);
		
	}

	

}
