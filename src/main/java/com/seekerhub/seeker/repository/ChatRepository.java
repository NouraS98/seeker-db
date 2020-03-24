package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

   // List<Chat> findByFirstUserId(long user1_id);
    List<Chat> findByFirstUserIdOrSecondUserId(long user1_id, long user2_id);
}