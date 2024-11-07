package com.example.api_spring_book.dto

data class AuthorDTO(
    val id: Long,
    val name: String,
    val age: Int,
    val description: String,
    val image: String
)
