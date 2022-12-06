package com.restapi.Model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;


/**
 * The type Account.
 */
@AerospikeRecord(namespace = "test",set = "Account")
public class Account {
    @AerospikeBin
    @AerospikeKey
    private long accoNo;
    @AerospikeBin
    private long balance;

    /**
     * Instantiates a new Account.
     */
    public Account(){}

    /**
     * Instantiates a new Account.
     *
     * @param accoNo the acco no
     */
    public Account(long accoNo) {
        this.accoNo = accoNo;
        this.balance = balance;
    }

    /**
     * Gets acco no.
     *
     * @return the acco no
     */
    public long getAccoNo() {
        return accoNo;
    }

    /**
     * Sets acco no.
     *
     * @param accoNo the acco no
     */
    public void setAccoNo(long accoNo) {
        this.accoNo = accoNo;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public long getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accoNo=" + accoNo +
                ", balance=" + balance +
                '}';
    }
}