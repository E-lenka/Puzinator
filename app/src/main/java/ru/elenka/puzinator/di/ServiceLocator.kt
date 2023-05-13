package ru.elenka.puzinator.di

import android.content.Context

import kotlinx.coroutines.Dispatchers
import ru.elenka.puzinator.BuildConfig
import ru.elenka.data.api.NetworkModule
import ru.elenka.data.db.BooksDatabase
import ru.elenka.data.mappers.BookApiResponseMapper
import ru.elenka.data.mappers.BookEntityMapper
import ru.elenka.data.repositories.books.BooksLocalDataSource
import ru.elenka.data.repositories.books.BooksLocalDataSourceImpl
import ru.elenka.data.repositories.books.BooksRemoteDataSourceImpl
import ru.elenka.data.repositories.books.BooksRepositoryImpl

object ServiceLocator {
    private var database: BooksDatabase? = null
    private val networkModule by lazy {
        NetworkModule()
    }
    private val bookEntityMapper by lazy {
        BookEntityMapper()
    }

    @Volatile
    var booksRepository: BooksRepositoryImpl? = null

    fun provideBooksRepository(context: Context): BooksRepositoryImpl {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return booksRepository ?: createBooksRepository(context)
        }
    }

    private fun createBooksRepository(context: Context): BooksRepositoryImpl {
        val newRepo =
            BooksRepositoryImpl(
                createBooksLocalDataSource(context),
                BooksRemoteDataSourceImpl(
                    networkModule.createBooksApi(BuildConfig.GOOGLE_APIS_ENDPOINT),
                    BookApiResponseMapper()
                )
            )
        booksRepository = newRepo
        return newRepo
    }

    private fun createBooksLocalDataSource(context: Context): BooksLocalDataSource {
        val database = database ?: createDataBase(context)
        return BooksLocalDataSourceImpl(
            database.bookDao(),
            Dispatchers.IO,
            bookEntityMapper
        )
    }

    private fun createDataBase(context: Context): BooksDatabase {
        val result = BooksDatabase.getDatabase(context)
        database = result
        return result
    }
}