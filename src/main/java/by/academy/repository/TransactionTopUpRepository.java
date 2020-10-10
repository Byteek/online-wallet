package by.academy.repository;

import by.academy.entity.Transaction;
import by.academy.entity.TransactionTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionTopUpRepository extends JpaRepository<TransactionTopUp, String> {
    List<TransactionTopUp> findAllByUserWalletId(String id);
}
