package com.zuzhi.springbootvuejsproject.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BookNotFoundException
 *
 * @author zuzhi
 * @date 14/03/2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 156657220149134052L;

    BookNotFoundException(String message) {
        super(message);
    }
}
