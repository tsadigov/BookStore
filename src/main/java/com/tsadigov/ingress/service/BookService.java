package com.tsadigov.ingress.service;

import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.dto.BookAndPublisherDTO;
import com.tsadigov.ingress.dto.BookDTO;

import java.util.List;

public interface BookService {


    List<BookAndPublisherDTO> getAllBooks();
    List<BookAndPublisherDTO> getSpecificBook(String data);
    List<BookDTO> getBooksByAuthor(Long id);

}
