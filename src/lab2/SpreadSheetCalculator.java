/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

class Cell {
    String value;
}

public class SpreadSheetCalculator{
    
    public Cell Sum(Cell c1, Cell c2)
    {
        Cell cellResult = new Cell();
        Double result = Double.parseDouble(c1.value) + Double.parseDouble(c2.value);
        
        cellResult.value = result.toString();
        
        return cellResult;
    }
    
    public void Increment(Cell c1)
    {
        Double convertedValue = Double.parseDouble(c1.value);
        
        convertedValue++;
        
        c1.value = convertedValue.toString();
    }
    
    public void Decrement(Cell c1)
    {
        Double convertedValue = Double.parseDouble(c1.value);
        
        convertedValue--;
        c1.value = convertedValue.toString();
    }
}

