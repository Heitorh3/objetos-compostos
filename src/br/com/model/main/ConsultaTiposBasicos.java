package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Cliente;
import br.com.model.util.JPAUtil;

public class ConsultaTiposBasicos {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class,1L);
		
		System.out.println("Nome: " + cliente.getNome());
		
		cliente.getTelefones().forEach(t -> System.out.println("Telefones:" + t));
	}
}
