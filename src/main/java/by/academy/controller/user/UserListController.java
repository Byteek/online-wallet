package by.academy.controller.user;

import by.academy.entity.AppUser;
import by.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-list")
    public ModelAndView recipientList(ModelAndView modelAndView) {
        List<AppUser> appUsers = userService.getAllUsers();
        modelAndView.setViewName("transaction-list");
        modelAndView.addObject("users", appUsers);
        return modelAndView;
    }
}
