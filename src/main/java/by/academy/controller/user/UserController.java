package by.academy.controller.user;

import by.academy.entity.AppUser;
import by.academy.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Value("${image.location}")
    String imageLocation;

    @GetMapping("/{userId}/user.html")
    public ModelAndView showRecipientForm(
            @PathVariable String userId,
            ModelAndView modelAndView
    ) {
        AppUser appUser = userService.getUser(userId);
        modelAndView.addObject("user", appUser);
        modelAndView.setViewName("appUser");
        return modelAndView;
    }

    @PostMapping("/user.html")
    @SneakyThrows
    public String updateRecipient(
            @ModelAttribute AppUser appUser
    ) {

        userService.update(appUser);
        return "redirect:appUser-list.html";
    }

}
