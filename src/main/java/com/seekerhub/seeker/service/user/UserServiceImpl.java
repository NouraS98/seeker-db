package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.StorageDocument;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.enums.RoleEnum;
import com.seekerhub.seeker.enums.StorageEnum;
import com.seekerhub.seeker.exception.ApiError;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.UserMapper;
import com.seekerhub.seeker.model.FileUpload;
import com.seekerhub.seeker.repository.UserRepository;
import com.seekerhub.seeker.service.employer.EmployerService;
import com.seekerhub.seeker.service.freelancer.FreelancerService;
import com.seekerhub.seeker.service.upload.UploadService;
import com.seekerhub.seeker.utils.SecurityUtils;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${app.file-upload.avatar}")
    private String AVATAR_SPACE_NAME;

    //هو يسوي انيشييت للكلاس مو كل مره اسوي نيو
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private FreelancerService freelancerService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UploadService uploadService;

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

        if (userRepository.existsById(id))
            throw new GenericException("User was not found");

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
    @Transactional
    public UserDto register(UserForRegisterDto userDto) {

        List<ApiError> errors = new ArrayList<>();

        if (userRepository.existsByUsername(userDto.getUsername()))
            errors.add(ApiError.builder().field("username").message("Username already exists").build());

        if (userRepository.existsByEmail(userDto.getEmail()))
            errors.add(ApiError.builder().field("email").message("Email already exists").build());

        if (errors.size() > 0)
            throw new GenericException("User already exists", errors);

        User user = userMapper.toEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCurrent_type(RoleEnum.FREELANCER);
        User userToSave = userRepository.save(user);

        EmployerDto employerDto = EmployerDto.builder().user(userMapper.toDto(userToSave)).build();
        employerService.save(employerDto);

        FreelancerDto freelancerDto = FreelancerDto.builder().user(userMapper.toDto(userToSave)).build();
        freelancerService.save(freelancerDto);

        return userMapper.toDto(userToSave);
    }

    @Override
    public void uploadAvatar(MultipartFile file) {

        // Getting current logged in user
        String email = SecurityUtils.getCurrentUserLogin();
        User user = userRepository.findByEmail(email);

        // Setting key for storage: avatar + user Id to make it unique for every user
        String key = "avatar_" + user.getId();

        // Setting file name
        String name = file.getOriginalFilename();

        try {
            // Upload avatar to Avatar Space (DigitalOcean)
            FileUpload fileUpload = uploadService.upload(AVATAR_SPACE_NAME, key, file);

            // If upload is successful, then create new Storage Document Entity with type AVATAR and set user avatar and save user.
            if (fileUpload.isSuccess()) {
                StorageDocument storageDocument = new StorageDocument(key, name, StorageEnum.AVATAR, fileUpload.getUrl(), file.getContentType());
                user.setAvatar(storageDocument);
                userRepository.save(user);
            } else {
                throw new GenericException("Could not upload avatar");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GenericException("Could not upload avatar");
        }
    }
}
