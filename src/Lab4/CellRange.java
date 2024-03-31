/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.util.ArrayList;

/**
 *
 * @author alexandragreab
 */
class Cell {
    public String value;   
    
    public int row = 0;    
    public char column;
    
    private boolean bolded = false; // pt marcarea celulei - boldare
    
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
    
    public void Clear() // golseste celula de valori
    {
       value = "";
    }
    
    public void Bold()
    {
        bolded = true;
    }
    
    public void Unbold()
    {
        bolded = false;
    }
    
    public boolean isBolded()
    {
        return bolded;
    }
        
}

class NumericCell extends Cell
// NumericCell e mai specifica, contine tot ce are clasa Cell plus alte metode si atribute proprii
{
    public double numericValue;
    
    private int decimalPlaces = 2;
    
    public NumericCell(Double nr, int row, char column)
    {
        super(nr.toString(), row, column);
        // cu super apelez constructorul clasei de baza!
        
    }
    
}

public class CellRange {
    // compozitie intre cell si cellRange pt ca cellRange are mai multe celule
    // deci pun un array sau o colectie de celule
    // relatie de tip 1 la n
    
    public ArrayList<Cell> cells = new ArrayList<Cell>();
    
    public NumericCell NewSum() {
        double sum = 0.0;
        int maxRow = 0;
        
        for (Cell c : cells) {
            if (c instanceof NumericCell) {
                // convertim celula la NumericCell
                NumericCell numericCell = (NumericCell) c; 
                sum += numericCell.numericValue;
                
                if (numericCell.row > maxRow) {
                    maxRow = numericCell.row;
                }
            }
        }
        return new NumericCell(sum, maxRow + 1, cells.get(0).column);
    }
    
    public void AddCell(Cell cell)
    {
        cells.add(cell);
    }
    
    public void RemoveCell(Cell cell)
    {
        cells.remove(cell);
    }
    
    public int size() {
        return cells.size();
    }
    
    public Cell getCell(int index) {
        if (index >= 0 && index < cells.size()) {
            return cells.get(index);
        } else {
            System.err.println("Indexul e invalid");
            return null;
        }
    }
    
    public Cell Sum()
    {
        Double sum = 0.0;
        int maxrow = 0;
        for (Cell c : cells)
        {
            sum = sum + Double.parseDouble(c.value);
            
            if (c.row > maxrow)
                maxrow = c.row;
        }
        
        Cell result = new Cell(sum.toString(), maxrow+1, cells.get(0).column);
        
        return result;
    }
    
    public Cell Multiply()
    {
        Double multiply = 1.0;
        int maxRows = 0;
        
        for (Cell c : cells)
        {
            multiply *= Double.parseDouble(c.value);
            
            if (c.row > maxRows)
            {
                maxRows = c.row;
            }
        }
        
        Cell rezult = new Cell(multiply.toString(), maxRows+1, cells.get(0).column);
        
        return rezult;
    }
    
}
