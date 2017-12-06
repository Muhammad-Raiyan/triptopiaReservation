package com.application.triptopia.Entity;

public class Customer {

    public int personId;
    public String creditCard;
    public String phoneNo;
    public String email;
    public String date;
    public int rating;

    public Customer(int personId, String creditCard, String phoneNo, String email, String date, int rating) {
        this.personId = personId;
        this.creditCard = creditCard;
        this.phoneNo = phoneNo;
        this.email = email;
        this.date = date;
        this.rating = rating;
    }
}
