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
		// 쿼리DSL 에서 QCustomer 를 만들어줌. 
		// QCustomer는 기본 인스턴스 변수를 갖고 있으며, 다음과 같이 정적 필드로 접근할 수 있다.
		// public static final QCustomer customer = new QCustomer("customer");
		
		JPAQuery query = new JPAQuery(entityManager);
		// JPAQuery가 JPA 모듈을 위한 Query 구현체이며, 다음과 같이 인스턴스를 생성한다.
		
		List<Customer> list = query.from(customer).list(customer);
		// customer list 를 불러오는 쿼리.
		System.out.println(list);
		
		JPAQuery query2 = new JPAQuery(entityManager);
		// 어떻게 JPAQuery를 재활용 할수 있을까???
		Customer bbb = query2.from(customer)
		  .where(customer.firstName.eq("bbb"))
		  .uniqueResult(customer);
		// from 메서드는 쿼리 대상(소스)을 지정하고, where 부분은 필터를 정의하고, uniqueResult는 프로젝션을 정의해서 1개 결과만 리턴하라고 지시한다.
		System.out.println("bbb 찾기 -> " + bbb);
	
		JPAQuery query3 = new JPAQuery(entityManager);
		List<Customer> list2 = query3.from(customer).where(customer.firstName.eq("ccc"), customer.lastName.eq("ddd")).list(customer);
		System.out.println("여러리턴값 리턴받는 조건 검색 -> " + list2.get(0).getFirstName() + list2.get(0).getLastName());
		
		entityManager.close();
	}

}
