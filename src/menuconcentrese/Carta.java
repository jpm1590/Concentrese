/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconcentrese;

import java.util.ArrayList;

/**
 *
 * @author JORGEGARZON
 */
public class Carta {
    private String etiqueta;
    private String palo;
    
    public Carta (String etiqueta, String palo) {
        this.etiqueta = etiqueta;
        this.palo = palo;
    
}
    private String darEtiqueta() {
        return etiqueta;
    }
    private String darPalo() {
        return palo;
    }
    
    @Override
    public String toString() {
        return etiqueta+palo;
    }

}
