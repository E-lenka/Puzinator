package ru.elenka.data.repositories.books

import ru.elenka.domain.entities.Volume
import ru.elenka.domain.common.Result

interface BooksRemoteDataSource {
    suspend fun getBooks(author: String): Result<List<Volume>>
}