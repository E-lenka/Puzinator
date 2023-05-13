package ru.elenka.domain.usecases

import ru.elenka.domain.entities.Volume
import ru.elenka.domain.repositories.BooksRepository

class UnbookmarkBookUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(book: Volume) = booksRepository.unbookmark(book)
}