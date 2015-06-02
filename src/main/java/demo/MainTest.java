package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysema.query.jpa.impl.JPAQuery;

public class MainTest {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
/*
	@Before
	public void setUp() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("com.mysema.query.jpa");
	}

	@After
	public void tearDown() {
		entityManagerFactory.close();
	}

*/	
	
	@Test
	public void test() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Customer("bbb", "aaa"));
		entityManager.persist(new Customer("ccc", "ddd"));
		entityManager.getTransaction().commit();

		QCustomer customer = QCustomer.customer;
		JPAQuery query = new JPAQuery(entityManager);
		List<Customer> list = query.from(customer).list(customer);
		System.out.println(list);

		entityManager.close();
	}

}
