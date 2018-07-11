package br.com.poc.repositories;

import br.com.poc.types.Author;

import java.util.Collections;
import java.util.List;

public class AuthorRepository {

    private List<Author> authors = Collections.singletonList(new Author(1, "Robert Cecil Martin"));

    public Author getAuthorById(int id) {
        return authors.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

}