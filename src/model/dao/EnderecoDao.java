package model.dao;

public class EnderecoDao {

	void insert(Endereco obj);
	void update(Endereco obj);
	void deleteById(int id);
	void findById(int id);
	List<Endereco> findAll();
	
}
