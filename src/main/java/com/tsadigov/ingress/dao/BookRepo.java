package com.tsadigov.ingress.dao;

import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findBooksByBookNameContainingOrBookDetailsContaining(String bookName, String bookDetails);
    List<Book> findBooksByPublisher(AppUser publisher);

}
