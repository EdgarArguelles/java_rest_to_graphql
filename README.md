Rest to Graphql
===============

Basic example showing how to migrate REST to GraphQL using [GraphQL SPQR](https://github.com/leangen/graphql-spqr)

# Stack:
- Gradle
- Spring Boot
- Spring Data
- GraphQL SPQR
- Project Lombok

# Migration Steps:
- Add io.leangen.graphql:graphql-spqr-spring-boot-starter dependency to Gradle
- Add @GraphQLApi annotation to Services that contains @GraphQLQuery and/or @GraphQLMutation
- Add @GraphQLQuery or @GraphQLMutation annotation to Service's functions
- Add @GraphQLType annotation to Models
- Add graphql.spqr.gui.enabled=true to application.properties (enable GUI editor http://localhost:8080/gui)

# Run
    ./gradlew bootRun
    
# GraphQL GUI
    http://localhost:8080/gui