package by.academy.controller.user;

import by.academy.entity.AppUser;
import by.academy.entity.Wallet;
import by.academy.service.UserService;
import by.academy.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    public static final String errorPage = "error-page";


    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @GetMapping
    public String showNewRecipient() {
        return "registration";
    }

    @PostMapping
    @Transactional
    public String createNewRecipient(
            @ModelAttribute @Valid AppUser appUser,
            @ModelAttribute @Valid Wallet wallet,
            ModelMap modelMap
    ) {
        System.out.println("New appUser: " + appUser);
        if (appUser.getUsername().equals(userService.getUserByUsername(appUser.getUsername()))) {
            final String message = "This user already exists";
            modelMap.addAttribute("message", message);
            return errorPage;
        }
        walletService.saveWallet(wallet);
        appUser.setUsersWallet(wallet.getId());
        userService.saveUser(appUser);
        return "redirect:home.html";

    }
}