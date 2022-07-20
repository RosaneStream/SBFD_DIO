import java.util.Date;

import javax.naming.InitialContext;

import br.up.ejb.exemplo1.entities.Cliente;
import br.up.ejb.exemplo1.entities.Item;
import br.up.ejb.exemplo1.entities.Pedido;
import br.up.ejb.exemplo1.sessionbeans.iface.CadastroServices;

public class Main1 {
	public static void main(String[] args) throws Exception {
		InitialContext ct = new InitialContext();
		CadastroServices cs = (CadastroServices) ct.lookup("exemplo-1-ear/CadastroServicesBean/remote");
		
		Cliente c = new Cliente();
		c.setNome("Novo Cliente");
		
		Pedido p = new Pedido();
		p.setCliente(c);
		p.setData(new Date());
		c.getPedidos().add(p);
		
		Item i = new Item();
		i.setProduto(cs.consultarProdutoPorId(1));
		i.setQtdd(1);
		p.getItens().add(i);
		
		int idCliente = cs.incluirCliente(c);
		c.setId(idCliente);
		
		int idPedido = cs.incluirPedido(idCliente, p);
		p.setId(idPedido);
		
		int idItem = cs.incluirItem(idPedido, i);
		i.setId(idItem);
		
		System.out.println(c);
	}
}
