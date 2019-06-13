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
public interface Consults {
    public void anadirPasajeros(int pas, String clase) throws AvionSinClaseEjecutivaException, AvionLlenoException, AsientosSeparadosException;
}
