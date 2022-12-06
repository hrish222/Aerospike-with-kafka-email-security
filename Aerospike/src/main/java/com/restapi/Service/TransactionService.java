package com.restapi.Service;

import com.restapi.BankStatement.Transaction;
import com.restapi.Repository.TransactionRepository;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;

import java.util.List;

/**
 * The type Transaction service.
 */
public class TransactionService {
    /**
     * The Transaction repository.
     */
    @Inject
    TransactionRepository transactionRepository;

    /**
     * Save transaction.
     *
     * @param transaction the transaction
     */
    public void saveTransaction(Transaction transaction) {
        transactionRepository.saveTransaction(transaction);
    }

    /**
     * Account list.
     *
     * @return the list
     */
    public List<Transaction> account() {

        return transactionRepository.listTransaction();
    }
}
