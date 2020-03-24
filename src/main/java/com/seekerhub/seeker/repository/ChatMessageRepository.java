package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Chat;
import com.seekerhub.seeker.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
