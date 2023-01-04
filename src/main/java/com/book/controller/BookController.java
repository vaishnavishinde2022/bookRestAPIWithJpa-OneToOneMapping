package com.book.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import com.book.model.Model;

import com.book.entity.Book;

@RestController
public class BookController 
{
	/*
	 * @Autowired To injecting bean at run time.
	 */
	@Autowired
	Model modelObj;
	
	/*
	 * @PostMapping to map the POST Http request
	 */
   @PostMapping("/add")
   
   /*
    * ResponseEntity represents an HTTP responses,status code,header,body.
    */
   public ResponseEntity<Book> addBook(@RequestBody Book bookObj)
   {
	   Book bookObj1;
	   bookObj1=modelObj.addBook(bookObj);
	   
	   return ResponseEntity.of(Optional.of(bookObj1));
	   
   }//addBook
   
   @GetMapping("/books")
   
   public ResponseEntity<ArrayList<Book>> getAllBooks()
   {
	   ArrayList<Book> arrayList;
	   try
	   {
	   arrayList= modelObj.getAllBooks();
	   
	   return ResponseEntity.of(Optional.of(arrayList));
	   
	   }//try
	   
	   catch(Exception e)
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
	   
   }//getAllBooks
   
   @GetMapping("/book/{id}")
   
   public ResponseEntity<Book> getBook(@PathVariable("id")int id)
   {
	   Book objBook=null;
	   try
	   {
	   objBook= modelObj.getBook(id); 
	   return ResponseEntity.of(Optional.of(objBook));
	   
	   }//try
	   
	   catch(Exception e)
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
   }//getBook
   
   @PutMapping("/book/{id}")
   
   public ResponseEntity<Book> updateBook(@RequestBody Book objBook,@PathVariable("id")int id)
   {
	   Book bookObj=null;
	   try
	   {
	   bookObj= modelObj.updateBook(id,objBook);
	   
	   return ResponseEntity.of(Optional.of(bookObj));
	   
	   }//try
	   
	   catch(Exception e)
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
	   
	   
   }//updateBook
   
   @DeleteMapping("/book/{id}")
   
   public ResponseEntity<Object> deleteBook(@PathVariable("id")int id)
   {
	   try
	   {
	   modelObj.deleteBook(id);
	   return ResponseEntity.status(HttpStatus.OK).build();
	   }//try
	   
	   catch(Exception e)
	   {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
	   }
	   
   }//deleteBook
   
   
}
