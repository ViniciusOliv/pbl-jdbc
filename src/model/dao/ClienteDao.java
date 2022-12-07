package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {

	void insert(Cliente obj);
	void update(Cliente obj);
	void deleteById(int id);
	Cliente findById(int id);
	List<Cliente> findAll();
	
}
