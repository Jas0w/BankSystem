package ru.pinchuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pinchuk.entity.BankAccount;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

//    @Query("select a from BankAccount a where a.clientId = :clientId")
//    List<BankAccount> getAccountsByClientId(@Param("clientId") Long id);
}
