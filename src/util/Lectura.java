/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author eljug
 */
public class Lectura {
    private Scanner lector = new Scanner(System.in);
    public int ingresarEntero(){
        int numero;
        numero = lector.nextInt();
        lector.nextLine();
        return numero;
    }
    
    public double ingresarDouble(){
        double numero;
        numero = lector.nextDouble();
        return numero;
    }
    
    public String ingresaCadena(){
        String cadena;
        cadena = lector.nextLine();
        return cadena;
    }
    
    public float ingresaFlotante(){
        float numero;
        numero = lector.nextFloat();
        return numero;
    }
    
    
}

