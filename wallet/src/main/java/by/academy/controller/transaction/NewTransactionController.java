package by.academy.controller.transaction;

import by.academy.entity.AppUser;
import by.academy.entity.Transaction;
import by.academy.service.TransactionService;
import by.academy.service.UserService;
import by.academy.service.WalletService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/new-transaction")
public class NewTransactionController {

    public static final Logger logger = LoggerFactory.getLogger(NewTransactionController.class);
    public static final String errorPage = "error-page";

    @Autowired
    TransactionService transactionService;

    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @GetMapping
    public ModelAndView getForm(ModelAndView modelAndView) {
        modelAndView.setViewName("new-transaction");
        return modelAndView;
    }


    @PostMapping
    public String createNewTransaction(@Valid Transaction transaction, ModelMap modelMap) {

        transaction.setSenderWallet(UserService.getUsernameAuthUser());
        AppUser senderAppUser = userService.getUserByUsername(transaction.getSenderWallet());
        AppUser receiverAppUser = userService.getUserByUsername(transaction.getReceiverWallet());
        if (receiverAppUser == null) {
            final String message = "There is no such user";
            modelMap.addAttribute("message", message);
            return errorPage;
        }
        if (receiverAppUser.getUsername().equals(senderAppUser.getUsername())) {
            final String message = "Want to send money to yourself?";
            modelMap.addAttribute("message", message);
            return errorPage;
        }
        if (transaction.getValue() > walletService.getWallet(senderAppUser.getUsersWallet()).getBalance()) {
            final String message = "You don't have enough funds";
            modelMap.addAttribute("message", message);
            return errorPage;
        }
        if (transaction.getValue() <= 0) {
            final String message = "Please enter an integer";
            modelMap.addAttribute("message", message);
            return errorPage;
        }


        transaction.setSenderWallet(senderAppUser.getUsersWallet());
        transaction.setReceiverWallet(receiverAppUser.getUsersWallet());


        transactionService.createNewTransaction(transaction);
        return "home";

    }

}
