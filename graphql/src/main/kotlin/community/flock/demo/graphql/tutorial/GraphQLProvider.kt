package community.flock.demo.graphql.tutorial

import graphql.GraphQL
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeRuntimeWiring.newTypeWiring
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


@Component
class GraphQLProvider(
        val graphQLDataFetchers: GraphQLDataFetchers
) {

    @Bean
    fun graphQL(): GraphQL {
        val sdl: String = GraphQLProvider::class.java.getResource("/schema.graphqls").readText(Charsets.UTF_8)
        val graphQLSchema = buildSchema(sdl)
        return GraphQL.newGraphQL(graphQLSchema).build()
    }



    private fun buildSchema(sdl: String): GraphQLSchema {
        val typeRegistry = SchemaParser().parse(sdl)
        val runtimeWiring = buildWiring()
        val schemaGenerator = SchemaGenerator()
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring)
    }

    private fun buildWiring(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query").dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                .type(newTypeWiring("Book").dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .build()
    }

}

