package com.jack_the_coder.bilboard_backend.io.repository;


import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hacı Çakın
 * @since  09.11.2021
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @implNote After completing relations, getters and setters should be implemented
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
}
