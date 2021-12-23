package com.jack_the_coder.bilboard_backend.io.repository;


import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 09.11.2021
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    UserEntity findByEmail ( String email );
    UserEntity findUserByEmailConfirmationToken ( String token );
    UserEntity findByBilkentId ( String bilkentId );
    List<UserEntity> findByNameContainsAndType ( String name , UserEntity.UserTypes userTypes );
}
