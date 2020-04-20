package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.user.PasswordResetDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.entity.VerificationToken;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.Locale;

@Controller
public class PasswordResetController {


    @Autowired private UserDetailsService userDetailsService;

    @Autowired private MessageSource messageSource;

    @Autowired private UserService userService;

    @GetMapping("/password-reset")
    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token, RedirectAttributes redirectAttributes) {

        VerificationToken verificationToken = userService.getVerificationToken(token);

        Locale locale = request.getLocale();

        if (verificationToken == null) {
//            String message = messages.getMessage("auth.message.invalidToken", null, locale);
//            model.addAttribute("message", message);
            return "redirect:/linkExpiredPassword.html";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "redirect:/linkExpiredPassword.html";
        }
       // userService.verifyEmail(user.getId());
        model.addAttribute("email" , user.getEmail());
        model.addAttribute("passwordDto" , new PasswordResetDto().builder().email(user.getEmail()).build());

        return "updatePassword";
    }

    @GetMapping("/sendResetPassword")
    public String emailVerification() {
        return "sendResetPassword";
    }

    @PostMapping("/send-reset-password")
    public String sendResetPassword(@RequestParam() String email, Model model) {
        model.addAttribute("title", "Password reset");
        UserDto user = userService.findByEmail(email);
        if (user != null) {
            userService.sendResetPasswordEmail(email);

        } else {
            model.addAttribute("notExists", true);
        }
        return "sendResetPassword";
    }

    @PostMapping("/update-password")
    public String updatePassword(@ModelAttribute("passwordDto") PasswordResetDto passwordDto, Model model ) {
        model.addAttribute("title", "Password reset");
        String email =  passwordDto.getEmail();
////        UserDto user = userService.findByEmail(email);
//        if (user != null) {
//            userService.sendResetPasswordEmail(email);
//
//        } else {
//            model.addAttribute("notExists", true);
//        }
        if(!passwordDto.getPassword().equals(passwordDto.getConfirmPassword())){
           model.addAttribute("notMatch", true);

        }else{
            if(passwordDto.getPassword().length()<8) {
                model.addAttribute("PasswordCondition", true);
            }else{
                userService.resetPassword(email,passwordDto.getPassword());
                model.addAttribute("success", true);
            }
        }
        return "updatePassword";
    }

}
