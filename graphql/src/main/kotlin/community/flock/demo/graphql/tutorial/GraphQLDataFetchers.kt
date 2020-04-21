package community.flock.demo.graphql.tutorial

import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component


@Component
class GraphQLDataFetchers {

    fun getPageCountDataFetcher(): DataFetcher<*>? {
        return DataFetcher { dataFetchingEnvironment: DataFetchingEnvironment ->
            val book = dataFetchingEnvironment.getSource<Map<String, String>>()
            book["totalPages"]
        }
    }

    fun getBookByIdDataFetcher(): (DataFetchingEnvironment) -> Map<String, String> {
        return { dataFetchingEnvironment: DataFetchingEnvironment ->
            val bookId: String = dataFetchingEnvironment.getArgument("id")
            books.first { it["id"] == bookId }
        }
    }

    fun getAuthorDataFetcher(): (DataFetchingEnvironment) -> Map<String, String> {
        return { dataFetchingEnvironment: DataFetchingEnvironment ->
            val book: Map<String, String> = dataFetchingEnvironment.getSource()
            val authorId: String? = book["authorId"]
            authors.first { it["id"] == authorId }
        }
    }

    companion object {
        private val books: List<Map<String, String>> = listOf(
                mapOf(
                        "id" to "book-1",
                        "name" to "Harry Potter and the Philosopher's Stone",
                        "pageCount" to "223",
                        "authorId" to "author-1"),
                mapOf(
                        "id" to "book-2",
                        "name" to "Moby Dick",
                        "pageCount" to "635",
                        "authorId" to "author-2"),
                mapOf(
                        "id" to "book-3",
                        "name" to "Interview with the vampire",
                        "pageCount" to "371",
                        "authorId" to "author-3")
        )
        private val authors: List<Map<String, String>> = listOf(
                mapOf(
                        "id" to "author-1",
                        "firstName" to "Joanne",
                        "lastName" to "Rowling"),
                mapOf(
                        "id" to "author-2",
                        "firstName" to "Herman",
                        "lastName" to "Melville"),
                mapOf(
                        "id" to "author-3",
                        "firstName" to "Anne",
                        "lastName" to "Rice")
        )
    }
}
