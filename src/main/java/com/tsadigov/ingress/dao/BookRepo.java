package com.tsadigov.ingress.dao;

import com.tsadigov.ingress.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
