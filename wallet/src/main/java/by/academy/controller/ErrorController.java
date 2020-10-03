package by.academy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/error-page")
    public ModelAndView getError(ModelAndView modelAndView){
        modelAndView.setViewName("error-page");
        return modelAndView;
    }

}
