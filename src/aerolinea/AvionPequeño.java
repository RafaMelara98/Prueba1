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
public class AvionPequeño extends Avion implements Consults{
    
    
    @Override
    public void anadirPasajeros(int pas, String clase) throws AvionSinClaseEjecutivaException, AvionLlenoException, AsientosSeparadosException {
        if(clase.equalsIgnoreCase("Ejecutivo")){
            throw new AvionSinClaseEjecutivaException("Este avion no cuenta con clase ejecutiva");
        }else if(AvionLleno()){
            throw new AvionLlenoException("El avion esta lleno");
        }
        
        if (pas > 3)
            throw new AsientosSeparadosException("No es posible ubicar mas de 3 pasajeros");
        int AsientosSolos = 0;
        boolean AgregarGente = false;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                if(AsientosEco [i][j] == false){
                    AsientosSolos ++;
                    if(AsientosSolos == pas){
                        for(int k = AsientosSolos; k > 0; k--){
                                AsientosEco[i][k - 1] = true;
                                AgregarGente = true;
                            }
                    }
                }
                else{
                    AsientosSolos = 0;
                }
            }
             if(AgregarGente)
                    return;
        }
        AsientosSolos = 0;
            if(AgregarGente)
                return;
            
        for(int i = 0; i < 6; i++){
                for(int j = 3; j < 6; j++){
                    if(AsientosEco[i][j] == false){
                        AsientosSolos++;
                        if(AsientosSolos == pas) {
                            for(int k = AsientosSolos; k > 0; k--){
                                AsientosEco[i][k + 2] = true;
                                AgregarGente = true;
                            }
                        }
                    }
                    else{
                        AsientosSolos = 0;
                    }
                }
            }
            if(!AgregarGente)
                throw new AsientosSeparadosException("No es posible ubicar juntos a los pasajeros");
        }
    }
    

