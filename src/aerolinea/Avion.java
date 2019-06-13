/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

/**
 *
 * @author Rafael Melara
 */
public class Avion {
    boolean AsientosEco [][] = new boolean [6][6];
    
    public Avion(){
        AsientosEco = new boolean [6][6];
        
        for(boolean fila [] : AsientosEco){
            for(boolean columna : fila){
                columna = false;
            }
        }
          
    }
    
    public boolean AvionLleno(){
        for(boolean[] fila : AsientosEco){
            for(boolean columna : fila){
                if(!columna)
                    return false;
            }
        }
        return true;
    }
    
    public void MostrarAsientos(){
        int espacio = 0;
        for(boolean [] fila : AsientosEco){
            for(boolean columna : fila){
                if(espacio < 2){
                    if(!columna) 
                        System.out.print("X");
                    else
                        System.out.print("0");
                    espacio ++;
                }
                else if(espacio == 2){
                    if(!columna){
                        System.out.print("X\t");
                        espacio = 0;
                    }
                    else System.out.println("0\t");
                    espacio = 0;
                }
            }
            System.out.println(0);
        }
    }
}
