/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rafael Melara
 */
public class Aerolinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AsientosSeparadosException {
        Scanner in = new Scanner(System.in);

        AvionPequeño avionsito = new AvionPequeño();
        AvionGrande avionsote = new AvionGrande();

        int opcion = 0, pasajeros = 0;
        String clase = "";

        do{
            ImpresionMenu();
            opcion = in.nextInt(); in.nextLine();

            switch (opcion){
                case 1:

                    System.out.println("1- Avion pequeno");
                    System.out.println("2- Avion grande");
                    System.out.println("Su opcion: ");  opcion = in.nextInt(); in.nextLine();

                    switch(opcion){
                        case 1:
                            System.out.print("Digite la cantidad de personas y la clase del avion en el siguiente formato: ");
                            System.out.println("3 Economica");

                            try{
                                System.out.print("Pasajeros: "); pasajeros = in.nextInt(); in.nextLine();
                                System.out.print("Clase: ");clase = in.nextLine();
                                avionsito.anadirPasajeros(pasajeros, clase);
                            }
                            catch(InputMismatchException e){
                                System.out.println("Datos erroneos, intente nuevamente");
                            }
                            catch(AvionSinClaseEjecutivaException|AvionLlenoException|AsientosSeparadosException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.print("Digite la cantidad de personas y la clase del avion en el siguiente formato: ");
                            System.out.println("3 Economica");

                            try{
                                System.out.print("Pasajeros: "); pasajeros = in.nextInt(); in.nextLine();
                                System.out.print("Clase: ");clase = in.nextLine();
                                avionsote.anadirPasajeros(pasajeros, clase);
                            }
                            catch(InputMismatchException e){
                                System.out.println("Datos erroneos, intente nuevamente");
                            }
                            catch(AvionSinClaseEjecutivaException|AvionLlenoException|AsientosSeparadosException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1- Avion pequeno");
                    System.out.println("2- Avion grande");
                    System.out.println("Su opcion: ");  opcion = in.nextInt(); in.nextLine();

                    switch(opcion){
                        case 1:
                            avionsito.MostrarAsientos();
                            break;
                        case 2:
                            avionsote.MostrarAsientos();
                            break;
                    }
                    break;
            }
        } while(opcion != 0);
    }

    public static void ImpresionMenu(){
        System.out.println("1- Agregar gente");
        System.out.println("2- Mostrar gente");
        System.out.println("3- Comprar boleto");
        System.out.print("Su opcion:\t");
    }
    
}
