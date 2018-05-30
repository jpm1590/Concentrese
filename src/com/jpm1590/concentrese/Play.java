package com.jpm1590.concentrese;

import com.jpm1590.concentrese.entity.Board;
import com.jpm1590.concentrese.entity.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jpm1590
 */
public class Play {

    public static void menu(int lifes, int good) {
        System.out.println("Aciertos: " + good);
        System.out.println("Vidas restantes:" + lifes);
        System.out.println("Digite alguna de las siguientes opciones: ");
        System.out.println("\t1. Hacer jugada");
        System.out.println("\t2. Reiniciar partida");
        System.out.println("\t0. Salir");
        System.out.println("");

    }

    public static Card jugar(Card[][] boardCards, int i) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int column, row;

        System.out.println(i + 1 + "a Carta a destapar");
        System.out.println("\tIngrese columna: ");
        column = Integer.parseInt(br.readLine());
        System.out.println("\tIngrese fila: ");
        row = Integer.parseInt(br.readLine());

        if (boardCards[column - 1][row - 1].getState() != 3) {
            boardCards[column - 1][row - 1].setState(i + 1);
        }

        return boardCards[column - 1][row - 1];
    }

    public static boolean isValidMove(Card[][] boardCards, Board board) throws IOException, InterruptedException {

        boolean ret = false;
        Card[] cardMove = new Card[2];

        for (int i = 0; i < 2; i++) {
            cardMove[i] = Play.jugar(boardCards, i);
            System.out.println(board);
        }
        Thread.sleep(3000);

        if (cardMove[0].getNumber() == cardMove[1].getNumber()
                && cardMove[0].getPalo() == cardMove[1].getPalo()) {
            ret = true;
            for (int i = 0; i < 2; i++) {
                cardMove[i].setState(3);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        InitBoard ib = new InitBoard();

        Card[][] boardCards;
        int parejas;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ib.init();
        boardCards = ib.getbCard();
        parejas = ib.getParejas();

        int lifes = 5;
        int correct = 0;

        do {
            Play.menu(lifes, correct);
            switch (br.readLine()) {
                case "1":
                    if (!Play.isValidMove(boardCards, ib.getGameBoard())) {
                        lifes--;
                    } else {
                        correct++;
                    }
                    System.out.println(ib.getGameBoard());
                    break;
                case "2":
                    Play.main(args);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (lifes != 0 && correct != parejas);

        if (correct == parejas) {
            System.out.println(
                    "***************************************\n"
                    + "***************************************\n"
                    + "***************************************\n"
                    + "******** F E L I C I D A D E S ********\n"
                    + "********** H A   G A N A D O **********\n"
                    + "***************************************\n"
                    + "***************************************\n"
                    + "***************************************");
        } else {
            System.out.println(
                    "***************************************\n"
                    + "***************************************\n"
                    + "*********** V U E L V A   A ***********\n"
                    + "********* I N T E N T A R L O *********\n"
                    + "***************************************\n"
                    + "********* H A   P E R D I D O *********\n"
                    + "***************************************\n"
                    + "***************************************");

            for (Card[] bCard : ib.getbCard()) {
                for (Card item : bCard) {
                    item.setState(3);
                }
            }

            System.out.println(ib.getGameBoard());
        }
    }
}
