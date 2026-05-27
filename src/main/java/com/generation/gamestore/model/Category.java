package com.generation.gamestore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categories")
public class Category {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "The attribute 'name' is required.")
	    @Size(min = 3, max = 100, message = "The attribute 'name' must be between 3 and 100 characters.")
	    private String name;
	    
	    @Size(max = 500, message = "The attribute 'description' must not exceed 500 characters.")
	    private String description;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
	    @JsonIgnoreProperties("category")
	    private List<Product> products;

	    public Category() {
	    }

	    public Category(Long id, String name, String description) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}
	    
		
}
