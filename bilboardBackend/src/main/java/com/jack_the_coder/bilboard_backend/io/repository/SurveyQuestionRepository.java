package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.SurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 11.12.2021
 */
@Repository
public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestionEntity, Long> {
}
