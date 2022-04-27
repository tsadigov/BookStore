package com.tsadigov.ingress.service;

import com.tsadigov.ingress.dao.AppUserRepo;
import com.tsadigov.ingress.dao.BookRepo;
import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.dto.BookAndPublisherDTO;
import com.tsadigov.ingress.dto.BookDTO;
import com.tsadigov.ingress.exception.ResourceNotFoundException;
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
    private final AppUserRepo userRepo;

    @Override
    public List<BookAndPublisherDTO> getAllBooks() {
        List<BookAndPublisherDTO> books = Mapper.mapAll(bookRepo.findAll(), BookAndPublisherDTO.class);
        return books;
    }

    @Override
    public List<BookAndPublisherDTO> getSpecificBook(String data) {
        List<BookAndPublisherDTO> books = Mapper.mapAll(bookRepo.findBooksByBookNameContainingOrBookDetailsContaining(data, data), BookAndPublisherDTO.class);
        return books;
    }

    @Override
    public List<BookDTO> getBooksByAuthor(Long id) {
        AppUser publisher = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        List<BookDTO> books = Mapper.mapAll(bookRepo.findBooksByPublisher(publisher), BookDTO.class);
        return books;
    }

}
