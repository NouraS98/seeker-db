package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import javassist.bytecode.ByteArray;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService<list> {
    UserDto save(UserDto userdto);
    List<UserDto> findAll();
    UserDto findById(long id);
    UserDto findByUsername(String username);
    UserDto findByEmail (String email);


    UserDto register(UserForRegisterDto userDto);

    void uploadAvatar(MultipartFile file);
   void resetUserPassword(Long id, String password);

    void setPhone(long id, String phone_number);
    void setNationalId(long id, String national_id);

    void setTwitter(long id, String twitter);
    void setLinkedin(long id, String linkedIn);
    void setFacebook(long id, String facebook);
    void setEducation(long id, String education);

    String getLinkedInById(long id);
    String getTwitterById(long id);
    String getLFacebookById(long id);
    String getEducationById(long id);

    String getPhoneNumber(long id);
    String getNationalId(long id);

    void setImg(long id, byte[] img);

    List<String> getAllForTrustPoints(long id);

    int calcEmpTP(long id);
    int calcFrTP(long id);


    UserDto updateToken(String token, Long id);

}
