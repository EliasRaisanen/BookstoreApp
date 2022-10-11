package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bookstore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title, author, isbn, published, price;
    @ManyToOne

    @JoinColumn(name = "categoryid")
    
    private Category category;
	
	public Bookstore() {}

	public Bookstore(String title, String author, String isbn, String published, String price, Category category) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.published = published;
		this.price = price;
		this.category =category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String year) {
		this.published = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if(this.category != null)
			
		return "Bookstore [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", published="
				+ published + ", price=" + price + ", category=" + this.getCategory() + "]";
		
		else
				return "Bookstore [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", published="
				+ published + ", price=" + price + "]";
	}
	

	
	

}
