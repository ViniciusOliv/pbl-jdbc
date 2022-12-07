package model.dao;

public class ClienteDao {

	void insert(Cliente obj);
	void update(Cliente obj);
	void deleteById(int id);
	void findById(int id);
	List<Cliente> findAll();
	
}
