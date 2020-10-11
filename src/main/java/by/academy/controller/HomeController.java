package by.academy.controller;

import by.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @Autowired
    UserService userService;

    @GetMapping(value = "/home")
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("home"); // -> /WEB-INF/jsp/ + home + .jsp

        return modelAndView;
    }
}
