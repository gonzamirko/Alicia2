package ar.edu.unlam.pb2.dominio;

public interface Comprador {
Boolean comprarAlimento(Alimento alimentoAgrandador)throws DineroInsuficienteExeption;
}
