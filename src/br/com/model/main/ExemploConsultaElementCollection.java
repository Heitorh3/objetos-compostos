package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Cliente;
import br.com.model.util.JPAUtil;

public class ExemploConsultaElementCollection {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		Cliente cliente = em.find(Cliente.class, 4L);
		
		System.out.println(cliente.getNome());
		cliente.getEnderecos().forEach(e -> System.out.println("Rua: " + e.getRua() +
															   " Bairro: " + e.getBairro()+
															   " Cidade: " + e.getCidade()));
	}

}
