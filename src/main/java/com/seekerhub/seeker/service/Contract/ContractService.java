package com.seekerhub.seeker.service.Contract;

import com.seekerhub.seeker.dto.Certificate.CertificateDto;
import com.seekerhub.seeker.dto.Contract.ContractDto;

import java.util.List;

public interface ContractService {
    ContractDto save(ContractDto contractDto);
    List<ContractDto> findAll();
    ContractDto findById(long id);
}
