package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.servicies.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/books")

@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;


    @GetMapping
    public ResponseEntity<?> getAllBooks() throws Exception{
        try {
            return ResponseEntity.ok(bookService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{bookID}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookID) throws Exception{
    
        try {
            return ResponseEntity.ok(bookService.getBookByID(bookID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }    
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book bookToCreate) throws Exception{
        try {
            return ResponseEntity.ok(bookService.createBook(bookToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      
        }
    }

    @DeleteMapping("/bookID")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookID) throws Exception{
    
        try {
            bookService.deleteBookByID(bookID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }  
    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book bookToUpdate) throws Exception{
        try {
            return ResponseEntity.ok(bookService.updateBook(bookToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      
        }
    }

    




}
