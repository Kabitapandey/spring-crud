package com.internship.books.payload;

public class ApiResponse {
    private String msg;

    private int status;

    public ApiResponse(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }
}
