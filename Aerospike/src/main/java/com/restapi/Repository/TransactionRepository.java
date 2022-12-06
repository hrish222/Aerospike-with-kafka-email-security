package com.restapi.Repository;

import com.restapi.BankStatement.Transaction;
import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Model.Person;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;

import java.util.List;

/**
 * The type Transaction repository.
 */
public class TransactionRepository {
    /**
     * The Mapper.
     */
    @Inject
aeroMapperConfig mapper;
    /**
     * The Send person notification.
     */
    @Inject
SendPersonNotification sendPersonNotification;

    /**
     * Save transaction.
     *
     * @param transaction the transaction
     */
    public void saveTransaction(Transaction transaction) {
        mapper.getMapper().save(transaction);
    }

    /**
     * List transaction list.
     *
     * @return the list
     */
    public List<Transaction> listTransaction() {
        sendPersonNotification.sendPersonNotification("Get All Transaction Info..!"+mapper.getMapper().scan(Transaction.class));
        return mapper.getMapper().scan(Transaction.class);
    }
}
