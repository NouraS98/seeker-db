package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.entity.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper extends BaseMapper<Contract, ContractDto>{

}


