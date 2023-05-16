package ru.elenka.data.repositories.books

import ru.elenka.domain.common.Result
import ru.elenka.domain.entities.Volume

interface BooksRemoteDataSource {
    suspend fun getBooks(author: String): Result<List<Volume>>
}