package com.ebere.bookcatalog_management_service.repository;

import com.ebere.bookcatalog_management_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

