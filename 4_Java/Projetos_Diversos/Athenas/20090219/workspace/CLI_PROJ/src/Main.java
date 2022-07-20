import java.util.List;

import javax.naming.InitialContext;

import entities.Cliente;

import beans.CadastroCliente;


public class Main {
	public static void main(String[] args) throws Exception {
		InitialContext ctxt = new InitialContext();
		CadastroCliente cadCli = (CadastroCliente) ctxt.lookup("EAR_PROJ/CadastroClienteBean/remote");
		
		Cliente c = new Cliente();
		c.setNome("ADATOLILDE");		
		int id = cadCli.incluir(c);

		c = cadCli.consultarPorId(id);
		System.out.println(c.getId() + " - " + c.getNome());
		
		List<Cliente> lst = cadCli.pesquisar();
		for (Cliente x : lst) {
			System.out.println(x.getId() + " - " + x.getNome());
		}	
	}
}
