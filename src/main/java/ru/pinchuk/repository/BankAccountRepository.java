package ru.pinchuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pinchuk.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
