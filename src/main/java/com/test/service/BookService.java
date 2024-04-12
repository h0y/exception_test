package com.test.service;

import com.test.entity.Book;
import com.test.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private static final Map<Integer, Book> bookRepo = new HashMap<>();

    static {
        Book book = new Book(1, "Math", "Author");
        bookRepo.put(book.getId(), book);
    }

    public Book getBookById(Integer id) {
        Book book = bookRepo.get(id);
        if (book == null) {
            // 在业务逻辑代码中，可以根据实际情况主动抛出自定义异常
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        return book;
    }
}
