/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static lab2.Fibonacci.generateFibonacci;

public class Calculator {
    
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to calculator. Select an option: 1. Add | 2.Substract | 3. Divide | 4. Multiply | 5. Modulo");
        
        System.out.println("Spreadsheet calculator. Select an option: 6. CellSum | 7. CellIncrement | 8.CellDecrement" );
        
        System.out.println("Fibonacci sequence. Option 9");
        
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        NumericCalculator numericOperations = new NumericCalculator();
        SpreadSheetCalculator cellOperations = new SpreadSheetCalculator();
        
        double result = 0;
        
        switch(option)
        {
            case 1:
                System.out.println("First number: ");
                String input1 = ReadConsole();
                
                System.out.println("Second number: ");
                String input2 = ReadConsole();
                
                double x = Double.parseDouble(input1);
                double y = Double.parseDouble(input2);
                
                result = numericOperations.Sum(x, y);
                
                System.out.println("Result:" + result);
                
                break;
            case 2: 
                System.out.println("First number: ");
                String first_nr = ReadConsole();
                
                System.out.println("Second number: ");
                String second_nr = ReadConsole();
                
                double x1 = Double.parseDouble(first_nr);
                double y1 = Double.parseDouble(second_nr);
                
                result = numericOperations.Difference(x1, y1);
                
                System.out.println("Result: " + result);
                
                break;
                
               // case 3 -  divide
            
            case 3: 
                System.out.println("First nr: ");
                String first = ReadConsole();
                
                System.out.println("Second nr: ");
                String second = ReadConsole();
                
                double X = Double.parseDouble(first);
                double Y = Double.parseDouble(second);
                
                result = numericOperations.Divide(X, Y);
                
                System.out.println("Rezult is: " + result);
                
                break;
                
                // case 4 - mutiply
                
            case 4:
                System.out.println("First nr: ");
                String one = ReadConsole();
                
                System.out.println("Second nr: ");
                String two = ReadConsole();
                
                double z = Double.parseDouble(one);
                double w = Double.parseDouble(two);
                
                result = numericOperations.Multiply(z, w);
                
                System.out.println("Rezult is: " + result);
                
                break;
                
                // case 5 - modulo
                
            case 5:
                System.out.println("First nr: ");
                String nr1 = ReadConsole();
                
                System.out.println("Second nr: ");
                String nr2 = ReadConsole();
                
                double a = Double.parseDouble(nr1);
                double b = Double.parseDouble(nr2);
                
                result = numericOperations.Modulo(a, b);
                
                System.out.println("Result is : " + result);
                
                break;
                
            case 6:
                System.out.println("First cell value:");
                Cell c1 = new Cell();                
                c1.value = ReadConsole();
                
                System.out.println("Second cell value:");
                Cell c2 = new Cell();                
                c2.value = ReadConsole();
                
                Cell sumResult = cellOperations.Sum(c1, c2);                
                System.out.println("Sum of cells: " + sumResult.value);
                
                cellOperations.Increment(c1);
                cellOperations.Increment(c2);
                cellOperations.Increment(c2);
                System.out.println("Incremented cell 1: " + c1.value);
                
                System.out.println("Incremented cell 2: " + c2.value);
                
                break;
                
                // add code for computing 7 and 8 spreadsheet operations
                
                // case 7 - cell increment
                                
            case 7: 
                System.out.println("Cell to increment value ");
                Cell cellToIncrement = new Cell();                
                cellToIncrement.value = ReadConsole();
                cellOperations.Increment(cellToIncrement);
                System.out.println("Incremented cell value: " + cellToIncrement.value);
                break;
              
                // case 8 - cell decrement
             
            case 8:
                System.out.println("Cell to decrement value ");
                Cell cellToDecrement = new Cell();                
                cellToDecrement.value = ReadConsole();
                cellOperations.Decrement(cellToDecrement);
                System.out.println("Decremented cell value: " + cellToDecrement.value);
                break;
                
                // sirul lui Fibonacci 
            case 9:
                System.out.println("Enter the lenght of Fibonacci sequence: ");
                String inputLenght = ReadConsole();
                int lenght = Integer.parseInt(inputLenght);
                
                int [] fibonacciSequence = generateFibonacci(lenght);
                System.out.println("Fibonacci sequence: ");
                
                // afisam sirul cu un spatiu intre elemente
                for (int nr:fibonacciSequence){
                    System.out.println(nr + " ");
                }
                
                break;
        }  
    }

    private static String ReadConsole() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }    
}
