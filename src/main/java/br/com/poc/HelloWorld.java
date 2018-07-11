package br.com.poc;

import br.com.poc.repositories.AuthorRepository;
import br.com.poc.repositories.BookRepository;
import br.com.poc.resolvers.BookResolver;
import br.com.poc.types.Query;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

import java.util.LinkedHashMap;

public class HelloWorld {

    public static void main(String[] args) {
        final GraphQL graphQL = getGraphQL();

        ExecutionResult result = graphQL.execute("{ books { id author { id } } }");
        LinkedHashMap book = result.getData();

        System.out.println(book);
    }

    private static GraphQL getGraphQL() {
        final GraphQLSchema schema = SchemaParser.newParser()
                .file("my-schema.graphqls")
                .resolvers(new Query(new BookRepository()), new BookResolver(new AuthorRepository()))
                .build()
                .makeExecutableSchema();

        return GraphQL
                .newGraphQL(schema)
                .build();
    }

}