package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Proprietario;
import br.com.model.domain.Veiculo;
import br.com.model.domain.VeiculoId;
import br.com.model.util.JPAUtil;

public class ExemploObjetoEmbutido {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Veiculo v = new Veiculo();
		v.setCodigo(new VeiculoId("AAA-1111", "Rio de Janeiro"));
		v.setFabricante("Volks");
		v.setModelo("Fusca");
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João da Silva");
		proprietario.setTelefone("11111111");
		proprietario.setEmail("joao@silva.com");
		v.setProprietario(proprietario);
		
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		
		
		em.close();
	}

}
