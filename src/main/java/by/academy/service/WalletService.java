package by.academy.service;

import by.academy.entity.Transaction;
import by.academy.entity.TransactionTopUp;
import by.academy.entity.Wallet;
import by.academy.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class WalletService {


    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionTopUpService transactionTopUpService;


    @Transactional
    public void saveWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    public void replenishmentBalance(Wallet wallet) {
        wallet.getBalance();
        //TODO
    }

    public Wallet getWallet(String usersWallet) {
        return walletRepository.findById(usersWallet).orElseThrow();
    }

    public long getWalletBalance(String id) {

        AtomicLong transactionListUserSenderAmount = new AtomicLong();
        AtomicLong transactionListUserReceiverAmount = new AtomicLong();
        AtomicLong transactionTopUpListAmount = new AtomicLong();


        List<Transaction> transactionListUserSender = transactionService.getTransactionsBySenderWalletId(id);
        List<Transaction> transactionListUserReceiver = transactionService.getTransactionsByReceiverWalletId(id);
        List<TransactionTopUp> transactionTopUpList = transactionTopUpService.getTransactionsTopUpByUsersWallet(id);

        transactionListUserSender
                .forEach(transaction -> transactionListUserSenderAmount.addAndGet(transaction.getValue()));
        transactionListUserReceiver
                .forEach(transaction -> transactionListUserReceiverAmount.addAndGet(transaction.getValue()));
        transactionTopUpList
                .forEach(transactionTopUp -> transactionTopUpListAmount.addAndGet(transactionTopUp.getAmount()));

        return transactionListUserSenderAmount.longValue()
                + transactionListUserReceiverAmount.longValue()
                + transactionTopUpListAmount.longValue();
    }
}
