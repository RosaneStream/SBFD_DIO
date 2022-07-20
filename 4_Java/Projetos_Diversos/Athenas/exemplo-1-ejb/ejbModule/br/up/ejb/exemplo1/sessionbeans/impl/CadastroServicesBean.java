package br.up.ejb.exemplo1.sessionbeans.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.up.ejb.exemplo1.entities.Cliente;
import br.up.ejb.exemplo1.entities.Item;
import br.up.ejb.exemplo1.entities.Pedido;
import br.up.ejb.exemplo1.entities.Produto;
import br.up.ejb.exemplo1.sessionbeans.iface.CadastroServices;

@Stateless
@Remote(br.up.ejb.exemplo1.sessionbeans.iface.CadastroServices.class)

public class CadastroServicesBean implements CadastroServices {
	@PersistenceContext EntityManager manager;
	
	public Produto consultarProdutoPorId(int id) {
		return manager.find(Produto.class, id);
	}

	public int incluirCliente(Cliente c) {
		persist(c);
		return c.getId();
	}
	
	public Cliente incluirClientePedidosItens(Cliente c) {
		int idCliente = incluirCliente(c);
	
		for (Pedido p : c.getPedidos()) {
			int idPedido = incluirPedido(idCliente, p);
			
			for (Item i : p.getItens()) {
				incluirItem(idPedido, i);
			}
		}
		
		return c;
	}
	
	public int incluirItem(int idPedido, Item i) {
		i.setPedido(manager.find(Pedido.class, idPedido));
		persist(i);
		return i.getId();
	}
	
	public int incluirPedido(int idCliente, Pedido p) {
		p.setCliente(manager.find(Cliente.class, idCliente));
		persist(p);
		return p.getId();
	}
	
	private void persist(Object obj) {
		manager.persist(obj);
		manager.flush();
	}
}
