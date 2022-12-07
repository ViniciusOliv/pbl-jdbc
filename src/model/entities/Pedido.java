package model.entities;

import java.util.Objects;

public class Pedido {

	private int id;
	private Cliente cliente ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedido(){
		
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + "]";
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
		Pedido other = (Pedido) obj;
		return id == other.id;
	}
	
	public Pedido(int id, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}
}
