package com.internship.books.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException() {
        super("Author assigned to the book cannot be deleted");
    }
}
