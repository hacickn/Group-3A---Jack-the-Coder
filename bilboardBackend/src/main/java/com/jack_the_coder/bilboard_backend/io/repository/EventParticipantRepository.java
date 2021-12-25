package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.EventParticipantEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 22.11.2021
 */
@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipantEntity, Long> {

    Optional<EventParticipantEntity> findByUserAndEvent ( UserEntity userEntity , EventEntity eventEntity );

}
