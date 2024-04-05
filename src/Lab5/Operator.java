/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.util.ArrayList;

/**
 *
 * @author alexandragreab
 */
public class Operator {
    
    public String nume;
    public String identificator;
    
    private int businessAccountsCounter = 0;
    
    private Account collectorAccount = new Account();
    
    public Account[] businessAccounts = new Account[10];
    
    public ArrayList<Account> personalAccounts = new ArrayList<Account>();
    
    protected boolean canDobackOffice = false;
    
    public Operator(){} //needed for extended classes to have a default oeprator
    
    public Operator(String nume, String id)
    {
        this.nume = nume;
        identificator = id; 
    }
    
    public Operator(String nume, String id, double balanceToProcess)
    {
        this.nume = nume;
        identificator = id;
        this.collectorAccount.balance = balanceToProcess;        
    }   
    
    public void Remove(Account a)
    {
        personalAccounts.remove(a);
    }
    
    public Account Find(String iban)
    {
        for (Account a : this.personalAccounts)
        {
            if (a.iban.equals(iban))
                return a;
        }
        
        for (int i = 0; i<businessAccounts.length; i++)
        {
            if (businessAccounts[i] != null && businessAccounts[i].iban.equals(iban))
                return businessAccounts[i];
        }   
        
        return null;
    }
    
    public void createPersonalAccount(String owner, String moneda)
    {
        PersonalAccount account = new PersonalAccount(owner, moneda);
        account.openAccount(owner, moneda);
        personalAccounts.add(account);  //upcasting
    }
    
    public void createBusinessAccount(String owner, String moneda, double sum)
    {   
        if (businessAccountsCounter >= 10)
        {
            System.err.println("Business accounts limit reached for this operator");
            return;
        }
        
        if (sum > 100)
        {
            Account a = new BusinessAccount(owner, moneda); //upcasting
            a.openAccount(owner, moneda, sum);
            businessAccounts[businessAccountsCounter] = a;
            businessAccountsCounter++;
        }
        else
           System.err.println("Suma minima trebuie sa fie 100");
    }
    
    public boolean canDoBackOffice()
    {
        return this.canDobackOffice;
    }
    
}

class OperatorFrontOffice extends Operator
{
    public OperatorFrontOffice(String nume, String id)
    {
        super(nume, id);
        
        super.canDobackOffice = false;
    }
    
    public void SayHello()
    {
        System.out.println("Hello, how can I help you?");
    }
}

class OperatorBackOffice extends Operator
{    
    public OperatorBackOffice(String nume, String id)
    {
        super(nume, id);
        
        super.canDobackOffice = true;
    }
   
    
    public void Approve()
    {
        System.out.println("I am here to process transactions...");
    }
}
