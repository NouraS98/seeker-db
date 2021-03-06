package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    //هنا سويت كذا عشان هو يفهم اني ابي ابحث عن يوزرنيم لو ماسويت كذا مايدري انا ادور اي دي ولا يوزرنيم
    @GetMapping("username/{username}")
    public ResponseEntity findByUsername(@PathVariable String username){
       return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("email/{email}")
    public ResponseEntity findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("userID/{id}")
    public String changeIsEnabled(@PathVariable long id){
          return userService.changeIsEnabled(id);
    }



//new
    @PostMapping("reset")
    public void resetPassword(@RequestBody UserForRegisterDto user) {

        userService.resetUserPassword(user.getId(),user.getPassword());

    }




    //New by hind
    @PostMapping("phone_number/{id}/{phone_number}")
    public ResponseEntity setPhone(@PathVariable long id, @PathVariable String phone_number){
//        userService.setPhone(id,phone_number);
        return ResponseEntity.ok(userService.setPhone(id,phone_number));
    }

    @PostMapping("national_id/{id}/{national_id}")
    public ResponseEntity setNationalId(@PathVariable long id, @PathVariable String national_id){
//        userService.setNationalId(id,national_id);
        return ResponseEntity.ok(userService.setNationalId(id, national_id));
    }

    @PostMapping("twitter/{id}/{twitter}")
    public ResponseEntity setTwitter(@PathVariable long id, @PathVariable String twitter){
//        userService.setTwitter(userDto.getId(), userDto.getTwitter());
        return ResponseEntity.ok(userService.setTwitter(id, twitter));
    }

    @PostMapping("linkedin/{id}/{linkedIn}")
    public ResponseEntity setLinkedIn(@PathVariable long id, @PathVariable String linkedIn){
//       userService.setLinkedin(id, linkedIn);
        return ResponseEntity.ok(userService.setLinkedin(id, linkedIn));

    }

    @PostMapping("facebook/{id}/{facebook}")
    public ResponseEntity setFacebook(@PathVariable long id, @PathVariable String facebook){
//        userService.setFacebook(id, facebook);
        return ResponseEntity.ok(userService.setFacebook(id, facebook));

    }

    @GetMapping("get_linkedin/{id}")
    public String getLinkedInById(@PathVariable long id){
        return userService.getLinkedInById(id);
    }

    @GetMapping("get_twitter/{id}")
    public String getTwitterById(@PathVariable long id){
        return userService.getTwitterById(id);
    }

    @GetMapping("get_fb/{id}")
    public String getFacebookById(@PathVariable long id){
        return userService.getLFacebookById(id);
    }

    @PostMapping("education/{id}/{education}")
    public ResponseEntity setEducation(@PathVariable long id, @RequestBody UserDto education){
//        userService.setEducation(id, education);
        return ResponseEntity.ok(userService.setEducation(id, education));

    }

    @GetMapping("get_education/{id}")
    public String getEducation(@PathVariable long id){
        return userService.getEducationById(id);
    }

    @PostMapping("img/{id}/{img}")
    public void setImg(@PathVariable long id, @PathVariable byte[] img){
        userService.setImg(id, img);
    }

    @GetMapping("get_phone/{id}")
    public String getPhoneNumber(@PathVariable long id){
        return userService.getPhoneNumber(id);
    }

    @GetMapping("get_nid/{id}")
    public String getNationalId(@PathVariable long id){
        return userService.getNationalId(id);
    }

    @GetMapping("get_all_vals/{id}")
    public List<String> getAllTP(@PathVariable long id){
        return userService.getAllForTrustPoints(id);
    }

    @PostMapping("total_emp_tp/{id}")
    public int calculateEmployerTrustPoints(@PathVariable long id){
        return userService.calcEmpTP(id);
    }

    @PostMapping("total_fr_tp/{id}")
    public int calculateFreelancerTrustPoints(@PathVariable long id){
        return userService.calcFrTP(id);
    }

    @PutMapping ("changeType/{id}")
    public void setType(@PathVariable Long id){
        userService.setType(id);
    }


    @PutMapping("updateToken/{token}/{id}")
    public ResponseEntity updateToken(@PathVariable String token , @PathVariable Long id){
        return ResponseEntity.ok(userService.updateToken(token,id));
    }

    //غيرت الباث لان كان نفس فايند يوزر كذا اذا جيت ادور يوزر بيحذفه
    @DeleteMapping("deleteUser/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
    }



    @PostMapping("avatar/{id}")
    public ResponseEntity uploadAvatar(@PathVariable Long id,@RequestPart("avatar")MultipartFile file) {
        return ResponseEntity.ok(userService.uploadAvatar(id,file));
    }

    @PostMapping("add-work/{id}")
    public ResponseEntity uploadSampleWork(@PathVariable Long id, @RequestPart("attachment") MultipartFile attachment) {
        return ResponseEntity.ok(userService.addSampleWork(id,attachment));
    }

    @DeleteMapping("{id}/delete-work/{attachmentId}")
    public void deleteAttachmentById(@PathVariable long id, @PathVariable long attachmentId){
        userService.deleteSampleWorkById(id,attachmentId);
    }

    @GetMapping("compare/{id}")
    public int compare(@PathVariable long id){
       return userService.compareRatings(id);
    }

    @PutMapping ("setEnableProjectExpiryNoti/{id}/{value}")
    public void SetEnableProjectExpiryNoti(@PathVariable  Long id , @PathVariable  boolean value){
        userService.SetEnableProjectExpiryNoti(id,value);
    }

    @PutMapping ("SetEnableProjectSkillNoti/{id}/{value}")
    public void SetEnableProjectSkillNoti(@PathVariable  Long id, @PathVariable  boolean value) {
        userService.SetEnableProjectSkillNoti(id, value);
    }

    @PutMapping ("SetEnableAcceptBidNoti/{id}/{value}")
    public void SetEnableAcceptBidNoti(@PathVariable  Long id, @PathVariable boolean value){
        userService.SetEnableAcceptBidNoti(id,value);

    }

    @PutMapping ("SetEnableMilestoneDLNoti/{id}/{value}")
    public void SetEnableMilestoneDLNoti(@PathVariable Long id , @PathVariable  boolean value){
       userService.SetEnableMilestoneDLNoti(id,value);
    }

    @PutMapping ("logout/{id}")
    public void logout(@PathVariable long id){
        userService.logout(id);
    }

}
