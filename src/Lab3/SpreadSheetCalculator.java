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


class Cell {
    String value;
    
    int row = 0;    
    char column;
    
    static int totalCells = 0;
    
    public Cell()
    {
        value = "";
        row = 1;
        column = 'A';
        
        totalCells++;
    }
    
    public Cell(String value, int row, char column)
    {
        this.value = value;
        this.row = row;
        this.column = column;
        
        totalCells++;
    }
    
}

public class SpreadSheetCalculator{
    
    // initializare variabila statica pt numararea operatiilor
    static int nrOfOperations = 0;
    
    public Cell Sum(Cell c1, Cell c2)
    {
       Double result = Double.parseDouble(c1.value) + Double.parseDouble(c2.value);
        
        Cell cellResult = new Cell(result.toString(), c1.row, 'R');
       // cellResult.value = result.toString(); - no need
       nrOfOperations++;
        
        return cellResult;
    }
    
    public Cell MultipleSumCells(Cell [] cells)
    {
        double sum = 0;
        
        for (Cell c: cells)
        {
            sum += Double.parseDouble(c.value);
        }
        
        Cell result = new Cell(String.valueOf(sum), 0,'R');
        nrOfOperations++;
        
        return result;
    }
    
    public Cell ProductOf2(Cell c1, Cell c2)
    {
        Double rezult = Double.parseDouble(c1.value) * Double.parseDouble(c2.value);
        Cell cellRezult = new Cell(rezult.toString(), c1.row, 'R');
        nrOfOperations++;
        
        return cellRezult;
    }
    
    public Cell MultipleProduct(Cell [] cellArray)
    {
        double product = 1;
        
        for (Cell c : cellArray)
        {
            product *= Double.parseDouble(c.value);
        }
        
        Cell rezult = new Cell(String.valueOf(product), 0, 'R');
        nrOfOperations++;
        
        return rezult;
    }
    
    public void Increment(Cell c1)
    {
        Double convertedValue = Double.parseDouble(c1.value);
        
        convertedValue++;
        
        c1.value = convertedValue.toString();
   }
    
    public static int GetNrOfOperations()
    {
      return nrOfOperations;   
    }  
}


