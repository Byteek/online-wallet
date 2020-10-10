package by.academy.service;

import by.academy.entity.TransactionTopUp;
import by.academy.repository.TransactionTopUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTopUpService {

    @Autowired
    TransactionTopUpRepository transactionTopUpRepository;

    public TransactionTopUp saveTransactionTopUp(TransactionTopUp transactionTopUp) {
        return transactionTopUpRepository.save(transactionTopUp);
    }

    public List<TransactionTopUp> getTransactionsTopUpByUsersWallet(String id) {
        return transactionTopUpRepository.findAllByUserWalletId(id);
    }
}
