package community.flock.demo.todo.configuration

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@PropertySource("classpath:postgres.properties")
@EnableR2dbcRepositories("community.flock.demo.todo.todo")
class DatabaseConfig(
    @Value("\${database.host}") private val host: String,
    @Value("\${database.port}") private val port: Int,
    @Value("\${database.username}") private val username: String,
    @Value("\${database.password:''}") private val password: String,
    @Value("\${database.database}") private val database: String
) : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory = PostgresqlConnectionFactory(
        PostgresqlConnectionConfiguration.builder()
            .host(host)
            .port(port)
            .username(username)
            .password(password)
            .database(database)
            .build()
    )

}
