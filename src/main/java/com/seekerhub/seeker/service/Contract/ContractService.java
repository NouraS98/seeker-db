package com.seekerhub.seeker.service.Contract;

import com.seekerhub.seeker.dto.Certificate.CertificateDto;
import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Contract;

import java.util.List;

public interface ContractService {
    ContractDto save(ContractDto contractDto);
    List<ContractDto> findAll();
    ContractDto findById(long id);
    ContractDto findByProjectId(long project_id);
    List<ProjectDto> findByFreelancerId(long id);

    void updateStatus(Long projectId, String status);
}
