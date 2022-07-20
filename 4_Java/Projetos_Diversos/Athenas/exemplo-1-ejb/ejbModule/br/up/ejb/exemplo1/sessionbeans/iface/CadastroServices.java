package br.up.ejb.exemplo1.sessionbeans.iface;

import br.up.ejb.exemplo1.entities.Cliente;
import br.up.ejb.exemplo1.entities.Item;
import br.up.ejb.exemplo1.entities.Pedido;
import br.up.ejb.exemplo1.entities.Produto;

public interface CadastroServices {
	public Produto consultarProdutoPorId(int id);	
	public int incluirCliente(Cliente c);
	public Cliente incluirClientePedidosItens(Cliente c);
	public int incluirPedido(int idCliente, Pedido p);
	public int incluirItem(int idPedido, Item i);
}
