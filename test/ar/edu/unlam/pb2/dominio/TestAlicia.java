package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestAlicia {
	private Alicia alicia;
    private Alimento alimentoAgrandador;
    private Alimento alimentoAchicador;
	@Before
	public void setUp() {
		alicia = new Alicia(1000.0);
		alimentoAchicador = new Achicador(500.0, TipoAchicador.ALFAJORES,"nombre1");
		alimentoAgrandador = new Agrandador(400.0, TipoDeAgrandador.BOCADITOS_DE_CHOCOLATE,"nombre2");
	}

	@Test
	public void queAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws DineroInsuficienteExeption {
    alicia.comprarAlimento(alimentoAgrandador);
    Double valorEsperado = 600.0;
    Double valorObtenido = alicia.getDinero();
    assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test(expected = DineroInsuficienteExeption.class)
	public void queNoSeExedaDelDineroDisponible() throws DineroInsuficienteExeption {
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande() throws DineroInsuficienteExeption, TamanioLimiteException {
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		Double valorObtenido = alicia.getAltura();
		Double valorEsperado = 180.0 + 40.0;
		assertEquals(valorObtenido, valorEsperado);
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeEncoja() throws DineroInsuficienteExeption, TamanioLimiteException {
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		Double valorObtenido = alicia.getAltura();
		Double valorEsperado = 180.0 - 50.0;
		assertEquals(valorObtenido, valorEsperado);
	}
	
	@Test(expected = TamanioLimiteException.class)
	public void queAlConsumirUnAlimentoNoSePuedaAgrandarMasDe280() throws DineroInsuficienteExeption, TamanioLimiteException {
		alicia.setDinero(2000.0);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
	}
	
	@Test(expected = TamanioLimiteException.class)
	public void queAlConsumirUnAlimentoNoSePuedaAchicarMenosDe50() throws DineroInsuficienteExeption, TamanioLimiteException {
		alicia.setDinero(2000.0);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
	}
	
	@Test
	public void verificarQueLaColeccionDeAlimentosQuedeOrdenadaPorNombreDeManeraDescendente() throws DineroInsuficienteExeption {
		alicia.setDinero(2000.0);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.ordenarAlimentoDescendente();
		Alimento valorObtenido = alicia.getAlimentos().get(1);
		Alimento valorEsperado = alimentoAchicador;
		assertEquals(valorObtenido, valorEsperado);
		
		
	}
	@Test
	public void pruebaMap() throws DineroInsuficienteExeption {
		alicia.setDinero(100000000000.0);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAgrandador);
		List<Alimento>alimentos = alicia.getAlimentos();
		String key = "key1";
		//alicia.comprarAlimento(alimentoAgrandador);
		List<Alimento>alimentos2 = alicia.getAlimentos();
		String key2 = "key2";
		alimentos2.add(alimentoAchicador);
		
		alicia.agregarAMap(key,alimentos);
		alicia.agregarAMap(key2,alimentos2);
		
		Map<String, List<Alimento>> mapa = alicia.ordenarAlimentosMap();
		Integer i = 0;
		for (Map.Entry<String, List<Alimento>> entry : mapa.entrySet()) {
			switch (i) {
			case 0:
				assertEquals(key, entry.getKey());
				assertEquals(3, entry.getValue().size());
				i++;
				break;
			case 1:
				assertEquals(key2, entry.getKey());
				assertEquals(3, entry.getValue().size());
				i++;
				break;
			default:
				break;
			}
		}
	}

}
