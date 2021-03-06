package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.UserSocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSocialMediaRepository extends JpaRepository<UserSocialMedia, Long> {


}