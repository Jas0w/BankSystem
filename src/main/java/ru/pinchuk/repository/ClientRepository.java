package ru.pinchuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pinchuk.entity.Client;
import ru.pinchuk.entity.Employee;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c where c.bank.id = :bankId")
    List<Client> findClientsByBankId(@Param("bankId")Long id);

    @Query("select c from Client c where c.id = :clientId")
    Client getClientById(@Param("clientId")Long id);

}
