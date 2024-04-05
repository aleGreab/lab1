/*
* Creati o aplicatie care modeleaza activitatea unei banci. Banca are de asemenea mai multe sucursale.
* Fiecare sucursala are mai multi operatori angajati. Fiecare operator poate sa deschida si sa inchida un cont, 
* si fiecare operator gestioneaza o colectie de conturi personale si de business. 
* Conturile pot fi de 2 tipuri: PersonalAccount sau BusinessAccount
* Operatorii dintr-o sucursala pot fi de asemenea de doua tipuri: OpearatorFrontOffice si OperatorBackOffice. O sucursala are 
* un operator back office si mai multi de tip front office.
*Operatorii FrontOffice pot sa deschida, sa inchida, sa debiteze si sa crediteze sume in conturile bancare.
*Operatorii BackOffice mai pot sa autorizeze si sa proceseze sumele din conturile colectoare indiciduale. Fiecare operator 
* are un cont colector asociat.
*Implementati in BankApp urmatoarele functionalitati:
    x 1. Angajarea unui operator intr-o sucursala
    x 2. Deschiderea unui cont personal de catre un operator
    x 3. Inchiderea unui cont personal de catre un operator
    4. Deschiderea unui cont de business de catre un operator
    5. Inchiderea unui cont de business de catre un operator
    6. Cautarea unui cont dupa iban si afisarea sumelor de pe credit si debit.
    x 7. Un operator poate fi intr-o zi operator front office iar in alta zi operator back office. Implementati un mecanism 
       de schimbare a tipului de operator din front desk in back office intr-o sucursala.
    8. Implementati un mecanism 
       de schimbare a tipului de operator din back office in front office intr-o sucursala.

    9. Un cont poate fi convertit din personal in business si invers. Implementati un astfel de mecanism de conversie din cont personal
      in cont business.
    
    10. Implementati un astfel de mecanism de conversie din cont business
      in cont personal.

*/

package Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexandragreab
 */

public class BankApp {

    /**
     * @param args the command line arguments
     */
    
    static Banca banca;
    static Sucursala sucursala1;
    static Sucursala sucursala2;
    
    public static void main(String[] args) throws IOException {
        
        banca = new Banca("Banca virtuala");
        banca.setAdresa("Str. T. Mihali, Nr. 30");
        
        sucursala1 = new Sucursala("S1", banca.numeBanca);
        sucursala1.setAdresa("Str. Memorandumului, Nr. 1");
        sucursala2 = new Sucursala("S2", banca.numeBanca);
        sucursala2.setAdresa("Str. Busuresti, Nr.10");
        
        System.out.println("Welcome to "+ banca.numeBanca + ". Adresa: " + banca.getSediu());
        
        System.out.println("Optiuni: 0.Exit|1.Angajeaza operator| 2. Deschide cont personal | 3. Inchide cont personal | 4.Deschide cont business | \n" +
              " 5. Inchide cont de business | 6. Cauta cont dupa iban | 7. Desemnare operator back office din front office | 8. Desemnare operator front office din back office | \n" + 
                "9. Conversie cont personal in business | 10.Conversie cont business in personal");
        
        int option = 0;
        
        do
        {        
            String inputn = ReadConsole("Introduceti o optiune din meniu: ");
                
            option = Integer.parseInt(inputn);
            
            Menu(option);
            
        }while (option != 0);
        
    }
    
    private static void Menu(int option) throws IOException
    {
        switch (option)
        {
            case 1:
                String nume = "";
                do
                {
                    nume = ReadConsole("Nume operator(enter to cancel): ");
                    if ("".equals(nume))
                        break;
                    
                    String id = ReadConsole("ID/Marca: ");
                    
                    Operator newOperator;
                    if (Integer.parseInt(id) % 2 == 0)
                      newOperator = new OperatorFrontOffice(nume, id);
                    else
                        newOperator = new OperatorBackOffice(nume, id);

                    int sucursala = Integer.parseInt(ReadConsole("Sucursala: "));
                    if (sucursala == 1)
                        sucursala1.angajeazaOperator(newOperator);
                    else if (sucursala == 2)
                        sucursala2.angajeazaOperator(newOperator);

                     System.out.println("Operator nou angajat!");
                }while (!"".equals(nume));
                
                break;
            case 2:              
                int sucursala = Integer.parseInt(ReadConsole("Sucursala: "));
                
                Sucursala unitateBancara = null;
                if (sucursala == 1)
                    unitateBancara = sucursala1;
                else if (sucursala == 2)
                    unitateBancara = sucursala2;
                
                Operator operatorAsignat = unitateBancara.assignOperatorFrontOfficeForTask();
                
                String numeTitular = ReadConsole("Nume titular: ");
                String moneda = ReadConsole("Moneda: ");                
                operatorAsignat.createPersonalAccount(numeTitular, moneda); 
                break;
            case 3:
                sucursala = Integer.parseInt(ReadConsole("Sucursala: "));
                
                unitateBancara = null;
                if (sucursala == 1)
                    unitateBancara = sucursala1;
                else if (sucursala == 2)
                    unitateBancara = sucursala2;
                
                operatorAsignat = unitateBancara.assignOperatorFrontOfficeForTask();                               
                
                String iban = ReadConsole("IBAN cont: ");                
                Account account = operatorAsignat.Find(iban);
                
                if (account != null)
                {
                    operatorAsignat.Remove(account);
                    System.out.println("Account removed!");
                }
                else
                {
                    System.out.println("Account not found at this operator");
                    
                    for (Operator op : banca.operatoriBanca)
                    {
                        account = op.Find(iban);
                        if (account != null)
                        {
                            op.Remove(account);
                            System.out.println("Account removed!");
                        }else 
                            System.err.println("Account not found!");
                    }
                
                }
                break;               
            case 7:
                sucursala = Integer.parseInt(ReadConsole("Sucursala: "));
                
                unitateBancara = null;
                if (sucursala == 1)
                    unitateBancara = sucursala1;
                else if (sucursala == 2)
                    unitateBancara = sucursala2;
                
                if ( unitateBancara.getOperatorBackOffice() != null)
                    System.out.println("Current backoffice operator is: " + unitateBancara.getOperatorBackOffice().nume);
                
                Operator operatorFront = unitateBancara.assignOperatorFrontOfficeForTask();
                
                if (operatorFront.canDoBackOffice())
                    unitateBancara.SetOperatorbackOffice(operatorFront);             
                
                if ( unitateBancara.getOperatorBackOffice() != null)
                    System.out.println("New backoffice operator is: " + unitateBancara.getOperatorBackOffice().nume);
                
                break;
        }
    }
        
    private static String ReadConsole(String messageToShow) throws IOException
    {
        System.out.println(messageToShow);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }  
    
}

