package com.restapi.Service;

import com.restapi.BankStatement.BalanceTransfer;
import com.restapi.BankStatement.Transaction;
import com.restapi.BankStatement.TransactionType;
import com.restapi.BankStatement.commonDateutils;
import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Model.Account;
import com.restapi.Repository.AccountRepository;
import com.restapi.Repository.TransactionRepository;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

/**
 * The type Account service.
 */
public class AccountService {
    /**
     * The Mapper.
     */
    @Inject
    aeroMapperConfig mapper;
    /**
     * The Account repository.
     */
    @Inject
    AccountRepository accountRepository;
    /**
     * The Transaction repository.
     */
    @Inject
    TransactionRepository transactionRepository;
    /**
     * The Send person notification.
     */
    @Inject
    SendPersonNotification sendPersonNotification;


    /**
     * Add account string.
     *
     * @param account the account
     * @return the string
     */
    public String addAccount(Account account) {

        return accountRepository.addAccount(account);
    }


    /**
     * Gets all account.
     *
     * @return the all account
     */
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    /**
     * Gets account by acc number.
     *
     * @param accoNo the acco no
     * @return the account by acc number
     */
    public Account getAccountByAccNumber(long accoNo) {
        return accountRepository.getAccountByAccNumber(accoNo);
    }

    /**
     * Delete by acco number string.
     *
     * @param accoNo the acco no
     * @return the string
     */
    public String deleteByAccoNumber(long accoNo) {
        return accountRepository.deleteByAccoNumber(accoNo);
    }


    /**
     * Cash withdraw string.
     *
     * @param accoNo         the acco no
     * @param withdrawAmount the withdraw amount
     * @return the string
     */
    public String cashWithdraw(long accoNo, long withdrawAmount) {
        return accountRepository.cashWithdraw(accoNo, withdrawAmount);
    }


    /**
     * Cash deposit string.
     *
     * @param accoNo        the acco no
     * @param depositAmount the deposit amount
     * @return the string
     */
    public String cashDeposit(long accoNo, long depositAmount) {
        return accountRepository.cashDeposit(accoNo, depositAmount);
    }

    /**
     * Send money string.
     *
     * @param transferBalanceRequest the transfer balance request
     * @return the string
     */
    public String sendMoney(BalanceTransfer transferBalanceRequest) {
        long fromaccoNo = transferBalanceRequest.getFromaccoNo();
        long toaccoNo = transferBalanceRequest.getToaccoNo();
        long amount = transferBalanceRequest.getAmount();
        Account fromAccount = accountRepository.getAccountByAccNumber(fromaccoNo);
        Account toAccount = accountRepository.getAccountByAccNumber(toaccoNo);
        if (fromAccount.getBalance() >=amount ) {
            Transaction transaction1 = new Transaction(fromaccoNo,amount,TransactionType.DEBIT, commonDateutils.formatDate(new Date(), commonDateutils.DATE_TIME_FORMATE_11));
            fromAccount.setBalance(fromAccount.getBalance() - (amount));
            mapper.getMapper().save(fromAccount);
            transactionRepository.saveTransaction(transaction1);
            Transaction transaction2 = new Transaction(toaccoNo,amount, TransactionType.CREDIT, commonDateutils.formatDate(new Date(), commonDateutils.DATE_TIME_FORMATE_11));
            toAccount.setBalance(toAccount.getBalance() + (amount));
            mapper.getMapper().save(toAccount);
            transactionRepository.saveTransaction(transaction2);

          // mapper.getMapper().save(acc);
//            Transaction transaction = new Transaction(fromaccoNo, amount, TransactionType.CREDIT, commonDateutils);
            sendPersonNotification.sendPersonNotification("Fund Transfer fromaccoNo  Successfully..!"+mapper.getMapper().read(Account.class,fromaccoNo)+"fund Received toaccoNo successfully"+mapper.getMapper().read(Account.class,toaccoNo));
            return "fund transfer fromaccoNo Sucessfully"+transaction1+"Fund received toaccoNo Successfully "+transaction2;
        }
        return "Insufficient Balance please check";
    }

}
