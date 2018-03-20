package com.zuzhi.springbootvuejsproject.rating;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Rating
 *
 * @author zuzhi
 * @date 13/03/2018
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating implements Serializable {

    private static final long serialVersionUID = -1975989961325317426L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Integer stars;

    public Rating() {
    }

    public Rating(Long id, Long bookId, Integer stars) {
        this.id = id;
        this.bookId = bookId;
        this.stars = stars;
    }

    public Rating(Long bookId, Integer stars) {
        this.bookId = bookId;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
