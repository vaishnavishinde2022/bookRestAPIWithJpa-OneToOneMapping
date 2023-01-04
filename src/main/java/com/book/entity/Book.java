package com.book.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/*
 * @Entity represents a class is an entity type ,and correlated with table in database.
 */
@Entity
public class Book 
{
	/*
	 * @Id indicating the member field bellow is primary key of the entity
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	/*
	 * @OneToOne JPA annotation is used to map the source entity with the target entity.
	 * Here Author is a target entity and Book is an source entity.
	 * This is unidirectional association between Book And Author entities.
	 * Author's id will act as a foreign key in Book entity.
	 */
	
	/*
	 * cascade=CascadeType.ALL:= is to indicate that when we persist,remove,refresh or merge this 
	 * entity all the attributes held in this entity would be persist,remove,delete or update
	 */
	@OneToOne(cascade=CascadeType.ALL)
    Author author;
    
    
    public Book(int id, String name, Author author)
    {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
    
    public Book()
    {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public int getId()
    {
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	public Author getAuthor() 
	{
		return author;
	}
	public void setAuthor(Author author) 
	{
		this.author = author;
	}
	
	
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}//Book class
