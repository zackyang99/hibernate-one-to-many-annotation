package zyang.HibernateOne2ManyAnnotation.app;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import zyang.HibernateOne2ManyAnnotation.entity.Category;
import zyang.HibernateOne2ManyAnnotation.entity.Product;
import zyang.HibernateOne2ManyAnnotation.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		 
	    Session session = factory.getCurrentSession();
        
	    try {
	    	session.getTransaction().begin();
	    	
//	    	query
	    	
//	    	String sql = "from " + Category.class.getName();
//	    	Query<Category> query = session.createQuery(sql);
//	    	List<Category> categories = query.getResultList();
//	    	
//	    	for (Category c : categories) {
//	    		System.out.println(c.getId() + "|" + c.getName());
//	    		Set<Product> ps = c.getProducts();
//	    		for (Product p : ps) {
//	    			System.out.println(p.getId() + "|" + p.getPrice());
//	    		}
//	    	}
	    	
	    	
//	    	save children while saving parents
//	    	Product np = new Product();
//	    	np.setName("Lexus");
//	    	np.setPrice(3000);
//	    	
//	    	System.out.println(np.getName());
//	    	
//	    	String sql = "select c from " + Category.class.getName() + " c where c.id = :cId";
//	    	Query<Category> query = session.createQuery(sql);
//	    	query.setParameter("cId", 1L);
//	    	Category c = query.getSingleResult();
//	    	np.setCategory(c);
//	    	System.out.println("Category");
//	    	System.out.println(c.getId() + "|" + c.getName());
//	    	c.getProducts().add(np);
//	    	session.persist(c);
	    	
//	    	save children only
//	    	Product np = new Product();
//	    	np.setName("Lexus");
//	    	np.setPrice(3000);
//	    	session.persist(np);
	    	
	    	
//	    	delete children
//	    	String sql = "select c from " + Category.class.getName() + " c where c.id = :cId";
//	    	Query<Category> query = session.createQuery(sql);
//	    	query.setParameter("cId", 1L);
//	    	Category c = query.getSingleResult();
//	    	System.out.println("Category");
//	    	System.out.println(c.getId() + "|" + c.getName());
//	    	Set<Product> products = c.getProducts();
//	    	Product p1 = products.iterator().next();
//	    	System.out.println(p1.getName() + "|" + p1.getPrice());
//	    	c.getProducts().remove(p1);
//	    	session.persist(c);
	    	
	    	
//	    	delete parent
//	    	String sql = "select c from " + Category.class.getName() + " c where c.id = :cId";
//	    	Query<Category> query = session.createQuery(sql);
//	    	query.setParameter("cId", 1L);
//	    	Category c = query.getSingleResult();
//	    	System.out.println("Category");
//	    	System.out.println(c.getId() + "|" + c.getName());
//	    	session.remove(c);
	    	
//	    	insert parent
	    	Category c = new Category();
	    	c.setName("Quantum");
	    	
	    	Product p1 = new Product();
	    	p1.setName("IBM");
	    	p1.setPrice(10000);
	    	p1.setCategory(c);
	    	
	    	c.getProducts().add(p1);
	    	
	    	session.persist(c);
	    	
	    	session.getTransaction().commit();
	    } catch (Exception e) {
	    	session.getTransaction().rollback();
	    	throw new RuntimeException(e);
	    }finally {
	    	session.close();
	        HibernateUtil.shutdown();
	        System.out.println("in finally");
	    }
        
        
        
        
	}

}
