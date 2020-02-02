package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.role.RoleDto;
import com.seekerhub.seeker.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDto> {
}
