package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
