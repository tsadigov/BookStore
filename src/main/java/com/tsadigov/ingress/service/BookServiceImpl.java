package com.tsadigov.ingress.service;

import com.tsadigov.ingress.dao.BookRepo;
import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.dto.BookDTO;
import com.tsadigov.ingress.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public List<BookDTO> getAllBooks() {

        List<BookDTO> books = Mapper.mapAll(bookRepo.findAll(), BookDTO.class);
        return books;
    }
}
