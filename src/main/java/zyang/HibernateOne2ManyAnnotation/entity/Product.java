package zyang.HibernateOne2ManyAnnotation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
    @Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private float price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID", nullable=false)
//	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	public Product() {
		
	}
	
	public Product(String name, float price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
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
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

}
