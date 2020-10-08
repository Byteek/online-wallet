package by.academy.controller.user;

import by.academy.entity.AppUser;
import by.academy.entity.Transaction;
import by.academy.entity.TransactionTopUp;
import by.academy.entity.Wallet;
import by.academy.service.TransactionService;
import by.academy.service.TransactionTopUpService;
import by.academy.service.UserService;
import by.academy.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/balance")
public class BalanceController {

    public static final String errorPage = "error-page";


    @Autowired
    UserService userService;
    @Autowired
    WalletService walletService;
    @Autowired
    TransactionTopUpService transactionTopUpService;
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ModelAndView getBalanceForm(ModelAndView modelAndView) {

        AppUser user = userService.getUserByUsername(UserService.getUsernameAuthUser());

        getBalance(user.getUsername());
        Wallet wallet = walletService.getWallet(user.getUsersWallet());

        modelAndView.setViewName("balance");
        modelAndView.addObject("balance", wallet.getBalance());
        return modelAndView;
    }

    @PostMapping
    public String transferMoneyToWallet(@ModelAttribute @Valid TransactionTopUp transactionTopUp, ModelMap modelMap) {

        AppUser user = userService.getUserByUsername(UserService.getUsernameAuthUser());
        Wallet userWallet = walletService.getWallet(user.getUsersWallet());

        if (transactionTopUp.getAmount() <= 0) {
            final String message = "Please enter an integer";
            modelMap.addAttribute("message", message);
            return errorPage;
        }

        transactionTopUp.setUserWalletId(userWallet.getId());
        TransactionTopUp topUp = transactionTopUpService.saveTransactionTopUp(transactionTopUp);
        userWallet.setBalance(userWallet.getBalance() + topUp.getAmount());
        walletService.saveWallet(userWallet);
        return "redirect:balance";
    }

    private void getBalance(String username) {

        long balance;

        AppUser user = userService.getUserByUsername(username);
        Wallet wallet = walletService.getWallet(user.getUsersWallet());
        List<Transaction> transactionUserSender = transactionService.getTransactionsBySenderUsername(user.getUsersWallet());
        List<Transaction> transactionUserReceiver = transactionService.getTransactionsByReceiverUsername(user.getUsersWallet());
        List<TransactionTopUp> transactionTopUps = transactionTopUpService.getTransactionsTopUpByUsersWallet(user.getUsersWallet());

        System.out.println(transactionUserSender);
        System.out.println(transactionUserReceiver);
        System.out.println(transactionTopUps);

        balance = transactionTopUps.stream().mapToLong(TransactionTopUp::getAmount).sum()
                + transactionUserReceiver.stream().mapToLong(Transaction::getValue).sum()
                - transactionUserSender.stream().mapToLong(Transaction::getValue).sum();

        wallet.setBalance(balance);
        walletService.saveWallet(wallet);
    }

}
