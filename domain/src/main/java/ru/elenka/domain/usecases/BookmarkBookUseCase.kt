package ru.elenka.domain.usecases

import ru.elenka.domain.entities.Volume
import ru.elenka.domain.repositories.BooksRepository

class BookmarkBookUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(book: Volume) = booksRepository.bookmark(book)
}