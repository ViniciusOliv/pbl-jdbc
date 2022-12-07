package model.dao;

import java.util.List;

import model.entities.Cliente;
import model.entities.Endereco;

public interface ClienteDao {

	void insert(Cliente obj);
	void update(Cliente obj);
	void deleteById(int id);
	Cliente findById(int id);
	List<Cliente> findAll();
	List<Cliente> findByEndereco(Endereco endereco);
	
}
