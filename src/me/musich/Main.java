package me.musich;

import me.musich.base.*;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //gen all possible games


        //gen board
        Board board = new Board();

        //gen players


        //gen hands/cards
        Hand p1hand = new Hand("p1hand");
        Card c1 = new Card("onezard", 1, 1, 5, 4, 1);
        Card c2 = new Card("twozard", 5, 4, 1, 1, 1);
        Card c3 = new Card("threezard", 5, 1, 1, 4, 1);
        Card c4 = new Card("fourzard", 4, 1, 5, 1, 1);
        Card c5 = new Card("fivezard", 1, 5, 4, 1, 1);

        List<Card> p1cards = new ArrayList<>();
        p1cards.add(c1);
        p1cards.add(c2);
        p1cards.add(c3);
        p1cards.add(c4);
        p1cards.add(c5);

        p1hand.setCards(p1cards);

        Slot[][] test = board.getSlots();
        test[0][0].setCard(c1);
        test[1][1].setCard(p1cards.get(0));
        board.setSlots(test);

        System.out.println(p1hand);
        System.out.println(board.showBoard());
        //start game


        //call actionHandler and loop


        //end the game, loop if more than one game


        //End program

    }
}
