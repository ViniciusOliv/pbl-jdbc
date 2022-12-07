package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String sobrenome;

	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Cliente() {
		
	}
	

	public Cliente(int id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}




}
