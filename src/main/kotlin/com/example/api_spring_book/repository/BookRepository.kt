package com.example.api_spring_book.repository

import com.example.api_spring_book.domain.BookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookEntity, Long>
