package com.example.api_spring_book.service

import com.example.api_spring_book.domain.AuthorEntity
import com.example.api_spring_book.dto.AuthorDTO

interface AuthorService {
    fun saveEntityforAuthor(authorEntity: AuthorEntity) : AuthorEntity

    fun fetchAuthorbyName(authorName: String?): List<AuthorDTO>

    fun fetchAllLists(): List<AuthorEntity>

    fun getAuthorbyID(id: Long) : AuthorEntity?

    fun fullUpdateAuthor(id: Long, authorEntity: AuthorEntity) : AuthorEntity

    fun deleteAuthor(id: Long)

}