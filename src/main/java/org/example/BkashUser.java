package org.example;

public class BkashUser
{
    private String phoneNumber;
    private String pin;
    private double balance;

    public BkashUser(String phoneNumber, String pin)
    {
        this.phoneNumber = phoneNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setBalance(double amount)
    {
        this.balance = amount;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public boolean verifyPin(String enteredPin)
    {
        return this.pin.equals(enteredPin);
    }

    public void cashIn(double amount, String pin)
    {
        if (amount > 0 && verifyPin(pin))
        {
            this.balance += amount;
            System.out.println("Cash In Successful! Current balance: Tk " + this.balance);
        }
        else
            System.out.println("Cash In failed. Incorrect PIN or invalid amount.");
    }

    public void sendMoney(String receiverAccount, double amount, String pin)
    {
        if (amount > 0 && this.balance >= amount && verifyPin(pin))
        {
            this.balance -= amount;
            System.out.println("Send Money to: " + receiverAccount);
            System.out.println("Amount: Tk " + amount);
            System.out.println("Transaction Successful!");
            displayBalance();
        }
        else
            System.out.println("Transaction Failed. Insufficient balance or incorrect PIN.");
    }

    public void displayBalance()
    {
        System.out.println("Current Balance: Tk " + this.balance);
    }
}
