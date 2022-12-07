package application;



import java.util.List;
import java.util.Scanner;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;
import model.entities.Endereco;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		ClienteDao clienteDao = DaoFactory.createClienteDao();

		
		System.out.println("---- PROCURANDO POR ID -----");
		Cliente cliente = clienteDao.findById(2);
		
		System.out.println("---- Inserindo -----");
		Cliente newCliente = new Cliente(1, "Pedro", "raul");
		clienteDao.insert(newCliente);
		System.out.println("Inserido, novo id= " + newCliente.getId() );
		
		System.out.println("---- Atualizando -----");
		cliente = clienteDao.findById(2);
		cliente.setNome("Currupira");
		clienteDao.update(cliente);
		System.out.println("Atualizado!");
		
		System.out.println("---- Deletando -----");
		int id = sc.nextInt();
		clienteDao.deleteById(id);
		System.out.print("Deletado");
		}
	
}
