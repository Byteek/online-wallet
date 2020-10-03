package by.academy.controller.transaction;

import by.academy.entity.AppUser;
import by.academy.entity.Transaction;
import by.academy.entity.TransactionTopUp;
import by.academy.service.TransactionService;
import by.academy.service.TransactionTopUpService;
import by.academy.service.UserService;
import by.academy.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transaction-list")
public class TransactionListController {

    public static final Logger logger = LoggerFactory.getLogger(TransactionListController.class);

    @Autowired
    WalletService walletService;
    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionTopUpService transactionTopUpService;
    @GetMapping
    ModelAndView getTransactionListForm(ModelAndView modelAndView, ModelMap modelMap) {

        AppUser user = userService.getUserByUsername(UserService.getUsernameAuthUser());

        List<Transaction> transactionListUserSender = transactionService.getTransactionsBySenderWalletId(user.getUsersWallet());
        List<Transaction> transactionListUserReceiver = transactionService.getTransactionsByReceiverWalletId(user.getUsersWallet());
        List<TransactionTopUp> transactionTopUpList = transactionTopUpService.getTransactionsTopUpByUsersWallet(user.getUsersWallet());


        transactionListUserSender.forEach(transaction -> transaction.setReceiverWallet(
                userService.getUserByWalletId(
                        transaction.getReceiverWallet()
                ).getUsername()
        ));

        transactionListUserReceiver.forEach(transaction -> transaction.setSenderWallet(
                userService.getUserByWalletId(
                        transaction.getSenderWallet()
                ).getUsername()
        ));


        modelAndView.setViewName("transaction-list");

        modelAndView.addObject("youSender", transactionListUserSender);
        modelAndView.addObject("youReceiver", transactionListUserReceiver);
        modelAndView.addObject("topUp" , transactionTopUpList);

        return modelAndView;
    }

}
