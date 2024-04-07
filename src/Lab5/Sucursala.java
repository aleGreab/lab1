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
   
   private OperatorFrontOffice operatorFront = null;
    
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
   
   public Operator assingOprBackOfficeForTask()
   {
       int ind = (new Random()).nextInt(operatoriSucursala.size());
       return operatoriSucursala.get(ind);
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
   
   public void SetOperatorFrontOffice(Operator operator)
   {
       // verific daca operatorul poate face back office
       if (operator.canDobackOffice)
       {
           System.out.println("Operatorul nu poate fi mutat in FrontOffice!");
       }
       else 
       {
            // verificam daca exista operatori back office in sucursala
            if (operatorBackOffice != null)
            {
                // adaug operatorul in lista operatorilor
                operatoriSucursala.add(operatorBackOffice);
                // stergem operatorul 
                //operatorBackOffice = null;
                operatoriSucursala.remove(operator);
            }
            
            // adaug operatorul in front office
            operatoriSucursala.add(operator);
       }
       
   }
   
   public Operator getOperatorFront()
   {
       return this.operatorFront;
   }
   
   public Operator getOperatorBackOffice()
   {
       return this.operatorBackOffice;
   }
}
