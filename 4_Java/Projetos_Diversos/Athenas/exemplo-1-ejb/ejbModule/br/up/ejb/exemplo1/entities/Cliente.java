package br.up.ejb.exemplo1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id")
	private int id;
	
	@Column(name = "cli_nome")
	private String nome;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	public Cliente() {
		this.pedidos = new ArrayList<Pedido>();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Cliente:\n");
		sb.append("[id: ").append(this.id).append("]\n");
		sb.append("[nome: ").append(this.nome).append("]\n");
		
		for (Pedido p : this.pedidos) {
			sb.append(p);
		}
		
		return sb.toString();
	}

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
