package br.com.poc.types;

import br.com.poc.repositories.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public Query(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> books() {
        return bookRepository.list();
    }

}