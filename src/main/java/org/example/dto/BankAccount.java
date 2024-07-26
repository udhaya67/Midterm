package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BankAccount {
    @Id
    private int actNumber;
    private String customerName;
    private double actBalance;
    private String city;
    private int branchCode;

    public BankAccount() {
    }

    public BankAccount(int actNumber, String customerName, double actBalance, String city, int branchCode) {
        this.actNumber = actNumber;
        this.customerName = customerName;
        this.actBalance = actBalance;
        this.city = city;
        this.branchCode = branchCode;
    }

    public int getActNumber() {
        return actNumber;
    }

    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getActBalance() {
        return actBalance;
    }

    public void setActBalance(double actBalance) {
        this.actBalance = actBalance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "actNumber=" + actNumber +
                ", customerName='" + customerName + '\'' +
                ", actBalance=" + actBalance +
                ", city='" + city + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return actNumber == that.actNumber && Double.compare(actBalance, that.actBalance) == 0 && branchCode == that.branchCode && Objects.equals(customerName, that.customerName) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actNumber, customerName, actBalance, city, branchCode);
    }
}
