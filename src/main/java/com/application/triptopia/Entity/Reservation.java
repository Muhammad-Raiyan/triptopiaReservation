package com.application.triptopia.Entity;

import java.sql.Timestamp;

public class Reservation {
    private int resrNo;
    private Timestamp resrDate;
    private double bookingFee;
    private double totalFare;
    private int repSSN;
    private int accountNo;

    public Reservation() {
    }

    public Reservation(int resrNo, Timestamp resrDate, double bookingFee, double totalFare, int repSSN, int accountNo) {
        this.resrNo = resrNo;
        this.resrDate = resrDate;
        this.bookingFee = bookingFee;
        this.totalFare = totalFare;
        this.repSSN = repSSN;
        this.accountNo = accountNo;
    }

    public int getResrNo() {
        return resrNo;
    }

    public void setResrNo(int resrNo) {
        this.resrNo = resrNo;
    }

    public Timestamp getResrDate() {
        return resrDate;
    }

    public void setResrDate(Timestamp resrDate) {
        this.resrDate = resrDate;
    }

    public double getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(double bookingFee) {
        this.bookingFee = bookingFee;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public int getRepSSN() {
        return repSSN;
    }

    public void setRepSSN(int repSSN) {
        this.repSSN = repSSN;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
