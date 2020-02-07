package com.seekerhub.seeker.service.Certificate;

import com.seekerhub.seeker.dto.Certificate.CertificateDto;

import java.util.List;

public interface CertificateService {
    CertificateDto save(CertificateDto certificateDto);
    List<CertificateDto> findAll();
    CertificateDto findById(long id);
}
