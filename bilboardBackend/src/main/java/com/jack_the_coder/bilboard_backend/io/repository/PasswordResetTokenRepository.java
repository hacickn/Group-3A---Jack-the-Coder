package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.PasswordResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 14.12.2021
 */
@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenEntity, Long> {
    PasswordResetTokenEntity findByToken ( String token );
}
