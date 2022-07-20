package beans;

import java.util.List;

import entities.Cliente;

public interface CadastroCliente {
	public int incluir(Cliente c);
	public void alterar(Cliente c);
	public Cliente consultarPorId(int id);
	public List<Cliente> pesquisar();
	public void remover(Cliente c);
}
