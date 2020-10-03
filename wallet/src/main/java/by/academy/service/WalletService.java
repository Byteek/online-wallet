package by.academy.service;

import by.academy.entity.Wallet;
import by.academy.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

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
}
