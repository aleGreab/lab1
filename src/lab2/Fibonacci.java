/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author alexandragreab
 */
public class Fibonacci {
    
    static void printFib(int n)
    {
        if (n < 1) {
            System.out.println("Enter a valid number of terms!");
            return;
        }
    }
    
    // metoda statica cu un parametru ce returneaza un sir de intregi
    public static int[] generateFibonacci(int n) {
        // creare sir de intregi
        int[] fibonacciSequence = new int[n];
        // initializam primul elemen din sir cu 0
        fibonacciSequence[0] = 0;
        // verificam daca sirul contine mai mult de 1 element
        if (n > 1) {
            // daca da, initializam a doua valoare a sirului cu 1
            fibonacciSequence[1] = 1;
            // parcurgem sirul de la pozitia a 2a pana la penultima pozitie
            for (int i = 2; i < n; i++) {
                // calculam fiecare element ca fiind suma celor 2 elem anterioare 
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            }
        }
        return fibonacciSequence;
    }
    
}
