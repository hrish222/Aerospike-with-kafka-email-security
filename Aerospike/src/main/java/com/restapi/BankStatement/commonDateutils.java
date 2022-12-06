package com.restapi.BankStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Common dateutils.
 */
public class commonDateutils {

    /**
     * The constant DATE_TIME_FORMATE_11.
     */
    public static final String DATE_TIME_FORMATE_11 = "dd-MM-yyyy HH:mm:ss";
    /**
     * The constant txn_hist.
     */
    public static List<Transaction> txn_hist=new ArrayList<>();

    /**
     * Format date string.
     *
     * @param date the date
     * @return the string
     * @throws ParseException the parse exception
     */
//    UUID uuid = java.util.UUID.randomUUID();
    public static String formatDate(String date) throws ParseException {
        if (date.isEmpty()) {
            return null;
        }
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(parser.parse(date));
    }

    /**
     * Date format date.
     *
     * @param date the date
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date dateFormat(String date) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatter=new SimpleDateFormat(commonDateutils.DATE_TIME_FORMATE_11);
        String newDate = formatter.format(parser.parse(date));
        Date parsedDate=formatter.parse(newDate);
        return parsedDate;
    }

    /**
     * Format date string.
     *
     * @param date       the date
     * @param dateFormat the date format
     * @return the string
     */
    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * Is within range boolean.
     *
     * @param testDate  the test date
     * @param startDate the start date
     * @param endDate   the end date
     * @return the boolean
     */
    public static boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return !(testDate.before(startDate) || testDate.after(endDate));
    }


}