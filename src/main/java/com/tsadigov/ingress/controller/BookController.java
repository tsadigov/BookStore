package com.tsadigov.ingress.controller;

import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.dto.BookDTO;
import com.tsadigov.ingress.dto.ResponseDTO;
import com.tsadigov.ingress.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tsadigov.ingress.bootstrap.Constants.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {

        List<BookDTO> books = bookService.getAllBooks();
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .response(books)
                .build();

        return ResponseEntity.ok()
                .body(responseDTO);
    }

}
