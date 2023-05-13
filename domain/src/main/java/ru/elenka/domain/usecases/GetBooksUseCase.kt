package ru.elenka.domain.usecases

import ru.elenka.domain.repositories.BooksRepository

class GetBooksUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(author: String) = booksRepository.getRemoteBooks(author)
}