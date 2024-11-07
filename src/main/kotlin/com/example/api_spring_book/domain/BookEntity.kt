package com.example.api_spring_book.domain

import jakarta.persistence.*

@Entity
@Table(name = "bookstable")
data class BookEntity(
    @Id
    @Column(name = "isbn")
    val isbn: String,

    @Column(name="title")
    val title: String,

    @Column(name = "description")
    val description: String,

    @Column(name= "image")
    val image: String,

    @ManyToOne(cascade = [(CascadeType.DETACH)])
    @JoinColumn(name = "author_id")
    val author: AuthorEntity

)
