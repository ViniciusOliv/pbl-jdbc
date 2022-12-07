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
		
		System.out.println("----tentando todos-- ");
		List<Cliente> list = clienteDao.findAll();
		
		list = clienteDao.findAll();
		for (Cliente cli : list) {
			System.out.println(cli);
		}
		
		
		System.out.println(cliente);
		
	}
	
}
