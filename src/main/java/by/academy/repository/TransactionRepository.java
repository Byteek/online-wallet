package by.academy.repository;

import by.academy.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findFirst10BySenderWallet(String username, Pageable pageable);

    List<Transaction> findAllByReceiverWallet(String id);

    List<Transaction> findAllBySenderWallet(String id);

}
