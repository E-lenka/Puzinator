package ru.elenka.domain.usecases

import ru.elenka.domain.repositories.BooksRepository

class GetBookmarksUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke() = booksRepository.getBookmarks()
}