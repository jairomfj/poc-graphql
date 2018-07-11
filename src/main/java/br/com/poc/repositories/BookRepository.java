package br.com.poc.repositories;

import br.com.poc.types.Book;

import java.util.List;

import static java.util.Collections.singletonList;

public class BookRepository {

    public List<Book> list() {
        return singletonList(new Book(1, "Clean Code", 1));
    }

}