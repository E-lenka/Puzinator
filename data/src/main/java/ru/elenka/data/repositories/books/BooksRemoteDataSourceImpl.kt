package ru.elenka.data.repositories.books

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.elenka.data.api.BooksApi
import ru.elenka.data.mappers.BookApiResponseMapper
import ru.elenka.domain.common.Result
import ru.elenka.domain.entities.Volume

class BooksRemoteDataSourceImpl(
    private val service: BooksApi,
    private val mapper: BookApiResponseMapper
) : BooksRemoteDataSource {
    override suspend fun getBooks(author: String): Result<List<Volume>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getBooks(author)
                if (response.isSuccessful) {
                    return@withContext Result.Success(mapper.toVolumeList(response.body()!!))
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
}