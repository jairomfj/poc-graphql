package br.com.poc.resolvers;

import br.com.poc.types.Author;
import br.com.poc.repositories.AuthorRepository;
import br.com.poc.types.Book;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author author(Book book) {
        return authorRepository.getAuthorById(book.getAuthorId());
    }

}