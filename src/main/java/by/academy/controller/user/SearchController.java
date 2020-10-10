package by.academy.controller.user;

import by.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam String search,
            ModelAndView modelAndView) {

        modelAndView.addObject("users", userService.getAllUsers());
        modelAndView.setViewName("search-result");
        return modelAndView;
    }

}
