package com.seekerhub.seeker.service.Admin;

import com.seekerhub.seeker.dto.Admin.AdminDto;

import java.util.List;

public interface AdminService {

    AdminDto save(AdminDto adminDto);
    List<AdminDto> findAll();
    AdminDto findById(long id);


}
