/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexandragreab
 */

public class Calculator {
    
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to calculator. Read n numbers and then select an operation");      
       
        System.out.println("How many numbers: ");
        String inputn = ReadConsole();
                
        int n = Integer.parseInt(inputn);
                
        NumericCalculator calculator1 = new NumericCalculator();
                
       for (int count = 1; count <= n; count++)
       {
           System.out.print("Number " + count + ": ");
           String newNumber = ReadConsole();
           double numberToAdd = Double.parseDouble(newNumber);
                    
           calculator1.AddNumber(numberToAdd);
        }
        
       System.out.println("Select an option: 1. Add multiple numbers | 2. Multiply several numbers ");
       
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        double result = 0;
        
        if (option == 1)
        {
          double calculation = calculator1.Sum();
          
          System.out.println("Sum of numbers: " + calculation);
          
        }else if (option == 2)
        {
         //here goes second case
            double calc = calculator1.Multiply();
            
            System.out.println("Multiplication of nr: " + calc);
        }else
        {
            System.err.println("Optiunea nu exista!");
        }
        
    }

    private static String ReadConsole() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }  
   
}

