package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Cliente;
import br.com.model.util.JPAUtil;

public class ExemploTiposBasicos {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		Cliente cliente = new Cliente();
		cliente.setNome("João de Deus");
		cliente.getTelefones().add("(34) 1234-5678");
		cliente.getTelefones().add("(34)3231-5448");
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
