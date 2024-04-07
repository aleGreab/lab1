/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alexandragreab
 */

public class Account {
    
    public String owner;
    public String iban = "";
    public double balance = 0; //Double amount = 0.0; Integer x = -1;
    public String moneda = "";
    
    private String cnp = "";
    
    public static int AccountCounter = 0;
    
    public static int count = 0;
   
    public Account()
    {
        this.owner = "undefined owner";
        this.iban = "undefined iban";
        this.balance = 0;     
        this.cnp = "";
        count++;
    }
    
    public Account(int initialBalance)
    {
        this.owner = this.owner + "Test";
        this.balance += initialBalance;
        this.iban  = "";
        count++;
    }
    
    public Account(String owner, String moneda)
    {
        this.owner = owner;
        this.moneda = moneda;
        this.iban = "";
        count++;
    }
    
    public void credit(double amount)
    {
        this.balance = this.balance + amount;
        
        this.printNewBalance();
    }
    
    public void debit(double amount)
    {
        this.balance -= amount;
        
        this.printNewBalance();
    }
    
    public void openAccount(String owner, String moneda)
    {
        this.processOpenAccount(owner, moneda, 0);
        
        AccountCounter++;
    }
    
    private void processOpenAccount(String owner, String moneda, double balance)
    {
        this.moneda = moneda;
        this.owner = owner;
        this.balance = balance;
        this.iban = ((Integer)new Random().nextInt()).toString();
        
        System.out.println("New account iban: " + this.iban);
        
    }
    
    private void processOpenAccount(String owner, double balance, String moneda)
    {
        this.moneda = moneda;
        this.owner = owner;
        this.balance = balance;
        this.iban = ((Integer)new Random().nextInt()).toString();
        
         System.out.println("New account iban: " + this.iban);
    }
    
    public void openAccount(String owner, String moneda, double balance)
    {
        this.processOpenAccount(owner, moneda, balance);
        
        AccountCounter++;
    }     
    
    private void printNewBalance()
    {
        System.out.println("New balance: " + this.balance);
    }
    
    public static void getMonthlyCommission(Account account)
    {
        account.debit(10);
    }    
}

class PersonalAccount extends Account
{
    public PersonalAccount(String owner, String moneda)
    {
        super(owner, moneda);
    }
}

class BusinessAccount extends Account
{
    public BusinessAccount(String owner, String moneda)
    {
        super(owner, moneda);
    }
}
