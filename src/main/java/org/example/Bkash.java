package org.example;

import java.util.Scanner;

public class Bkash
{
    private BkashUser[] users = new BkashUser[100];
    private int userCount = 0;
    private Scanner scanner = new Scanner(System.in);
    public BkashUser findUserByPhoneNumber(String phoneNumber)
    {
        for (int i = 0; i < userCount; i++)
        {
            if (users[i].getPhoneNumber().equals(phoneNumber))
                return users[i];
        }
        return null;
    }

    public void registerUser(String phoneNumber)
    {
        if (findUserByPhoneNumber(phoneNumber) == null)
        {
            String pin;
            while (true)
            {
                System.out.print("Enter PIN (must be 4 digits): ");
                pin = scanner.nextLine();
                if (pin.length() == 4 && pin.matches("\\d+"))
                    break;
                else
                    System.out.println("PIN must be 4 digits. Please try again.");
            }
            users[userCount++] = new BkashUser(phoneNumber, pin);
            System.out.println("Sign Up successful!");
        }
        else
            System.out.println("Already signed in with this phone number.");
    }

    public BkashUser signIn(String phoneNumber, String pin)
    {
        BkashUser user = findUserByPhoneNumber(phoneNumber);
        if (user != null && user.verifyPin(pin))
            return user;
        else
        {
            System.out.println("Invalid phone number or PIN.");
            return null;
        }
    }

    public void launch()
    {
        while (true) {
            System.out.println("\nbKash");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    registerUser(phoneNumber);
                    break;
                case "2":
                    System.out.print("Enter phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    BkashUser user = signIn(phoneNumber, pin);
                    if (user != null)
                        mainMenu(user);
                    break;
                case "3":
                    System.out.println("Thank you for using bKash!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void mainMenu(BkashUser user)
    {
        while (true)
        {
            System.out.println("\nbKash");
            System.out.println("1. Cash In");
            System.out.println("2. Send Money");
            System.out.println("3. Log Out");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    System.out.print("Enter Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter PIN to confirm: ");
                    String pin = scanner.nextLine();
                    user.cashIn(amount, pin);
                    break;
                case "2":
                    System.out.print("Enter Receiver bKash Account No: ");
                    String receiverAccount = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter PIN to confirm: ");
                    pin = scanner.nextLine();
                    user.sendMoney(receiverAccount, amount, pin);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
