package com.example.api_spring_book.dto

data class BookDTO(
    val isbn: String,
    val title: String,
    val description: String,
    val image: String,
    val author: AuthorDTO
)
