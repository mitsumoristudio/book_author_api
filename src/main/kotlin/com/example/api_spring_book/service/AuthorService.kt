package com.example.api_spring_book.service

import com.example.api_spring_book.domain.AuthorEntity
import com.example.api_spring_book.dto.AuthorDTO

interface AuthorService {
    fun saveAuthor(authorEntity: AuthorEntity): AuthorEntity

    fun fetchAuthors(authorName: String?): List<AuthorDTO>

    fun fetchAllLists(): List<AuthorEntity>

    fun getAuthorByID(id: Long) : AuthorEntity?

    fun fullUpdateAuthor(id: Long, authorEntity: AuthorEntity) : AuthorEntity

    fun deleteAuthor(id: Long)
}