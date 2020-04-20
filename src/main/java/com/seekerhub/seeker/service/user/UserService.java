package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.entity.VerificationToken;
import javassist.bytecode.ByteArray;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService<list> {
    UserDto save(UserDto userdto);
    List<UserDto> findAll();
    UserDto findById(long id);
    UserDto findByUsername(String username);
    UserDto findByEmail (String email);

    String changeIsEnabled(long id);

    UserDto register(UserForRegisterDto userDto);

    StorageDocumentDto uploadAvatar(Long id,MultipartFile file);

    void deleteSampleWorkById(long id, long attachmentId);

    StorageDocumentDto addSampleWork(long id, MultipartFile attachment);


    void resetUserPassword(Long id, String password);

    UserDto setPhone(long id, String phone_number);
    UserDto setNationalId(long id, String national_id);

    UserDto setTwitter(long id, String twitter);
    UserDto setLinkedin(long id, String linkedIn);
    UserDto setFacebook(long id, String facebook);
    UserDto setEducation(long id, UserDto education);

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

    void setType(long id);

    void deleteUserById(long id);
    void createVerificationToken(User user, String token, TokenTypeE type);

    VerificationToken getVerificationToken(String verificationToken);
    void verifyEmail(long id);
    void sendEmailVerificationToken(String username);

    int compareRatings(long id);
}
