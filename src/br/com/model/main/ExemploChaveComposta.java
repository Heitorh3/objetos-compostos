package br.com.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.domain.Veiculo;
import br.com.model.domain.VeiculoId;
import br.com.model.util.JPAUtil;

public class ExemploChaveComposta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1234", "Rio Claro"));
		veiculo.setFabricante("GM");
		veiculo.setModelo("Chevette");
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		
		VeiculoId codigo =  new VeiculoId("ABC-1234", "Rio Claro");
		Veiculo v = em.find(Veiculo.class, codigo);
		
		System.out.println("Veiculo " + v.getCodigo().getPlaca() + " - " 
				+ v.getCodigo().getCidade() + " - Fabricante: " + v.getFabricante());
		
		em.close();
	}
}
