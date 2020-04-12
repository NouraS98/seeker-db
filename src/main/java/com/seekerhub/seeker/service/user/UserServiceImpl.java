package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.entity.StorageDocument;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.entity.UserSocialMedia;
import com.seekerhub.seeker.enums.RoleEnum;
import com.seekerhub.seeker.enums.StorageEnum;
import com.seekerhub.seeker.exception.ApiError;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.StorageMapper;
import com.seekerhub.seeker.mapper.UserMapper;
import com.seekerhub.seeker.model.FileUpload;
import com.seekerhub.seeker.repository.UserRepository;
import com.seekerhub.seeker.security.PrivateKeyImpl;
import com.seekerhub.seeker.service.employer.EmployerService;
import com.seekerhub.seeker.service.freelancer.FreelancerService;
import com.seekerhub.seeker.service.upload.UploadService;
import com.seekerhub.seeker.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    StorageMapper storageMapper;

    @Value("${app.file-upload.work}")
    private  String WORK_SPACE_NAME;

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

        if (!userRepository.existsById(id))
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

        try {
            userDto.setPassword(PrivateKeyImpl.decryptMessage(userDto.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public StorageDocumentDto uploadAvatar(Long id,MultipartFile file) {

        if (!userRepository.existsById(id))
            throw new GenericException("User doesn't exist");

        User user = userRepository.getOne(id);

        String key = "avatar_" + user.getId() + "_" + (new Date().getTime());


        // Setting file name
        String name = file.getOriginalFilename();

        try {
            // Upload avatar to Avatar Space (DigitalOcean)
            FileUpload fileUpload = uploadService.upload(AVATAR_SPACE_NAME, key, file);

            // If upload is successful, then create new Storage Document Entity with type AVATAR and set user avatar and save user.
            if (fileUpload.isSuccess()) {
                StorageDocument storageDocument = new StorageDocument(key, name, StorageEnum.AVATAR, fileUpload.getUrl(), file.getContentType());
                user.setAvatar(storageDocument);

                User userToSave  = userRepository.save(user);

                return storageMapper.toDto(userToSave.getAvatar());
            } else {
                throw new GenericException("Could not upload avatar");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GenericException("Could not upload avatar");
        }
    }

    @Override
    public void deleteSampleWorkById(long id, long attachmentId) {
        if (!userRepository.existsById(id))
            throw new GenericException("user doesn't exist");

        User user = userRepository.getOne(id);
        Optional<StorageDocument> storageDocumentToDelete = user.getSampleWorks().stream().filter(storageDocument -> storageDocument.getId() == attachmentId).findFirst();
        if (!storageDocumentToDelete.isPresent()) {
            throw new GenericException("Attachment doesn't exist");
        }
        user.getSampleWorks().remove(storageDocumentToDelete.get());
        userRepository.save(user);
    }

    @Override
    public StorageDocumentDto addSampleWork(long id, MultipartFile file) {
        if (!userRepository.existsById(id))
            throw new GenericException("user doesn't exist");

        User user = userRepository.getOne(id);

        String key = "work_" + user.getId() + "_" + (new Date().getTime());


        // Setting file name
        String name = file.getOriginalFilename();

        try {
            // Upload avatar to Avatar Space (DigitalOcean)
            FileUpload fileUpload = uploadService.upload(WORK_SPACE_NAME, key, file);

            // If upload is successful, then create new Storage Document Entity with type AVATAR and set user avatar and save user.
            if (fileUpload.isSuccess()) {
                StorageDocument storageDocument = new StorageDocument(key, name, StorageEnum.WORK, fileUpload.getUrl(), file.getContentType());
                user.getSampleWorks().add(storageDocument);
                User userToSave = userRepository.save(user);

                return storageMapper.toDto(userToSave.getSampleWorks().get(userToSave.getSampleWorks().size() - 1));
            } else {
                throw new GenericException("Could not upload work");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GenericException("Could not upload work");
        }

    }

    @Override
    public UserDto updateToken(String token, Long id) {
        User user = userRepository.getOne(id);
        user.setToken_id(token);
        UserDto userDto = userMapper.toDto(userRepository.save(user));
        return userDto;
    }


    @Override
    public void resetUserPassword(Long id, String password) {
        if (!userRepository.existsById(id))
            throw new GenericException("User doesn't exist");

        User user = userRepository.getOne(id);
        user.setPassword(bCryptPasswordEncoder.encode(password));
       // user.setPassword(password);
        userRepository.save(user);
    }


    //New by hind.
    @Override
    public UserDto setPhone(long id, String phone_number) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setPhone_number(phone_number);
        userRepository.save(user);

        return userMapper.toDto(user);

    }


    @Override
    public UserDto setNationalId(long id, String national_id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setNational_id(national_id);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto setTwitter(long id, String twitter) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setTwitter(twitter);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto setLinkedin(long id, String linkedIn) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setLinkedIn(linkedIn);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto setFacebook(long id, String facebook) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setFacebook(facebook);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public String getLinkedInById(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

       return user.getLinkedIn();

    }

    @Override
    public String getTwitterById(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        return user.getTwitter();
    }

    @Override
    public String getLFacebookById(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        return user.getFacebook();

    }

    @Override
    public UserDto setEducation(long id, String education) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setEducation(education);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public String getEducationById(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        return user.getEducation();
    }

    @Override
    public void setImg(long id, byte[] img) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        user.setImg(img);
        userRepository.save(user);

    }


    @Override
    public String getPhoneNumber(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        return user.getPhone_number();
    }

    @Override
    public String getNationalId(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        return user.getNational_id();
    }

    @Override
    public List<String> getAllForTrustPoints(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        List<String> list = new ArrayList<>();
        list.add(user.getNational_id());
        list.add(user.getPhone_number());
        list.add(user.getLinkedIn());
        list.add(user.getTwitter());
        list.add(user.getFacebook());

        return list;

    }

    @Override
    public int calcEmpTP(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        int totalEmployerTrustPoints = 0;

        //Add 5 for the email
        totalEmployerTrustPoints+= 5;

        if (user.getNational_id() != null)
            totalEmployerTrustPoints+= 40;

        if (user.getPhone_number() != null)
            totalEmployerTrustPoints+= 20;

        if (user.getLinkedIn() != null)
            totalEmployerTrustPoints+= 5;

        if (user.getTwitter() != null)
            totalEmployerTrustPoints+= 5;

        if (user.getFacebook() != null)
            totalEmployerTrustPoints+= 5;

        return totalEmployerTrustPoints;
    }

    @Override
    public int calcFrTP(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        int totalFreelancerTrustPoints = 0;

        //Add 5 for the email
        totalFreelancerTrustPoints+= 5;

        if (user.getNational_id() != null)
            totalFreelancerTrustPoints+= 40;

        if (user.getPhone_number() != null)
            totalFreelancerTrustPoints+= 20;

        if (user.getFreelancer().getMaarof_account() != null)
            totalFreelancerTrustPoints+= 20;

        if (user.getLinkedIn() != null)
            totalFreelancerTrustPoints+= 5;

        if (user.getTwitter() != null)
            totalFreelancerTrustPoints+= 5;

        if (user.getFacebook() != null)
            totalFreelancerTrustPoints+= 5;

        return totalFreelancerTrustPoints;
    }

    @Override
    public void setType(long id) {
        if(!userRepository.existsById(id))
            throw new GenericException("The user was not found");
        User user = userRepository.getOne(id);

        if (user.getCurrent_type().equals(RoleEnum.FREELANCER))
        user.setCurrent_type(RoleEnum.EMPLOYER);
        else
            user.setCurrent_type(RoleEnum.FREELANCER);
        userRepository.save(user);

    }

    @Override
    public void deleteUserById(long id) {
        if (!userRepository.existsById(id))
            throw new GenericException("User doesn't exist");

        userRepository.deleteById(id);
    }
}

















