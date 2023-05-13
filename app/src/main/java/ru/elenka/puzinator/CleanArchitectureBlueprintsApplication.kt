package ru.elenka.puzinator

import android.app.Application
import ru.elenka.puzinator.di.ServiceLocator
import ru.elenka.puzinator.mappers.BookWithStatusMapper
import ru.elenka.data.repositories.books.BooksRepositoryImpl
import ru.elenka.domain.usecases.BookmarkBookUseCase
import ru.elenka.domain.usecases.GetBookmarksUseCase
import ru.elenka.domain.usecases.GetBooksUseCase
import ru.elenka.domain.usecases.UnbookmarkBookUseCase

import timber.log.Timber

class CleanArchitectureBlueprintsApplication : Application() {
    private val booksRepository: BooksRepositoryImpl
        get() = ServiceLocator.provideBooksRepository(this)

    val getBooksUseCase: GetBooksUseCase
        get() = GetBooksUseCase(booksRepository)

    val getBookmarksUseCase: GetBookmarksUseCase
        get() = GetBookmarksUseCase(booksRepository)

    val bookmarkBooksUseCase: BookmarkBookUseCase
        get() = BookmarkBookUseCase(booksRepository)

    val unbookmarkBookUseCase: UnbookmarkBookUseCase
        get() = UnbookmarkBookUseCase(booksRepository)

    val bookWithStatusMapper = BookWithStatusMapper()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}