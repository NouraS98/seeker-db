package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Certificate.CertificateDto;
import com.seekerhub.seeker.entity.Certificate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificateMapper extends BaseMapper<Certificate, CertificateDto>{

}


