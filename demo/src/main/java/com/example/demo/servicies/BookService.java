package com.example.demo.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll() throws Exception {
        try {
            return bookRepository.findAll();

        } catch (Exception e) {
            throw new Exception("Error fetching books: " + e.getMessage());
        }
    }

    public Book getBookByID (Long ID) throws Exception{
        return bookRepository.findById(ID).orElseThrow(
            ()-> new Exception("This book doesn't exist!")
        );
    }

    public void deleteBookByID(Long id) throws Exception {
        if (!bookRepository.existsById(id)) {
            throw new Exception("This book doesn't exist!");

        }
        bookRepository.deleteById(id);
    }

    public Book createBook(Book bookToCreate) throws Exception{

        return bookRepository.save(bookToCreate);
    }
    
    public Book updateBook(Book bookDetails) throws Exception{
        Book bookToUpdate=bookRepository.findById(bookDetails.getId())
        .orElseThrow(()->new Exception("This book doesn't exist!"));

        bookToUpdate.setTitle(bookDetails.getTitle());
        bookToUpdate.setAuthor(bookDetails.getAuthor());
        bookToUpdate.setDescription(bookDetails.getDescription());
        bookToUpdate.setPublishDate(bookDetails.getPublishDate());

        return bookRepository.save(bookToUpdate);
    }

    


}
