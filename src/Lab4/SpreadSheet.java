/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author alexandragreab
 */
public class SpreadSheet {
    
    public String name;
    
    // clasa SpreadSheet face compozitie cu CellRange
    private CellRange activeRange; // poate fi mereu doar 1
    
    public CellRange activeSelection = null; // de obicei nu pot selecta mai multe celule simultan
    
    public SpreadSheet(String name)
    {
        this.name = name;
        this.activeRange = new CellRange();
    }
    
    public SpreadSheet(String name, CellRange activeRange)
    {
        this.name = name;
        this.activeRange = activeRange;
    }
    
    public void SetActiveRange(CellRange range)
    {
        this.activeRange = range;
        // setam selectia ca fiind bold
        BoldSelection();
    }
    
    public void BoldSelection(){
        if (activeSelection != null)
        {
            for (Cell c : activeSelection.cells)
            {
                c.Bold();
            }
        }
    }
    
    public CellRange GetActiveRange()
    {
        return this.activeRange;
    }
    
    public void SelectRange(CellRange cellRange)
    {
        this.activeRange = cellRange;
    }
    
    public CellRange createCellRange(int n) {
        if (n <= activeRange.size()) {
            CellRange newRange = new CellRange();
            for (int i = 0; i < n; i++) {
                newRange.AddCell(activeRange.getCell(i));
            }
            return newRange;
        } else {
            System.err.println("Nr e mai mare decat lungimea activeRange");
            return null;
        }
    }
    
}

