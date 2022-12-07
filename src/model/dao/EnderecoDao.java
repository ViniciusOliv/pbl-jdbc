package model.dao;

import java.util.List;

import model.entities.Endereco;
	
	public interface EnderecoDao {
	void insert(Endereco obj);
	void update(Endereco obj);
	void deleteById(int id);
	Endereco findById(int id);
	List<Endereco> findAll();
	}
	

