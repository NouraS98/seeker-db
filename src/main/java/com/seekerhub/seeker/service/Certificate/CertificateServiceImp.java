package com.seekerhub.seeker.service.Certificate;

import com.seekerhub.seeker.dto.Certificate.CertificateDto;
import com.seekerhub.seeker.entity.Certificate;
import com.seekerhub.seeker.mapper.CertificateMapper;
import com.seekerhub.seeker.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImp implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    CertificateMapper certificateMapper;

    @Override
    public CertificateDto save(CertificateDto certificateDto) {
        Certificate certificate = certificateMapper.toEntity(certificateDto);
        Certificate certificateToSave = certificateRepository.save(certificate);
        return certificateMapper.toDto(certificateToSave);
    }

    @Override
    public List<CertificateDto> findAll() {
        return certificateMapper.toDtos(certificateRepository.findAll());
    }

    @Override
    public CertificateDto findById(long id) {
        return certificateMapper.toDto(certificateRepository.getOne(id));
    }
}
