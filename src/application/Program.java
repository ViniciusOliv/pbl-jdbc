package application;

import model.entities.Cliente;
import model.entities.Endereco;
public class Program {

	public static void main(String[] args) {
		
		Cliente obj = new Cliente(1,"Pedro", "Rueda");
		Endereco end = new Endereco(1, "Rua 1", "Bairro 1", 111111, obj);
		System.out.println(obj);
		System.out.println(end);
	}
	
	
	
}
