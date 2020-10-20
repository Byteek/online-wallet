package by.academy.controller;

import by.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("home"); // -> /WEB-INF/jsp/ + home + .jsp

        return modelAndView;
    }
}
