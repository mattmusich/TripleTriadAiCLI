package me.musich;

import me.musich.base.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //gen all possible games


        //gen board
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.getSlots()[i][j] = new Slot();
            }
        }
        //gen players
        Player p1 = new Player("Player");
        Player p2 = new Player("Opponent");
        //gen hands/cards p1
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
        Hand p1hand = new Hand("p1hand");
        p1hand.setCards(p1cards);
        p1.setHand(p1hand);
        //gen hands/cards p2
        Card c6 = new Card("onezard2", 1, 1, 5, 4, 1);
        Card c7 = new Card("twozard2", 5, 4, 1, 1, 1);
        Card c8 = new Card("threezard2", 5, 1, 1, 4, 1);
        Card c9 = new Card("fourzard2", 4, 1, 5, 1, 1);
        Card c10 = new Card("fivezard2", 1, 5, 4, 1, 1);
        List<Card> p2cards = new ArrayList<>();
        p2cards.add(c6);
        p2cards.add(c7);
        p2cards.add(c8);
        p2cards.add(c9);
        p2cards.add(c10);
        Hand p2hand = new Hand("p2hand");
        p2hand.setCards(p2cards);
        p2.setHand(p2hand);



//        Slot[][] test = board.getSlots();
//        test[0][1].setCard(p1cards.get(0));
//        test[2][0].setCard(p2.getCurrentHand().getCards().get(2));
//        board.setSlots(test);
//
//        System.out.println(p1.getCurrentHand().toString());
//        System.out.println(board.showBoard());

        //start game
        System.out.println(p1.getCurrentHand().toString());
        System.out.println(board.showBoard());
        System.out.println("Player 1 select card index:");
        Scanner scanner = new Scanner(System.in);
        String cIndex = scanner.nextLine();
        System.out.println("Player 1 select Slot:");
        String sIndex = scanner.nextLine();
        System.out.println(cIndex + sIndex);


        //call actionHandler and loop


        //end the game, loop if more than one game


        //End program

    }



}
