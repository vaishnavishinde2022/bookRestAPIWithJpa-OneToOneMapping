package com.book.model;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import com.book.entity.Book;

@Component
//bellow Model class act as a model in MVC and responsible for to interact with database.
public class Model 
{
	/*
	 * @Autowired To injecting bean at run time.
	 */
	@Autowired
	BookRepository repo;
   public Book addBook(Book Bookobj)
   {
	   Book result=repo.save(Bookobj);
	   
	   return result;
	   
   }//addBook
   
   public ArrayList<Book> getAllBooks()
   {
	   ArrayList<Book> arrayList;
	  Iterable<Book> itr=repo.findAll(); 
	  
	  
	  arrayList=(ArrayList<Book>) itr;
	  
	  return arrayList;
	  
   }//getAllBooks
   
   public Book getBook(int id)
   {
	   Book objBook=null;
	  Optional<Book> op= repo.findById(id);
	  
	  objBook=op.get();
	  return objBook;
	  
   }//getBook
   
   public Book updateBook(int id,Book objBook)
   {
	   Book result=null;
	   Optional<Book> op=repo.findById(id);
	   
	   result=op.get();
	   
	   result.setName(objBook.getName());
	   result.setAuthor(objBook.getAuthor());
	   
	   repo.save(result);
	   
	   return result;
	   
   }//updateBook
   
   public void deleteBook(int id)
   {
	   repo.deleteById(id);
	     
	   
   }//deleteBook
}
