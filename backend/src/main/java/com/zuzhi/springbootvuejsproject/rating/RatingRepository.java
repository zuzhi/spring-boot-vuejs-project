package com.zuzhi.springbootvuejsproject.rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * RatingRepository
 *
 * @author zuzhi
 * @date 14/03/2018
 */
interface RatingRepository extends JpaRepository<Rating, Long> {
    /**
     * Returns all ratings with the given book id
     *
     * @param bookId book id
     * @return all ratings with the given book id
     */
    List<Rating> findRatingsByBookId(Long bookId);
}
