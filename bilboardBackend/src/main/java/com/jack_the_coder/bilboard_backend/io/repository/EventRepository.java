package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 11.11.2021
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findFirst10ByDateAfter ( Date date );

    Optional<EventEntity> findByEventCode ( String eventCode );
}
