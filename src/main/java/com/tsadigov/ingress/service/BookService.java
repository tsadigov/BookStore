package com.tsadigov.ingress.service;

import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

}
