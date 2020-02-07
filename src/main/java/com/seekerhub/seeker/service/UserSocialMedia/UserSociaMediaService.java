package com.seekerhub.seeker.service.UserSocialMedia;


import com.seekerhub.seeker.dto.user.UserSocialMediaDto;

import java.util.List;

public interface UserSociaMediaService{
    UserSocialMediaDto save(UserSocialMediaDto userSocialMediaDto);
    List<UserSocialMediaDto> findAll();
    UserSocialMediaDto findById(long id);

}
