package ru.elenka.data.mappers

import ru.elenka.data.api.BooksApiResponse
import ru.elenka.domain.entities.Volume
import ru.elenka.domain.entities.VolumeInfo


class BookApiResponseMapper {
    fun toVolumeList(response: BooksApiResponse): List<Volume> {
        return response.items.map {
            Volume(
                it.id, VolumeInfo(
                    it.volumeInfo.title,
                    it.volumeInfo.authors,
                    it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
                )
            )
        }
    }
}