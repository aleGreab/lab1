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
public class SpreadSheetCalculator{
    
     public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to spreadsheet calculator. Read n numbers and in the cells, then select an operation");      
        
        System.out.println("How many numbers: ");
        String inputn = ReadConsole();
                
        int n = Integer.parseInt(inputn);
                
        SpreadSheet sheet = new SpreadSheet("Calculations");
        
        CellRange range = new CellRange();
                
       for (int count = 1; count <= n; count++)
       {
           System.out.print("Cell  " + count + ": ");
           String newNumber = ReadConsole();
                    
           range.AddCell(new Cell(newNumber, count, 'A'));
        }
       
       sheet.SetActiveRange(range);
        
       System.out.println("Select an option: 1. Add multiple cells | 2. Multiply multiple cells "
               + "| 3. Select a sub-range of the active range | 4. Sum of cell numbers with NumericCell ");
       
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        double result = 0;
        
        if (option == 1)
        {
          Cell sumCell = sheet.GetActiveRange().Sum();
          
          System.out.println("Sum of numbers: " + sumCell.value);
          
        }else if (option == 2)
        {
         //here goes second case
            Cell multiplyCell = sheet.GetActiveRange().Multiply();
            
            System.out.println("Multiply of nr: " + multiplyCell.value);
        }
        else if (option == 3)
        {
            System.out.println("Enter the nr of cells for the sub-range:");
            
            String subrangeSize = ReadConsole();
            int subRangeSize = Integer.parseInt(subrangeSize);
            
            CellRange subRange = sheet.createCellRange(subRangeSize);
            
            if (subRange != null) 
                {
                    sheet.activeSelection = subRange;
                    
                    for (Cell c : subRange.cells)
                    {
                        if (!c.isBolded())
                        {
                           System.out.println("Cell bolded"); 
                        }
                        else 
                        {
                           System.out.println("Cell not bolded"); 
                        }
                    }
                }
        
        }
        else if (option == 4) 
        {
            NumericCell sumCell = sheet.GetActiveRange().NewSum(); 
            // folosim NumericCell in loc de Cell
            System.out.println("Sum of cell nr: " + sumCell.numericValue);
        } 
        else 
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

