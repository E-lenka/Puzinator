package ru.elenka.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.elenka.domain.common.Result
import ru.elenka.domain.entities.Volume

interface BooksRepository {

    suspend fun getRemoteBooks(author: String): Result<List<Volume>>

    suspend fun getBookmarks(): Flow<List<Volume>>

    suspend fun bookmark(book: Volume)

    suspend fun unbookmark(book: Volume)
}