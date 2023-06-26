# kgrapql-ktor-server

## Technologies used
* Kotlin
* Gradle
* Ktor
* JDK 17
* GraphQL


#### Build and run tests
To build locally and run the integration tests you can simply run `./gradlew clean build` or on windows
`gradlew.bat clean build`

## Run the main class in your favourite IDE(Intellij)
Go to src/main/kotlin/io/github/mikaojk/Application.kt and run it

## Testing the login endpoint locally
Open a web browser and go to this side http://localhost:8080/graphql

Example query
```
// query for hero from episode JEDI and take id, name for any Character, and primaryFunction for Droid or height for Human
{
  hero(episode: JEDI) {
    id
    name
    ... on Droid {
      primaryFunction
    }
    ... on Human {
      height
    }
  }
}
```

### Upgrading the gradle wrapper
Find the newest version of gradle here: https://gradle.org/releases/ Then run this command:

```./gradlew wrapper --gradle-version $gradleVersjon```

## Inquiries
Questions related to the code or project can be asked as issues here on GitHub.