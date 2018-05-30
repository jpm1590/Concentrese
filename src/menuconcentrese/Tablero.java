/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconcentrese;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author JORGEGARZON
 */
public class Tablero {
    public Carta cards;
    private int contador;
    private int aciertos;
    private int vidasRestantes;
    private ArrayList <Carta> cartasXTablero;
    private Carta[][] tableroCartas;
    private Carta[] todaslascartas;
    private Carta[] cartasElegidas;
    private Carta[] cartasElegidasCopiadas;
    private String [] etiquetas = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String [] palos = {"C", "D", "H", "S"};
    
    
    Random rnd = new Random();
    
public Tablero()
        {
            tableroCartas = new Carta[4][6];
            todaslascartas = new Carta[52];
            aciertos = 0;
            vidasRestantes = 6;
            inicializarCartas();
        }

private void inicializarCartas() {
    contador = 0;
    for(int etiquetaCarta = 0; etiquetaCarta < 13; etiquetaCarta++) 
        for (int paloCarta = 0; paloCarta < 4; paloCarta++){
          Carta c = new Carta(etiquetas[etiquetaCarta], palos[paloCarta]);
          todaslascartas[contador] = c;
          contador++;
        }
         
        

}
public void elegirCartas() {
     Carta c;
    cartasElegidas = new Carta[12];
    for (int indexCartaElegida = 0; indexCartaElegida < 12; indexCartaElegida++){
        do {
        c = todaslascartas[rnd.nextInt(todaslascartas.length-1)];
            
        }while(validarRepetidas(c) == false);
        cartasElegidas[indexCartaElegida] = c;
        //System.out.println(c);
    }
}

private boolean validarRepetidas(Carta cartaElegida) {
    for (int indexCartaElegida = 0; indexCartaElegida < cartasElegidas.length-1; indexCartaElegida++){
        if (cartaElegida.equals(cartasElegidas[indexCartaElegida])) {
            return false;
        }
    }
    return true;
}

public void copiarCartasElegidas() {
    cartasElegidasCopiadas = new Carta[cartasElegidas.length];
    for (int jorge = 0; jorge < cartasElegidas.length; jorge++) {
        cartasElegidasCopiadas[jorge] = cartasElegidas[jorge];
    }
}

public boolean inicializarTablero(Carta cartaPlay) {
    int contador = 0;
            for (int row = 0; row < tableroCartas.length; row++){
                for (int column = 0; column < tableroCartas[row].length; column++){
                    if (cartaPlay.equals(tableroCartas[row][column])) {
                        contador++;
                    }
                }
            }
            if (contador < 2) {
                return true;
            }
            return false;
}

public void elegirCartasParaTablero() { //TODO: Cambiar
    /*Carta c;
    for (int row = 0; row < tableroCartas.length; row++) {
        for (int column = 0; column < tableroCartas[row].length; column++) {
            
    do {
        c = cartasElegidas[rnd.nextInt(cartasElegidas.length-1)];
        System.out.println(c);
    } while (!inicializarTablero(c)) ;
    tableroCartas[row][column] = c;
    }
    }*/
    
    ArrayList<Carta> cartasTablero = new ArrayList<>();
    for (int indice = 0 ; indice < 12; indice++) {
        for (int jndice = 0; jndice < 2; jndice++) {
            cartasTablero.add(cartasElegidas[indice]);
        }
    }
      cartasXTablero = ordenarCartas(cartasTablero);  
}

public ArrayList ordenarCartas(ArrayList tablero) {
    Collections.shuffle(tablero, rnd);
    return tablero;
}

public void desplegarTablero() {
    int contador = 0;
    for (int row = 0; row < 4; row++) {
        for (int column = 0; column < 6; column++) { 
            System.out.print(cartasXTablero.get(contador));
            System.out.print("|");
            contador++;
        }
        System.out.println("\n----+----+----+----+----+----+----+");
    }
}
    

public void realizarJugada(int row, int column) {
    

}

}
