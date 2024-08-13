package com.Bank.Bank.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_Bank")
public class AccountDetails {
    @Id
    @Column(name ="AccountNo")
    private long AccountNo;
    @Column(name="name")
    private String name;
    @Column(name="initialBalance")
    private double initialBalance;

    public long getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(long AccountNo) {
        this.AccountNo = AccountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }


}
