package com.generation.gamestore.model;

import java.math.BigDecimal; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "The attribute 'name' is required.")
    @Size(min = 3, max = 100, message = "The attribute 'name' must be between 3 and 100 characters.")
    private String name;
    
    @Size(max = 500, message = "The attribute 'description' must not exceed 500 characters.")
    private String description;
    
    @NotBlank(message = "The attribute 'consolePlatform' is mandatory.")
    private String consolePlatform;
    
    @NotNull(message = "The attribute 'price' is mandatory.")
    @DecimalMin(value = "0.0", inclusive = true, message = "The price cannot be negative.")
    private BigDecimal price; 
    
    @NotNull(message = "The attribute 'quantity' is required.")
    @Min(value = 0, message = "The quantity in stock cannot be negative.")
    private Integer quantity;
    
    private String photoUrl;
    
    @ManyToOne
    @JsonIgnoreProperties("products")
    @NotNull(message = "The product must belong to a category.") 
    private Category category;


    public Product() {
    }

    public Product(Long id, String name, String description, String consolePlatform, BigDecimal price, Integer quantity, String photoUrl, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.consolePlatform = consolePlatform;
        this.price = price;
        this.quantity = quantity;
        this.photoUrl = photoUrl;
        this.category = category;
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

    public String getConsolePlatform() {
        return consolePlatform;
    }

    public void setConsolePlatform(String consolePlatform) {
        this.consolePlatform = consolePlatform;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}