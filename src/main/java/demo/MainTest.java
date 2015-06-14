package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.jpa.impl.JPAQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DsltestApplication.class)
public class MainTest {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	
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
