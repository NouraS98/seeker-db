package com.seekerhub.seeker.repository;


import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByTokenAndActiveTrue(String token);

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
