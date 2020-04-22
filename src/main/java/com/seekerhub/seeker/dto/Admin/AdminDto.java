package com.seekerhub.seeker.dto.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private long id;
    private String username;
    private String password;
    private String email;

}
