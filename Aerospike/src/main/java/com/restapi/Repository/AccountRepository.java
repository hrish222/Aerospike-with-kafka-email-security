package com.restapi.Repository;

import com.restapi.BankStatement.BalanceTransfer;
import com.restapi.BankStatement.Transaction;
import com.restapi.BankStatement.TransactionType;
import com.restapi.BankStatement.commonDateutils;
import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Model.Account;
import com.restapi.Service.AccountService;
import com.restapi.Service.EmailService;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

/**
 * The type Account repository.
 */
public class AccountRepository {
    /**
     * The Mapper.
     */
    @Inject
    aeroMapperConfig mapper;
    /**
     * The Transaction repository.
     */
    @Inject
    TransactionRepository transactionRepository;


    /**
     * The Email service.
     */
    @Inject
    EmailService emailService;
    /**
     * The Send person notification.
     */
    @Inject
    SendPersonNotification sendPersonNotification;
    // Accounts All Api with Flowwise

    /**
     * Add account string.
     *
     * @param account the account
     * @return the string
     */
    public String addAccount(Account account){
        mapper.getMapper().save(account);
        sendPersonNotification.sendPersonNotification("Account Created Successfully..!"+account);
        return "Account Created Successfully..!"+account.getAccoNo();
    }

    /**
     * Gets account by acc number.
     *
     * @param accoNo the acco no
     * @return the account by acc number
     */
    public Account getAccountByAccNumber(long accoNo) {
        sendPersonNotification.sendPersonNotification("Get Account By AccoNo Successfully..!"+mapper.getMapper().read(Account.class,accoNo));

        return mapper.getMapper().read(Account.class,accoNo);
    }

    /**
     * Gets all account.
     *
     * @return the all account
     */
    public List<Account> getAllAccount() {
        sendPersonNotification.sendPersonNotification("Get All Account Info..!"+mapper.getMapper().scan(Account.class));
        return mapper.getMapper().scan(Account.class);
    }

    /**
     * Delete by acco number string.
     *
     * @param accoNo the acco no
     * @return the string
     */
    public String deleteByAccoNumber(long accoNo) {
        mapper.getMapper().delete(Account.class,accoNo);
        sendPersonNotification.sendPersonNotification("Account Deleted Successfully..!"+accoNo);
        return "Account deleted successfully with account number :"+accoNo;
    }

    /**
     * Cash withdraw string.
     *
     * @param accoNo         the acco no
     * @param withdrawAmount the withdraw amount
     * @return the string
     */
    public String cashWithdraw(long accoNo, long withdrawAmount){
        Account account = getAccountByAccNumber(accoNo);
        Transaction transaction = new Transaction(account.getAccoNo(),withdrawAmount, TransactionType.DEBIT, commonDateutils.formatDate(new Date(), commonDateutils.DATE_TIME_FORMATE_11));

        account.setBalance(account.getBalance() - withdrawAmount);

        mapper.getMapper().save(account);
        transactionRepository.saveTransaction(transaction);
        sendPersonNotification.sendPersonNotification("cashwithdraw Successfully..!"+mapper.getMapper().read(Account.class,accoNo));
        return "Account has been debited!!!!!";
    }

    /**
     * Cash deposit string.
     *
     * @param accoNo        the acco no
     * @param depositAmount the deposit amount
     * @return the string
     */
    public String cashDeposit(long accoNo, long depositAmount){
        Account account =(Account)  getAccountByAccNumber(accoNo);

        Transaction transaction = new Transaction(account.getAccoNo(),depositAmount, TransactionType.CREDIT, commonDateutils.formatDate(new Date(), commonDateutils.DATE_TIME_FORMATE_11));
       account.setBalance(account.getBalance() + depositAmount);
        mapper.getMapper().save(account);
        transactionRepository.saveTransaction(transaction);
        sendPersonNotification.sendPersonNotification("depositAmount Successfully..!"+mapper.getMapper().read(Account.class,accoNo));
        return "Account has been credited!!!!!";
    }

    /**
     * Save.
     *
     * @param account the account
     */
    public void save(Account account){
         mapper.getMapper().save(account);
   }

}
