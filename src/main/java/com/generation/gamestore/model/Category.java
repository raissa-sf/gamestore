package com.generation.gamestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "The attribute 'name' is mandatory.")
	    @Size(min = 3, max = 100, message = "The attribute 'name' must be between 3 and 100 characters.")
	    private String name;
	    
	    @Size(max = 500, message = "The attribute 'description' must not exceed 500 characters.")
	    private String description;
}
