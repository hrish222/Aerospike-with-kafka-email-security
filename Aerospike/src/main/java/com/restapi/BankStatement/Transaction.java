package com.restapi.BankStatement;
import com.aerospike.mapper.annotations.*;

/**
 * The type Transaction.
 */
@AerospikeRecord(namespace = "test",set = "transaction")
public class Transaction{

    @AerospikeBin
    private long accoNo;
    @AerospikeBin
    private long amount;

    @AerospikeEnum
    @AerospikeBin
    private TransactionType Type;

    @AerospikeKey
    @AerospikeBin
    private String timePeriod;

    /**
     * Instantiates a new Transaction.
     */
    public Transaction() {
    }

    /**
     * Instantiates a new Transaction.
     *
     * @param accoNo     the acco no
     * @param amount     the amount
     * @param type       the type
     * @param timePeriod the time period
     */
    public Transaction(long accoNo, long amount, TransactionType type, String timePeriod) {
        this.accoNo = accoNo;
        this.amount = amount;
        Type = type;
        this.timePeriod = timePeriod;
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

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return Type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(TransactionType type) {
        Type = type;
    }

    /**
     * Gets time period.
     *
     * @return the time period
     */
    public String getTimePeriod() {
        return timePeriod;
    }

    /**
     * Sets time period.
     *
     * @param timePeriod the time period
     */
    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accoNo=" + accoNo +
                ", amount=" + amount +
                ", Type=" + Type +
                ", timePeriod='" + timePeriod + '\'' +
                '}';
    }
}