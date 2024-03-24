/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import lab2.*;

/**
 *
 * @author alexandragreab
 */

public class NumericCalculator {    
    
    double number1;
    double number2;
    
    // array de tip double pt a stoca nr pe care vrem sa le adunam
    double[] numbers;
    // array de tip double pt a stoca nr pe care vrem sa le inmultim
    double [] multiplyNr;
    
    static int nrOperations = 0;
    
    // constructor default
    public NumericCalculator()
    {}
    
    public NumericCalculator(double nr1, double nr2)
    // constructor cu 2 parametrii pt sum
    {
        this.number1 = nr1;
        this.number2 = nr2;
        
        this.numbers = new double[2];        
        numbers[0] = nr1;
        numbers[1] = nr2;
    }
    
    
    public NumericCalculator(double[] nrs)
    {
        this.numbers = nrs;
    }
        
    public double Sum(double n1, double n2)
    {
        nrOperations++;
        
        return n1 + n2;
    }
    
    public Double Sum()
    {
        if (this.numbers.length == 2)
        {
            nrOperations++;
            return this.number1 + this.number2;
        }
        else if (this.numbers.length > 2)
        {
            double sum = 0.0;
            for (int i = 0; i < numbers.length; i++)
            {
                sum += numbers[i];
                
                nrOperations++;
            }
            
            return sum;
        }
        else
        {
            System.err.println("Insuficient numbers");
            return null;
        }
    } 
    
    // multiply 2 numbers
    public Double Multiply(double n1, double n2)
    {
        nrOperations++;
        return n1 * n2;
    }
    
    // multiply more than 2 numbers
    public Double Multiply(double[] nrs)
    {
        // initializare in metoda
        this.multiplyNr = nrs;
        
        if (this.multiplyNr == null) 
        {
            System.out.println("multiplyNr nu a fost initializat.");
            return null;
        }
        
        if (this.multiplyNr.length == 2 )
        {
            nrOperations++;
            return this.multiplyNr[0] * this.multiplyNr[1];
        }
        else if (this.multiplyNr.length > 2)
        {
            double multiplication = 1.0;
            
            // foreach i in multiply array
            for (double i : multiplyNr)
            {
                multiplication *= i;
                
                nrOperations++;
            }
            
            return multiplication;
        }
        else 
        {
            System.out.println("Insuficient nr");
            return null;
        }
    }
    
    
    public static int GetNumberOfOperations()
    {
      return nrOperations;   
    }   
    
}
