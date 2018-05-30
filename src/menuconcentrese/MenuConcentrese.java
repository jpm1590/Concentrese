/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconcentrese;

import java.util.Scanner;

/**
 *
 * @author JORGEGARZON
 */
public class MenuConcentrese {

    /**
     * @param args the command line arguments
     */
    public static void main() {
        MenuConcentrese mnu = new MenuConcentrese();
        mnu.despliegaMenu();
        
    }
    private Tablero board = new Tablero();
    private Scanner sca;
    
    public MenuConcentrese() {
        sca = new Scanner(System.in);  
    }
    public void despliegaMenu() 
    {
        desplegarOpciones();
        int OpcionSeleccionada = Integer.parseInt(sca.nextLine());
        ejecutaOpcion(OpcionSeleccionada);
        despliegaMenu();
    }
    
    private void desplegarOpciones() {
        
        String mnulinea = "Tablero: ";
        board.elegirCartas();
        board.elegirCartasParaTablero();
        board.desplegarTablero();
        mnulinea += "\nAciertos: ";
        mnulinea += "\nVidas restantes:";
        mnulinea += "\nDigite alguna de las siguientes opciones: ";
        mnulinea += "\n\t1. Hacer jugada";
        mnulinea += "\n\t2. Reiniciar partida";
        mnulinea += "\n\t3. Reiniciar vidas";
        mnulinea += "\n\t4. Salir";
        System.out.println(mnulinea);
    }
    private void ejecutaOpcion(int OpcionSeleccionada) {
        switch (OpcionSeleccionada) {
            case 1:
                manejarOpcionHacerJugada();
                break;
            case 2:
                //TODO: Definir acciones del metodo
                break;
            case 3:
                //TODO: Definir acciones del metodo
                break;
            case 4:
                System.exit(4);
                break;
        }
    }
    
    private void manejarOpcionHacerJugada() {
        int filaCarta;
        int columnaCarta;
        System.out.println("Usted ha seleccionado la opción 1, hacer jugada:");
        System.out.println("\nIngrese las coordenadas de la carta que desea descubrir");
        String[] datos = sca.nextLine().split("&");
        filaCarta = Integer.parseInt(datos[0]);
        columnaCarta = Integer.parseInt(datos[1]);
    }
    
    
}
