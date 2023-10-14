package it.unisa.diem.oop22.box;
import it.unisa.diem.oop22.box.BoxCustExceptions.*;
import it.unisa.diem.oop22.veicoli.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* GESTIRE direttive package e import
/**
*
* @author lucagreco
*/
public class TestRimessa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Autorimessa a = new Autorimessa(5,"Parcheggio E1");

        try{
            a.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            a.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            a.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            a.entra( new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            a.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            a.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
        } catch(TargaNonValidaException e){
            System.out.println("La targa non è valida! Il veicolo non sarà ammesso nella rimessa.\n");
        }catch(AutorimessaPienaException x){
            System.out.println("L'autorimessa è piena, non c'è spazio per il veicolo.\n");
        }

        try{
            System.out.println("Esce il veicolo: " + a.esce() + "\n");
        } catch(AutorimessaVuotaException k){
            System.out.println("Fantasmiiiii\n");
        }

        try{
            System.out.println("Esce il veicolo: " + a.esce() + "\n");
        } catch(AutorimessaVuotaException k){
            System.out.println("Fantasmiiiii\n");
        }

        try{
            System.out.println("Esce il veicolo: " + a.esce() + "\n");
        } catch(AutorimessaVuotaException k){
            System.out.println("Fantasmiiiii\n");
        }

        try{
            System.out.println("Esce il veicolo: " + a.esce() + "\n");
        } catch(AutorimessaVuotaException k){
            System.out.println("Fantasmiiiii\n");
        }

        try{
            System.out.println("Esce il veicolo: " + a.esce() + "\n");
        } catch(AutorimessaVuotaException k){
            System.out.println("Fantasmiiiii\n");
        }

        System.out.println(a);

    }

}
