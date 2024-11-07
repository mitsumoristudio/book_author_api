package com.example.api_spring_book.service

import com.example.api_spring_book.domain.AuthorEntity
import com.example.api_spring_book.dto.AuthorDTO
import com.example.api_spring_book.repository.AuthorRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImplmentation(val authorRepository: AuthorRepository) : AuthorService {

    // require throws an IllegalArgumentException when the value passed to it resolves to false.
    override fun saveAuthor(authorEntity: AuthorEntity): AuthorEntity {
        require(null == authorEntity.id)
        return authorRepository.save(authorEntity)
    }

    override fun fetchAuthors(authorName: String?): List<AuthorDTO> {
        val authors = authorName?.let {
            authorRepository.findAuthorByName(authorName)
        } ?: authorRepository.findAll()

        return authors.map { it ->
            AuthorDTO(it!!.id, it.name, it.age, it.image, it.description)
        }
    }

    override fun fetchAllLists(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun deleteAuthor(id: Long) {
        authorRepository.deleteById(id)
    }

    override fun getAuthorByID(id: Long): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }
    // @Transactional use this annotation in our service layer when we make multiple calls to our persistence layer in the same function
    @Transactional
    override fun fullUpdateAuthor(id: Long, authorEntity: AuthorEntity): AuthorEntity {
        check(authorRepository.existsById(id))
        val normalizedAuthor = authorEntity.copy(id = id)
        return authorRepository.save(normalizedAuthor)
    }

}