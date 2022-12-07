package application;



import java.util.List;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;
import model.entities.Endereco;
public class Program {

	public static void main(String[] args) {

		
		ClienteDao clienteDao = DaoFactory.createClienteDao();

		
		System.out.println("---- PROCURANDO POR ID -----");
		Cliente cliente = clienteDao.findById(2);
		
		System.out.println("---- Inserindo -----");
		Cliente newCliente = new Cliente(null, "Pedro","raul", end);
		clienteDao.insert(newCliente);
		System.out.println("Inserido, novo id= " + newCliente.getId() );
		
		System.out.println(cliente);
		
	}
	
}
