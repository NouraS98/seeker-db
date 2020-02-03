package com.seekerhub.seeker.dto.user;

import com.seekerhub.seeker.dto.role.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForRegisterDto implements Serializable {

    private String username;
    private String password;
    private Set<RoleDto> roles;
    private String email;
    private String phone_number;
    private String national_id;
    private String rating;

}
