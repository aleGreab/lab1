/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import lab2.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author alexandragreab
 */

public class Calculator {
    
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to calculator. Select an option: 1. Add two numbers | 2. Add multiple numbers | 3. Multiply two numbers | 4. Multiply several numbers");
                
        System.out.println("Spreadsheet calculator. Select an option: 5. CellSum of 2 cells | 6. CellSum of multiple cells | 7.CellProduct of 2 cells | 8.CellProduct of multiple cells" );
        
        System.out.println("Cell range operations: 9. RangeSum | 10. RangeProduct");
        
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        double result = 0;
        
        switch(option)
        {
            case 1:
                System.out.println("First number: ");
                String input1 = ReadConsole();
                
                System.out.println("Second number: ");
                String input2 = ReadConsole();
                
                Double x = Double.parseDouble(input1);
                Double y = Double.parseDouble(input2);
                               
                NumericCalculator calculator = new NumericCalculator(x, y);
                // am pus argumente pt ca e constructor si l-am reinitializat
                
                result = calculator.Sum();
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
            case 2:
                System.out.println("How many numbers: ");
                String inputn = ReadConsole();
                
                int n = Integer.parseInt(inputn);
                
                double[] numbers = ReadConsoleNumbers(n);
                
                NumericCalculator calculator1 = new NumericCalculator(numbers);
                
                result = calculator1.Sum();
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
                
            // add code for computing the 2 -> 5 use cases
                
            case 3: 
                // multiply 2 numbers  
                System.out.println("First nr: ");
                String n1 = ReadConsole();
                
                System.out.println("Second nr: ");
                String n2 = ReadConsole();
                
                double a = Double.parseDouble(n1);
                double b = Double.parseDouble(n2);
                
                NumericCalculator calc3 = new NumericCalculator(a, b);
                
                result = calc3.Multiply(a, b);
                
                System.out.println("Rezult is: " + result);
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
                
            case 4:
                // Multiply several numbers
                System.out.println("How many nr: ");
                String input = ReadConsole();
                
                System.out.println("Enter the numbers: ");
                
                int nr = Integer.parseInt(input);
                
                double [] list_nr = ReadConsoleNumbers(nr);
                
                NumericCalculator calc4 = new NumericCalculator(list_nr);
                
                result = calc4.Multiply(list_nr);
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
               
            case 5:
                SpreadSheetCalculator cellCalculator = new SpreadSheetCalculator();
                        
                System.out.println("First cell value:");
                Cell c1 = new Cell("", 1, 'A');                
                c1.value = ReadConsole();
                
                System.out.println("Second cell value:");
                Cell c2 = new Cell("", 2, 'A');                
                c2.value = ReadConsole();
                
                Cell sumResult = cellCalculator.Sum(c1, c2);                
                System.out.println("Sum of cells: " + sumResult.value);
                
                System.out.println("Number of operations: " + SpreadSheetCalculator.GetNrOfOperations());
                                
                break;
                
                // add code for computing 7 and 8 spreadsheet operations
                
            case 6:
                 // CellSum of multiple cells
                
                System.out.println("Enter how many cells: ");
                String maxCells = ReadConsole();
                
                int cells = Integer.parseInt(maxCells);
                
                Cell [] cellArray = new Cell[cells];
                
                for(int i = 0; i < cells; i++)
                {
                    System.out.println("Enter the value for " + (i+1) + " element: ");
                    // create a new cell and add its value
                    cellArray[i] = new Cell("", 0, 'R');
                    cellArray[i].value = ReadConsole();
                }
                
                SpreadSheetCalculator cellCalc = new SpreadSheetCalculator();
                Cell rezult = cellCalc.MultipleSumCells(cellArray);
                
                System.out.println("Sum of cells is: " + rezult.value);
                System.out.println("Number of operations: " + SpreadSheetCalculator.GetNrOfOperations());
                
                break;
            case 7:
                // CellProduct of 2 cells
                SpreadSheetCalculator sheet = new SpreadSheetCalculator();
                
                System.out.println("First cell value: ");
                Cell cell1 = new Cell("", 1, 'A');
                cell1.value = ReadConsole();
                
                System.out.println("Second cell value: ");
                Cell cell2 = new Cell("", 2, 'A');
                cell2.value = ReadConsole();
                
                Cell cellProductResult = sheet.ProductOf2(cell1, cell2);
                System.out.println("Product of 2 is: " + cellProductResult.value);
                System.out.println("Number of operations: " + SpreadSheetCalculator.GetNrOfOperations());
                
                break;
                
            case 8: 
                // CellProduct of multiple cells
                System.out.println("Enter how many cells: ");
                String maxCell = ReadConsole();
                
                int cell8 = Integer.parseInt(maxCell);
                
                Cell [] cell_array = new Cell[cell8];
                
                for (int i = 0; i < cell8; i++)
                {
                    System.out.println("Enter the value for " + (i+1) + " element: ");
                    // create a new cell and add its value
                    cell_array[i] = new Cell("", 0, 'R');
                    cell_array[i].value = ReadConsole();
                }
                
                SpreadSheetCalculator cellSheet = new SpreadSheetCalculator();
                Cell result8 = cellSheet.MultipleProduct(cell_array);
                
                System.out.println("Product of cells is: " + result8.value);
                System.out.println("Number of operations: " + SpreadSheetCalculator.GetNrOfOperations());
                
                break;
                
            case 9:
                // RangeSum
                System.out.println("Enter the nr of rows: ");
                String rowInput = ReadConsole();
                int nrRows = Integer.parseInt(rowInput);
                
                System.out.println("Enter the nr of columns: ");
                String columnInput = ReadConsole();
                int nrColumns = Integer.parseInt(columnInput);
                
                ArrayList<Cell> cellList = new ArrayList<>();
                for (int i = 0; i < nrRows; i++)
                {
                    for (int j = 0; j < nrColumns; j++)
                    {
                       System.out.println("Enter the value for cell [" + i + "][" + j + "]: ");
                        Cell c9 = new Cell("", i, (char)('A' + j));
                        c9.value = ReadConsole();
                        cellList.add(c9);
                    }
                   
                }
                
                CellRange cellRange = new CellRange(cellList, 0, 0, nrRows-1, nrColumns-1);
                double sumRange = cellRange.RangeSum();
                System.out.println("Sum of cell range is: " + sumRange);
                    
                break;
                
            case 10:
                // RangeProduct
                System.out.println("Enter the nr of rows: ");
                String row_input = ReadConsole();
                int nrsRows = Integer.parseInt(row_input);
                
                System.out.println("Enter the nr of columns: ");
                String columnsInput = ReadConsole();
                int nrsColumns = Integer.parseInt(columnsInput);
                
                ArrayList<Cell> cellList2 = new ArrayList<>();
                for (int i = 0; i < nrsRows; i++)
                {
                    for (int j = 0; j < nrsColumns; j++)
                    {
                       System.out.println("Enter the value for cell [" + i + "][" + j + "]: ");
                       Cell c10 = new Cell("", i, (char)('A' + j));
                       c10.value = ReadConsole();
                       cellList2.add(c10);
                    }
                   
                }
                
                CellRange cellRange2 = new CellRange(cellList2, 0, 0, nrsRows-1, nrsColumns-1);
                double productRange = cellRange2.RangeProduct();
                System.out.println("Product of cell range is: " + productRange);
                    
                break;
        }  
        
        System.out.println("Total number of numeric operations: " + NumericCalculator.nrOperations);
        
        System.out.println("Total number of cells used: " + SpreadSheetCalculator.nrOfOperations);
    }
    
    private static double[] ReadConsoleNumbers(int n) throws IOException
    {
        double[] result = new double[n];
        
        for (int count = 0; count < n; count++)
        {
            String input = ReadConsole();
            result[count] = Double.parseDouble(input);
        }
        
        return result;
    }

    private static String ReadConsole() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }    
}
