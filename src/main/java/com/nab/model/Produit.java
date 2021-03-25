package com.nab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "produit")
public class Produit {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;
	
	@Column(name = "price")
	private String price;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

}
