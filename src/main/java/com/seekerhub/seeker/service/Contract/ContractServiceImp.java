package com.seekerhub.seeker.service.Contract;

import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Contract;
import com.seekerhub.seeker.mapper.ContractMapper;
import com.seekerhub.seeker.mapper.ProjectMapper;
import com.seekerhub.seeker.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImp implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    ProjectMapper projectMapper;
    @Override
    public ContractDto save(ContractDto contractDto) {
        Contract contract = contractMapper.toEntity(contractDto);
        Contract contractToSave = contractRepository.save(contract);
        return contractMapper.toDto(contractToSave);
    }

    @Override
    public List<ContractDto> findAll() {
        return contractMapper.toDtos(contractRepository.findAll());
    }

    @Override
    public ContractDto findById(long id) {
        return contractMapper.toDto(contractRepository.getOne(id));
    }

    @Override
    public ContractDto findByProjectId(long project_id) {
        return contractMapper.toDto(contractRepository.findByProjectId(project_id));
    }

    @Override
    public List<ProjectDto> findByFreelancerId(long id) {
        return projectMapper.toDtos(contractRepository.findByFreelanerId(id));
    }

    @Override
    public void updateStatus(Long projectId, String status) {
        Contract contract = contractRepository.findByProjectId(projectId);
        contract.setType("1");
        contractRepository.save(contract);
    }
}
