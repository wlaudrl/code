package pack;

import jakarta.persistence.*;
import domain.SangpumTable;

public class SangpumSave {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			SangpumTable sangtab = new SangpumTable(9, "새우깡", 10, 3000);
			entityManager.persist(sangtab);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		emf.close();
		
		SangpumSelectMain.main(args);
	}
}