/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clase2;

import java.util.Scanner;

/**
 *
 * @author esteb
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        int[] enteros = {1, 2, 3, 4, 5};
        double[] decimales = {1.5, 2.5, 3.5, 4.5, 5.5};
        String[] cadenas = {"Java", "es", "poderoso"};

        // Mostrar elementos de los arreglos
        System.out.println("Arreglo de enteros:");
        for (int i = 0; i < enteros.length; i++) {
            System.out.print(enteros[i] + " ");
        }
        System.out.println();

        // Acceder y modificar elementos
        enteros[2] = 10;
        for (int elemento : enteros) {
            System.out.print(elemento + " ");
        }
        System.out.println();
        
        //Declaracion sin asignar valor
        //se inicializan automáticamente con un valor predeterminado según su tipo (por ejemplo, 0 para enteros, 0.0 para decimales y null para cadenas).
        int[] enteros2 = new int[5]; // Un arreglo de enteros con tamaño 5
        enteros2[0] = 10;
        enteros2[1] = 20;
        enteros2[2] = 30;
        enteros2[3] = 30;
        enteros2[4] = 30;
        
        double[] decimales2 = new double[3]; // Un arreglo de decimales con tamaño 3
        
        Scanner entrada = new Scanner(System.in);
        String[] cadenas2 = new String[4]; // Un arreglo de cadenas con tamaño 4
        
        for (int i = 0; i < cadenas2.length; i++) {
            System.out.print("Ingrese el valor para la posicion " + i + ": ");
            cadenas2[i] = entrada.nextLine();
        }

        // Mostrar la matriz
        System.out.println("Matriz de cadenas:");
        for (int i = 0; i < cadenas2.length; i++) {
            System.out.print(cadenas2[i] + " ");
        }
        
        
        // --------------------- Matriz bidimensional 
        // Declaración e inicialización de la matriz de enteros (5x5)
        int filas = 5;
        int columnas = 5;
        int[][] matrizEnteros = new int[filas][columnas];

        // Llenar la matriz solicitando al usuario los datos
        int elemento = 1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizEnteros[i][j] = elemento;
                elemento++;
            }
        }

        // Mostrar la matriz en el sentido normal (de inicio a fin)
        System.out.println("\nMatriz de enteros (de inicio a fin):");
        for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros[i].length; j++) {
                System.out.print(matrizEnteros[i][j] + "\t");
            }
            System.out.println();
        }

        // Mostrar la matriz en el sentido inverso (de fin a inicio)
        System.out.println("\nMatriz de enteros (de fin a inicio):");
        for (int i = matrizEnteros.length - 1; i >= 0; i--) {
            for (int j = matrizEnteros[i].length - 1; j >= 0; j--) {
                System.out.print(matrizEnteros[i][j] + "\t");
            }
            System.out.println();
        }
        
        
        //Recursividad 
        int numero = 4;
        long factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);

    }
    
    
    // Función recursiva para calcular el factorial de un número
    private static long calcularFactorial(int n) {
        // Caso base: factorial de 0 es 1
        if (n == 0) {
            return 1;
        } else {
            // Caso recursivo: n! = n * (n-1)!
            return n * calcularFactorial(n - 1);
        }
    }
    
}
