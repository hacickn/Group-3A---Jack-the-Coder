package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hacı Çakın
 * @since  09.11.2021
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 */
public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Long> {
}
