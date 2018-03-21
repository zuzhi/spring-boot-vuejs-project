package com.zuzhi.backend.rating;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RatingNotFoundException
 *
 * @author zuzhi
 * @date 14/03/2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class RatingNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 518040114997784430L;

    RatingNotFoundException(String message) {
        super(message);
    }
}
