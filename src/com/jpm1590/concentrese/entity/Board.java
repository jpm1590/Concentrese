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
public class Board {

    private int column;
    private int row;
    private Card[][] cards;

    public Board(int column, int row, Card[][] cards) {
        this.column = column;
        this.row = row;
        this.cards = cards;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Card[][] getCards() {
        return cards;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {

        //String[] card = {"|------|", "|  --  |", "|------|"};
        String[] card = new String[3];
        String sout = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < column; k++) {
                    card[j] = j == 1 ? "|  " + cards[k][i] + "  |" : "|------|";
                    sout += card[j];
                }
                sout += "\n";
            }
        }
        return sout;
    }

}
