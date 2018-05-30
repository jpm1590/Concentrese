/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpm1590.concentrese.entity;

/**
 *
 * @author jpm1590
 */
public class Card {

    private char palo;
    private char number;
    private int state;

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public char getNumber() {
        return number;
    }

    public void setNumber(char number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Card(char palo, char number, int state) {
        this.palo = palo;
        this.number = number;
        this.state = state;
    }

    public Card(char palo, char number) {
        this.palo = palo;
        this.number = number;
        this.state = 0;
    }

    @Override
    public String toString() {
        String card = "";
        switch (state) {
            case 0:
                card = "--";
                break;
            case 1:
                card = number + "" + palo;
                this.state = 2;
                break;
            case 2:
                card = number + "" + palo;
                this.state = 0;
                break;
            case 3:
                card = number + "" + palo;
                break;
        }

        return card;
    }

}
