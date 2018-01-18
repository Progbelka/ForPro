package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The persistent class for the category database table.
 * 
 */
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private IntegerProperty categoryIdProperty;
	
	private StringProperty categoryNameProperty;

	private int сategoryId;

	private String name;

	private Category category;

	private List<Category> categories;

	private List<Product> products;

	public Category() {
		this.categoryIdProperty = new SimpleIntegerProperty();
		this.categoryNameProperty = new SimpleStringProperty();
	}

	public int getСategoryId() {
		return this.categoryIdProperty.get();
	}

	public void setСategoryId(int сategoryId) {
		this.categoryIdProperty.set(сategoryId);
	}

	public IntegerProperty categoryIdProperty() {
		return categoryIdProperty;
	}
	public String getName() {
		return this.categoryNameProperty.get();
	}

	public void setName(String name) {
		this.categoryNameProperty.set(name);;
	}

	public StringProperty categoryNameProperty() {
		return categoryNameProperty;
	}
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setCategory(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setCategory(null);

		return category;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	@Override
	public String toString() {
		return "Category [сategoryId=" + сategoryId + ", name=" + name + ", category=" + category + ", categories="
				+ categories + ", products=" + products + "]";
	}

}