package com.example.api_spring_book.extension

import com.example.api_spring_book.domain.AuthorEntity
import com.example.api_spring_book.dto.AuthorDTO

fun AuthorEntity.toAuthorDTO(): AuthorDTO {
    return AuthorDTO(
        id = this.id,
        name = this.name,
        age = this.age,
        description = this.description,
        image = this.image
    )
}

fun AuthorDTO.toAuthorEntity(): AuthorEntity {
    return AuthorEntity(
        id = this.id,
        name = this.name,
        age = this.age,
        description = this.description,
        image = this.image
    )
}