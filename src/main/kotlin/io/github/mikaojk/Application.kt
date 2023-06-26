package io.github.mikaojk

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.KGraphQL.Companion.schema
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import io.github.mikaojk.model.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.mikaojk.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(GraphQL) {
        configureRouting()
        playground = true
        schema {
            startWarsSchema()
        }
    }

}

fun SchemaBuilder.startWarsSchema() {
        // create query "hero" which returns instance of Character
        query("hero") {
            resolver { episode: Episode ->
                when (episode) {
                    Episode.NEWHOPE, Episode.JEDI -> r2d2
                    Episode.EMPIRE -> luke
                }
            }
        }

        // create query "heroes" which returns list of luke and r2d2
        query("heroes") {
            resolver { -> listOf(luke, r2d2) }
        }
        type<Droid>()
        type<Human>()
        enum<Episode>()
}