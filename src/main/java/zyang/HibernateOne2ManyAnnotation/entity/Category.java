package zyang.HibernateOne2ManyAnnotation.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
    @Column(name="CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval = true)
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Set<Product> products = new HashSet();
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Set<Product> getProducts() {
		return products;
	}

}
