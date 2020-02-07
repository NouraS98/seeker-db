package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.user.UserSocialMediaDto;
import com.seekerhub.seeker.entity.UserSocialMedia;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserSocialMediaMapper extends BaseMapper<UserSocialMedia, UserSocialMediaDto>{

}