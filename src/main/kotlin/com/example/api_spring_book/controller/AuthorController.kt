package com.example.api_spring_book.controller

import com.example.api_spring_book.dto.AuthorDTO
import com.example.api_spring_book.extension.toAuthorDTO
import com.example.api_spring_book.extension.toAuthorEntity
import com.example.api_spring_book.service.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v2/authors")
@Validated
class AuthorController(private val authorService: AuthorService) {
    @PostMapping
    fun addAuthorsName(@RequestBody authorDTO: AuthorDTO): ResponseEntity<AuthorDTO> {
        try {
            val createAuthor = authorService.saveAuthor(authorDTO.
            toAuthorEntity()).toAuthorDTO()
            return ResponseEntity(createAuthor, HttpStatus.CREATED)
        } catch(ex: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
    @GetMapping
    fun fetchManyAuthors(): List<AuthorDTO> {
        val authors = authorService.fetchAllLists()
        return authors.map {
            author -> AuthorDTO(
                id = author.id,
                name = author.name,
                age = author.age,
                description = author.description,
                image = author.image
            )
        }
    }
    @GetMapping(path = ["/{id}"])
    fun readIndividualAuthor(@PathVariable("id") id: Long): ResponseEntity<AuthorDTO> {
        val newAuthor = authorService.getAuthorByID(id = id)?.toAuthorDTO()
        return newAuthor?.let { author ->
            ResponseEntity(author, HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }
    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(@PathVariable("id") id: Long, @RequestBody authorDTO: AuthorDTO) : ResponseEntity<AuthorDTO> {
        try {
            val updatedAuthor = authorService.fullUpdateAuthor(id = id, authorEntity = authorDTO.toAuthorEntity())
            return  ResponseEntity(updatedAuthor.toAuthorDTO(), HttpStatus.OK)

        } catch (ex: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)

        }
    }
    @DeleteMapping(path = ["/{id}"])
    fun deleteAuthor(@PathVariable("id") id: Long) : ResponseEntity<Unit> {
        val deleteAuthor = authorService.deleteAuthor(id = id)
        return ResponseEntity(deleteAuthor, HttpStatus.NO_CONTENT)
    }
}