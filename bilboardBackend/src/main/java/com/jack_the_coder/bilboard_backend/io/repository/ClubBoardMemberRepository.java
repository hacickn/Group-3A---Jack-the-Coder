package com.jack_the_coder.bilboard_backend.io.repository;

import com.jack_the_coder.bilboard_backend.io.entity.ClubBoardMemberEntity;
import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hacı Çakın
 * @apiNote This class provides communication between databases and related class(basically for the queries)
 * @since 22.11.2021
 */
@Repository
public interface ClubBoardMemberRepository extends JpaRepository<ClubBoardMemberEntity, Long> {
    ClubBoardMemberEntity findByClubAndUser ( ClubEntity clubEntity , UserEntity userEntity );
}
