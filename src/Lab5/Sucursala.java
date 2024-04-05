/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alexandragreab
 */

public class Sucursala extends Banca
{   
   protected String numeEntitate = "";
   
   private ArrayList<Operator> operatoriSucursala = new ArrayList<Operator>();
   
   private OperatorBackOffice operatorBackOffice = null;
    
   public Sucursala(String numeEntitate, String numeBanca)
   {
      super(numeBanca, "Sediu");
      this.numeEntitate = numeEntitate;  
     
   }
   
    @Override
   public void angajeazaOperator(Operator operator)
   {
      super.angajeazaOperator(operator);
      
      this.operatoriSucursala.add(operator);
   }
   
   public Operator assignOperatorFrontOfficeForTask()
   {
       int index = (new Random()).nextInt(operatoriSucursala.size());
       
       return operatoriSucursala.get(index);
   }
   
   public void SetOperatorbackOffice(Operator operator)
   {
       if (!operator.canDoBackOffice())
           return;
       
       if (this.operatorBackOffice != null)
       {
           operatoriSucursala.add(this.operatorBackOffice);
       }
       
       this.operatorBackOffice = (OperatorBackOffice)operator; //downcasting#
       
       operatoriSucursala.remove(operator);
   }
   
   public Operator getOperatorBackOffice()
   {
       return this.operatorBackOffice;
   }
}

