package by.academy.service;

import by.academy.entity.Transaction;
import by.academy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void createNewTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsBySenderUsername(String usernameAuthUser) {
        return transactionRepository.findAllBySenderWallet(usernameAuthUser);
    }

    public List<Transaction> getTransactionsByReceiverUsername(String usernameAuthUser) {
        return transactionRepository.findAllByReceiverWallet(usernameAuthUser);
    }

    public List<Transaction> getTransactionsBySenderWalletId(String id) {
        return transactionRepository.findAllBySenderWallet(id);
    }

    public List<Transaction> getTransactionsByReceiverId(String id) {
        return transactionRepository.findAllByReceiverWallet(id);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByReceiverWalletId(String usersWallet) {
        return transactionRepository.findAllByReceiverWallet(usersWallet);

    }
}
