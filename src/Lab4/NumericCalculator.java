/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author alexandragreab
 */
public class NumericCalculator {    
    
    // compozitie intre tipul double si NumericCalculator
    // e compozitie pt ca e asociat tot timpul cu clasa NumericCalculator!
    // relatie de tip 1 la n pt ca am un singur tip (double) si pot stoca n numere
    private double[] numbers; // se poate folosi in orice clasa pt e declarat global
    
    public NumericCalculator()
    {
        numbers = new double[0];
    }
    
    public NumericCalculator(double nr1, double nr2)
    {        
        this.numbers = new double[2];        
        numbers[0] = nr1;
        numbers[1] = nr2;
    }
    
    public NumericCalculator(double[] nrs)
    {
        numbers = nrs;
    }
    
    public Double Sum()
    {
        if (this.numbers.length >= 2)
        {
            double sum = 0.0;
            
            // sintaxa foreach
            for (double x : numbers)
            {
                sum = sum + x;
            }
            
            return sum;
        }
        else
        {
            System.err.println("Insuficient numbers");
            return null;
        }    
    }   
    
    public Double Multiply()
    {
        if (this.numbers.length >= 2)
        {
            double multiplication = 1.0;
            
            for (double z : numbers)
            {
                multiplication *= z;
            }
            return multiplication;
        }
        else
        {
           System.err.println("Insuficient numbers");
           return null; 
        }
    }
    
    public void AddNumber(double nr)
    // adaug elem la finalul array-ului
    {
        double[] newArray = new double[numbers.length + 1];
        // mai sus nu e compozitie, ci e relatie de asociere !!!
        // newArray e asociat doar temporar cu clasa NumericCalculator
        
        for (int i = 0; i < numbers.length; i++)
        {
            newArray[i] = numbers[i];
        }
        
        // pe ultima pozitie actuala adaug nr nou
        newArray[numbers.length] = nr;
        
        this.numbers = newArray;
    }
    
    public void RemoveNumber(double nr1)
    // caut in array nr si daca il gasesc il elimin
    {
        double[] newArray = new double[numbers.length - 1];
        
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] != nr1)
                newArray[i] = numbers[i];
        }
        
        this.numbers = newArray;
    }
    
    public int FindNumber(double nr)
    // gasire elem si returnez pozitia sa
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == nr)
                return i;
        }
        
        return -1;
    }
    
    public double GetNumber(int i)
    // verific daca pozitia e in limitele array-ului si returnez nr de pe pozitia i
    {
        if (i >=0 && i < numbers.length)
            return numbers[i];
        else
            return Double.NaN;
    }
}
