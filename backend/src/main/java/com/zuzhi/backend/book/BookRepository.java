package com.zuzhi.backend.book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookRepository
 *
 * @author zuzhi
 * @date 13/03/2018
 */
interface BookRepository extends JpaRepository<Book, Long> {
}
