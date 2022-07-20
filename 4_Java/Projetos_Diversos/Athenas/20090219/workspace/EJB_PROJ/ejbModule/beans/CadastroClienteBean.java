package beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Cliente;

@Stateless

@Remote(beans.CadastroCliente.class)
@Local(beans.CadastroCliente.class)

public class CadastroClienteBean implements CadastroCliente {
	@PersistenceContext EntityManager manager;

	public void alterar(Cliente c) {
		// validar cliente
		manager.merge(c);
		// ...
	}

	public Cliente consultarPorId(int id) {
		return (Cliente) manager.find(Cliente.class, id);
	}

	public int incluir(Cliente c) {
		// validar cliente
		manager.persist(c);
		manager.flush();
		return c.getId();
	}

	public List<Cliente> pesquisar() {
		return (List<Cliente>) manager.createQuery("from Cliente c").getResultList();
	}

	public void remover(Cliente c) {
		// ...
		c = manager.merge(c);
		manager.remove(c);
		// ...
	}
}
