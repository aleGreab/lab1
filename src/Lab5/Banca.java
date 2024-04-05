/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author alexandragreab
 */

public class Banca {
    
    public String numeBanca = "Bank";
    
    private String sediu;
    
    protected ArrayList<Operator> operatoriBanca = new ArrayList<Operator>();
    
    public Banca()
    {
        this.numeBanca = "";
    }
    
    public Banca(String numeBanca)
    {
        this.numeBanca = numeBanca;
    }
    
    public Banca(String numeBanca, String sediu)
    {
        this.numeBanca = numeBanca;
        this.sediu = sediu;
    }
    
    public void setAdresa(String sediu)
    {
        this.sediu = sediu;
    }
    
    public String getSediu()
    {
        return this.sediu;
    }
    
   protected void angajeazaOperator(Operator operator)
   {
        operatoriBanca.add(operator);
   }
  
}
