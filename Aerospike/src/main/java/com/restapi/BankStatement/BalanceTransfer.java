package com.restapi.BankStatement;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

/**
 * The type Balance transfer.
 */
@AerospikeRecord(namespace = "test",set = "BalanceTransfer")
public class BalanceTransfer {

    /**
     * The Fromacco no.
     */
    @AerospikeKey
    @AerospikeBin
     long fromaccoNo;
    /**
     * The Toacco no.
     */
    @AerospikeBin
     long toaccoNo;
    /**
     * The Amount.
     */
    @AerospikeBin
     long amount;

    /**
     * Instantiates a new Balance transfer.
     */
    public BalanceTransfer() {
    }

    /**
     * Instantiates a new Balance transfer.
     *
     * @param fromaccoNo the fromacco no
     * @param toaccoNo   the toacco no
     * @param amount     the amount
     */
    public BalanceTransfer(long fromaccoNo, long toaccoNo, long amount) {
        this.fromaccoNo = fromaccoNo;
        this.toaccoNo = toaccoNo;
        this.amount = amount;
    }

    /**
     * Gets fromacco no.
     *
     * @return the fromacco no
     */
    public long getFromaccoNo() {
        return fromaccoNo;
    }

    /**
     * Sets fromacco no.
     *
     * @param fromaccoNo the fromacco no
     */
    public void setFromaccoNo(long fromaccoNo) {
        this.fromaccoNo = fromaccoNo;
    }

    /**
     * Gets toacco no.
     *
     * @return the toacco no
     */
    public long getToaccoNo() {
        return toaccoNo;
    }

    /**
     * Sets toacco no.
     *
     * @param toaccoNo the toacco no
     */
    public void setToaccoNo(long toaccoNo) {
        this.toaccoNo = toaccoNo;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BalanceTransfer{" +
                "fromaccoNo='" + fromaccoNo + '\'' +
                ", toaccoNo='" + toaccoNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
