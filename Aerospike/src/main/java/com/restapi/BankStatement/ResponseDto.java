package com.restapi.BankStatement;
import java.util.HashMap;
import java.util.List;

/**
 * The type Response dto.
 */
public class ResponseDto {
    private String result;
    private HashMap<String, List> history;

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public  void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets history.
     *
     * @return the history
     */
    public HashMap<String, List> getHistory() {
        return history;
    }

    /**
     * Sets history.
     *
     * @param history the history
     */
    public  void setHistory(HashMap<String, List> history) {
        this.history = history;
    }
}