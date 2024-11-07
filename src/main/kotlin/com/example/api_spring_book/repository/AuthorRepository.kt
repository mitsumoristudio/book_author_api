package com.example.api_spring_book.repository

import com.example.api_spring_book.domain.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AuthorRepository: JpaRepository<AuthorEntity, Long> {
    fun findAuthorByName(authorsName: String): List<AuthorEntity?>

    @Query(value = "SELECT * FROM authorstable where name like %?1% ", nativeQuery = true)
    fun findAuthorbyName(authorName: String?): List<AuthorEntity>
}