package com.restapi.Email;

/**
 * The type Email details.
 */
public class EmailDetails {

    private String subject;

    private String message;

    private String to;

    /**
     * Instantiates a new Email details.
     */
    public  EmailDetails() {
    }

    /**
     * Instantiates a new Email details.
     *
     * @param subject the subject
     * @param message the message
     * @param to      the to
     */
    public EmailDetails(String subject, String message, String to) {
        this.subject = subject;
        this.message = message;
        this.to = to;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "EmailDetails{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
