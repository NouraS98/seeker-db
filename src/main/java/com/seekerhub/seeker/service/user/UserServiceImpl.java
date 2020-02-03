package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.mapper.UserMapper;
import com.seekerhub.seeker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //هو يسوي انيشييت للكلاس مو كل مره اسوي نيو
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private FreelancerService freelancerService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserDto userdto) {
        User user = userMapper.toEntity(userdto);
        User userToSave = userRepository.save(user);

        return userMapper.toDto(userToSave);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public UserDto findById(long id) {
        return userMapper.toDto(userRepository.getOne(id));
    }

    @Override
    public UserDto findByUsername(String username) {

        return userMapper.toDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User userToSave = userRepository.save(user);
        if(userToSave.getRoles().stream().anyMatch(role -> role.getRole().equals("Employee"))){
            EmployerDto employerDto = EmployerDto.builder().user(userMapper.toDto(userToSave)).build();
            employerService.save(employerDto);
        }else{
            FreelancerDto freelancerDto = FreelancerDto.builder().user(userMapper.toDto(userToSave)).build();
             freelancerService.save(freelancerDto);
        }
        return userMapper.toDto(userToSave);
    }
}
