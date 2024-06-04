package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}