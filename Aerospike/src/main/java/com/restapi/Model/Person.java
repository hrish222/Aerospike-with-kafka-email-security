package com.restapi.Model;

import com.aerospike.mapper.annotations.*;


/**
 * The type Person.
 */
@AerospikeRecord(namespace= "test",set="Person")
public class Person {
    @AerospikeKey

    @AerospikeBin

    private int id;
    @AerospikeBin
    private String name;
    @AerospikeBin
    private String email;
    @AerospikeBin
    private int sal;
    @AerospikeBin
    private String JoiningDate;
    @AerospikeEmbed
    @AerospikeBin
    private Categories categories;
    @AerospikeBin
    private long accoNo;


    /**
     * Instantiates a new Person.
     */
    public Person() {
    }
//
//    public Person(String name, String email, int sal, String joiningDate, Categories categories) {
//    }


    /**
     * Instantiates a new Person.
     *
     * @param name        the name
     * @param email       the email
     * @param sal         the sal
     * @param joiningDate the joining date
     * @param categories  the categories
     * @param accoNo      the acco no
     */
    public Person(String name, String email, int sal, String joiningDate, Categories categories, long accoNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sal = sal;
        JoiningDate = joiningDate;
        this.categories = categories;
        this.accoNo = accoNo;

    }

    /**
     * Instantiates a new Person.
     *
     * @param id          the id
     * @param name        the name
     * @param email       the email
     * @param sal         the sal
     * @param joiningDate the joining date
     * @param categories  the categories
     * @param accoNo      the acco no
     */
    public Person(int id, String name, String email, int sal, String joiningDate, Categories categories,long accoNo) {
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets sal.
     *
     * @return the sal
     */
    public int getSal() {
        return sal;
    }

    /**
     * Sets sal.
     *
     * @param sal the sal
     */
    public void setSal(int sal) {
        this.sal = sal;
    }

    /**
     * Gets joining date.
     *
     * @return the joining date
     */
    public String getJoiningDate() {
        return JoiningDate;
    }

    /**
     * Sets joining date.
     *
     * @param joiningDate the joining date
     */
    public void setJoiningDate(String joiningDate) {
        JoiningDate = joiningDate;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sal=" + sal +
                ", JoiningDate='" + JoiningDate + '\'' +
                ", categories=" + categories +
                ", accoNo=" + accoNo +
                '}';
    }
}