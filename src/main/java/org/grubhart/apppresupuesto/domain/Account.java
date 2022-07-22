package org.grubhart.apppresupuesto.domain;

import org.grubhart.apppresupuesto.error.exception.InvalidAmountException;
import org.grubhart.apppresupuesto.error.exception.UnavailableAccountException;





public class Account {

   
    public Long id;

    private String name;

    private double balance = 0.0;
    private int status;

    public Account() {
    }

    public Account(String name, double initialAmount) {
        if(initialAmount < 0.00000000000000){
            throw new InvalidAmountException();
        }
        this.name = name;
        this.balance = initialAmount;
        this.status = 1;
    }




    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if(amount >= Double.MAX_VALUE-getBalance()){
            throw new InvalidAmountException();
        }

        if(status!=1){
            throw new UnavailableAccountException();
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {

        if(amount > this.balance){
            throw new InvalidAmountException();
        }

        if(status!=1){
            throw new UnavailableAccountException();
        }
        this.balance -=  amount;

    }

    public String getName() {
        return name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

}
