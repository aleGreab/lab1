/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.util.ArrayList;

/**
 *
 * @author alexandragreab
 */

class Cell {
    public String value;
    public int row = 0;
    public char column;
    
    public Cell()
    {
        value = "";
        row = 1;
        column = 'A';
    }
    
    public Cell(String value, int row, char column)
    {
        this.value = value;
        this.row = row;
        this.column = column;
    }
}

public class CellRange {
    
    // array de celule
    public ArrayList<Cell> cells = new ArrayList<Cell>();
    public int startRow;
    public int startColumn;
    public int endRow;
    public int endColumn;
    
    public CellRange(ArrayList<Cell> cells, int startRow, int startColumn, int endRow, int endColumn) 
    {
        this.cells = cells;
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
    }
    
    // metoda pt calcularea sumei celulelor din range
    public double RangeSum()
    {
        double sum = 0;
        for(int i = startRow; i <= endRow; i++)
        {
            for(int j = startColumn; j <= startColumn; j++)
            {
                // calc suma din interval
                sum += Double.parseDouble(cells.get(i * (endColumn - startColumn + 1) + j).value);
            }
        }
        
        return sum;
    }
    
    // metoda pt calculul produsului celulelor din range
    public double RangeProduct()
    {
        double product = 1;
        for (int i = startRow; i <= endRow; i++)
        {
            for (int j = startColumn; j <= endColumn; j++)
            {
                // calc produsul celulelor din interval
                product *= Double.parseDouble(cells.get(i * (endColumn - startColumn + 1) + j).value);
            }
        }
        
        return product;
    }
    
}
