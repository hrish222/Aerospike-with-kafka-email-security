package com.restapi.Model;

import java.io.Serializable;

/**
 * The type Custom response.
 */
public class CustomResponse implements Serializable {
    private Object response;

    /**
     * Instantiates a new Custom response.
     */
    public CustomResponse() {
    }

    /**
     * Instantiates a new Custom response.
     *
     * @param response the response
     */
    public CustomResponse(Object response) {
        this.response = response;
    }

    /**
     * Gets response.
     *
     * @return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Sets response.
     *
     * @param response the response
     */
    public void setResponse(Object response) {
        this.response = response;
    }
}

