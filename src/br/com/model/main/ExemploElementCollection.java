package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Cliente;
import br.com.model.domain.Endereco;
import br.com.model.util.JPAUtil;

public class ExemploElementCollection {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria do Carmo");
		cliente.getTelefones().add("(34) 1234-5678");
		cliente.getTelefones().add("(34)3231-5448");
		cliente.getEnderecos().add(new Endereco("Antônio Fortunato da Silva", "Santa Mônica", "Uberlândia"));
		cliente.getEnderecos().add(new Endereco("Antônio Fortunato da Silva", "Santa Mônica", "Uberlândia"));
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
