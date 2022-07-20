package br.up.ejb.exemplo1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens")

public class Item implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itn_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "prd_id_fk")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "pdd_id_fk")
	private Pedido pedido;
	
	@Column(name = "itn_qtdd")
	private int qtdd;	

	public Item() {
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Item:\n");
		sb.append("[id: ").append(this.id).append("]\n");
		sb.append("[qtdd: ").append(this.qtdd).append("]\n");
		sb.append(produto);

		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public int getQtdd() {
		return qtdd;
	}

	public void setQtdd(int qtdd) {
		this.qtdd = qtdd;
	}
}
