package model.entities;

import java.util.Objects;

public class Item {
	
private int id;
private float valor;
private String produto;
private int quantia;
private Pedido pedido;
public Item() {
	
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
	Item other = (Item) obj;
	return id == other.id;
}
public Item(int id, float valor, String produto, int quantia, Pedido pedido) {
	super();
	this.id = id;
	this.valor = valor;
	this.produto = produto;
	this.quantia = quantia;
	this.pedido = pedido;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public String getProduto() {
	return produto;
}
public void setProduto(String produto) {
	this.produto = produto;
}
public int getQuantia() {
	return quantia;
}
public void setQuantia(int quantia) {
	this.quantia = quantia;
}
public Pedido getPedido() {
	return pedido;
}
public void setPedido(Pedido pedido) {
	this.pedido = pedido;
}
@Override
public String toString() {
	return "Item [id=" + id + ", valor=" + valor + ", produto=" + produto + ", quantia=" + quantia + ", pedido="
			+ pedido + "]";
}

}
