/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpm1590.concentrese;

import com.jpm1590.concentrese.entity.Board;
import com.jpm1590.concentrese.entity.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jpm1590
 */
public class InitBoard {

    private Board gameBoard;
    private Card[][] bCard;
    private int parejas;
    private int lifes;
    private int asserts;

    public Card[][] getbCard() {
        return bCard;
    }

    public void setbCard(Card[][] bCard) {
        this.bCard = bCard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getParejas() {
        return parejas;
    }

    public void setParejas(int parejas) {
        this.parejas = parejas;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public int getAsserts() {
        return asserts;
    }

    public void setAsserts(int asserts) {
        this.asserts = asserts;
    }

    public List allCards(char[] palo, char[] number) {

        List<Card> allCards = new ArrayList<>();

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < palo.length; j++) {
                allCards.add(new Card(palo[j], number[i]));
            }
        }
        return allCards;
    }

    public Board createBoard(int sizeColumn, int sizeRow, Card[][] cards) {
        return new Board(sizeColumn, sizeRow, cards);
    }

    public List selectBoardCards(List<Card> allCards, int column, int row) {

        List<Card> boardCards = new ArrayList<>();

        Collections.shuffle(allCards);
        for (int i = 0; i < column * row / 2; i++) {
            boardCards.add(new Card(allCards.get(i).getPalo(), allCards.get(i).getNumber()));
            boardCards.add(new Card(allCards.get(i).getPalo(), allCards.get(i).getNumber()));
        }

        return boardCards;
    }

    public Card[][] fillBoardCards(List<Card> boardCards, int column, int row) {

        Card[][] bCards = new Card[column][row];
        int count = 0;

        Collections.shuffle(boardCards);

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                bCards[i][j] = boardCards.get(count);
                count++;
            }
        }
        return bCards;
    }

    public void init() throws IOException {
        String boardSize;
        Board board;

        int boardColumn = 3;
        int boardRow = 4;

        char[] palo = {'♥', '♦', '♣', '♠'};
        char[] number = {'2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A'};

        List<Card> allCards = allCards(palo, number);
        List<Card> boardCards;
        Card[][] bCards;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        System.out.println("Ingrese las columnas del tablero: ");
        boardColumn = Integer.parseInt(br.readLine());
        System.out.println("Ingrese las filas del tablero: ");
        boardRow = Integer.parseInt(br.readLine());//*/
        setParejas(boardColumn * boardRow / 2);

        boardCards = selectBoardCards(allCards, boardColumn, boardRow);

        bCards = fillBoardCards(boardCards, boardColumn, boardRow);

        setbCard(bCards);

        board = createBoard(boardColumn, boardRow, bCards);

        setGameBoard(board);

        System.out.println(board);

    }

}
