package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String rua;
	private String bairro;
	private int cep; 
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}


	public Endereco() {
		
	}

	public Endereco(int id, String rua, String bairro, int cep) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", cep=" + cep + "]";
	}
	
	
}
