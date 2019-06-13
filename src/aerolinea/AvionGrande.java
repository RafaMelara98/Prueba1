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
public class AvionGrande extends Avion implements Consults{
    boolean[][] asientosEje;

    public AvionGrande(){

        asientosEje = new boolean[4][5];

        for(boolean[] fila : asientosEje){
            for(boolean columna : fila){
                columna = false;
            }
        }
    }

    @Override
    public void anadirPasajeros(int pas, String clase) throws AvionSinClaseEjecutivaException, AvionLlenoException, AsientosSeparadosException {
        if(AvionLleno()){
            throw new AvionLlenoException("El avion esta lleno");
        }
        else if(clase.equalsIgnoreCase("Ejecutivo")){

            if(pas > 4)
                throw new AsientosSeparadosException("No es posible ubicar a mas de 4 pasajeros juntos en la clase ejcutiva.");

            int asientosSolos = 0;

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 4; j++){
                    if(asientosEje[i][j] == false){
                        asientosSolos++;
                        if(asientosSolos == pas){
                            for(int k = asientosSolos; k > 0; k--){
                                asientosEje[i][k - 1] = true;
                            }
                            return;
                        }
                    }
                    else{
                        asientosSolos = 0;
                    }
                }
            }

            throw new AsientosSeparadosException("No es posible ubicar juntos a los pasajeros");
        }
        else{

            if(pas > 3)
                throw new AsientosSeparadosException("No es posible ubicar a 4 pasajeros juntos en la clase economica");

            int asientosSolos = 0;
            boolean agregarGente = false;
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    if(AsientosEco[i][j] == false){
                        asientosSolos++;
                        if(asientosSolos == pas) {
                            for(int k = asientosSolos; k > 0; k--){
                                AsientosEco[i][k - 1] = true;
                                agregarGente = true;
                            }
                        }
                    }
                    else{
                        asientosSolos = 0;
                    }
                }
                if(agregarGente)
                    return;
            }
            asientosSolos = 0;
            if(agregarGente)
                return;

            for(int i = 0; i < 6; i++){
                for(int j = 3; j < 6; j++){
                    if(AsientosEco[i][j] == false){
                        asientosSolos++;
                        if(asientosSolos == pas) {
                            for(int k = asientosSolos; k > 0; k--){
                                AsientosEco[i][k + 2] = true;
                                agregarGente = true;
                            }
                        }
                    }
                    else{
                        asientosSolos = 0;
                    }
                }
            }
            if(!agregarGente)
                throw new AsientosSeparadosException("No es posible ubicar juntos a los pasajeros");
        }
    }

    @Override
    public void MostrarAsientos() {
        for(boolean[] fila : asientosEje){
            System.out.print("  ");
            for(boolean columna : fila){
                if(!columna) System.out.print("X ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        int espacio = 0;

        for(boolean[] fila : AsientosEco){
            for(boolean columna : fila){
                if(espacio < 2){
                    if(!columna)    System.out.print("X ");
                    else System.out.print("0 ");
                    espacio++;
                }
                else if(espacio == 2){
                    if(!columna) {    System.out.print("X\t");   espacio = 0;     }
                    else System.out.print("0\t");
                    espacio = 0;
                }
            }
            System.out.println();
        }
    }
}
