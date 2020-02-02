package com.seekerhub.seeker.dto.user;

import com.seekerhub.seeker.dto.role.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

//JSON هذا اللي بيرجع
//password بينشال
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private long id;
    private String username;
    private String password;
    private Set<RoleDto> roles;
    private String email;
    private String phone_number;
    private String national_id;
    private String rating;

}
