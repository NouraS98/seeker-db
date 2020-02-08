package com.seekerhub.seeker.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSocialMediaDto {
    private long id;
    private String twitter;
    private String facebook;
    private String linkedIn;

}
