package br.up.ejb.exemplo1.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")

public class Pedido implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pdd_id")
	private int id;
	
	@Column(name = "pdd_data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "cli_id_fk")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private List<Item> itens;
	
	public Pedido() {
		this.itens = new ArrayList<Item>();
	}
	
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		StringBuffer sb = new StringBuffer();
		
		sb.append("Pedido:\n");
		sb.append("[id: ").append(this.id).append("]\n");
		sb.append("[data: ").append(df.format(this.data)).append("]\n");
		
		for (Item i : this.itens) {
			sb.append(i);
		}
		
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
