package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Admin.AdminDto;
import com.seekerhub.seeker.entity.Admin;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AdminMapper extends BaseMapper<Admin, AdminDto>{

}