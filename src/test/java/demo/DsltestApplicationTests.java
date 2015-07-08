package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.EclipseLinkTemplates;
import com.mysema.query.jpa.impl.JPAQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DsltestApplication.class)
public class DsltestApplicationTests {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	CompanyRepository companyrepo;
	
	
	@Before
    public void init() {
        customerrepo.save(new Customer("aaaa", "bbbb","hihi"));
        customerrepo.save(new Customer("bbbb", "cccc","hihi"));
        customerrepo.save(new Customer("bbbb", "cccc","one"));
        customerrepo.save(new Customer("bbbb", "cccc","one"));
        customerrepo.save(new Customer("bbbb", "cccc","two"));
        customerrepo.save(new Customer("dddd", "eeee","two"));
        customerrepo.save(new Customer("ffff", "qqqq","two"));
        
        companyrepo.save(new Company("hihi","서울시 "));
        companyrepo.save(new Company("one","대전광역시 "));
        companyrepo.save(new Company("two","인천광역시  "));
        
        
    }
	

	@Test
	public void list() {
		QCustomer qcustomer = QCustomer.customer;
		JPAQuery query = new JPAQuery(entityManager);
		List<Customer> list = query.from(qcustomer).list(qcustomer);
		System.out.println(list);
		
	}
	
	@Test
	public void listone(){
		QCustomer customer = QCustomer.customer;
		
		JPAQuery query = new JPAQuery(entityManager);
		Customer bbb = query.from(customer)
		  .where(customer.firstName.eq("bbb"))
		  .uniqueResult(customer);
		// from 메서드는 쿼리 대상(소스)을 지정하고, where 부분은 필터를 정의하고, uniqueResult는 프로젝션을 정의해서 1개 결과만 리턴하라고 지시한다.
		System.out.println("bbb 찾기 -> " + bbb);
		
	}
	
	@Test
	public void listother(){
		QCustomer customer = QCustomer.customer;
		JPAQuery query = new JPAQuery(entityManager);
		List<Customer> list2 = query.from(customer).where(customer.firstName.eq("bbbb"), customer.lastName.eq("cccc")).list(customer);
		System.out.println("여러리턴값 리턴받는 조건 검색 -> " + list2.get(0).getFirstName() + list2.get(0).getLastName());
		
	}
	
	@Test
	public void countAll(){
		JPAQuery query = new JPAQuery(entityManager);
        QCustomer customer = QCustomer.customer;
        Long count = query.from(customer).uniqueResult(customer.count());
        System.out.println("querydsl ==> " + count);
	}
	
	@Test
	public void joinquery(){
		QCustomer customer = QCustomer.customer;
		QCompany company = QCompany.company;
		JPAQuery query = new JPAQuery(entityManager);
		//JPQLQuery query = null;//new HibernateQuery(session);//(entityManager);
		List<Tuple> list = query.from(customer).innerJoin(company).on(customer.companyname.eq(company.companyname))
	    .list(customer.firstName, customer.lastName);
		
		
		System.out.println(list);
		
	}

}
