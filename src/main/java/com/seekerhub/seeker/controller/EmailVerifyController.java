package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.entity.VerificationToken;
import com.seekerhub.seeker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

@Controller
public class EmailVerifyController {


    @Autowired private UserDetailsService userDetailsService;

    @Autowired private MessageSource messageSource;

    @Autowired private UserService userService;

    @GetMapping("/email-verify")
    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token, RedirectAttributes redirectAttributes) {

        VerificationToken verificationToken = userService.getVerificationToken(token);

        Locale locale = request.getLocale();

        if (verificationToken == null) {
//            String message = messages.getMessage("auth.message.invalidToken", null, locale);
//            model.addAttribute("message", message);
            return "redirect:/linkExpired.html";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "redirect:/linkExpired.html";
        }
        userService.verifyEmail(user.getId());
        return "emailVerify";
    }

    @GetMapping("/sendVerifyEmail")
    public String emailVerification() {
        return "sendEmailVerify";
    }

    @PostMapping("/send-verify-email")
    public String sendVerifyEmail(@RequestParam() String email, Model model) {
        model.addAttribute("title", "Send Verify Email");
        UserDto user = userService.findByEmail(email);
        if (user != null) {
            if (user.isVerified()) {
                model.addAttribute("verified", true);
            } else {
                userService.sendEmailVerificationToken(user.getUsername());
                model.addAttribute("sent", true);
            }
        } else {
            model.addAttribute("notExists", true);
        }
        return "sendEmailVerify";
    }

}
