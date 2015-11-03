package me.musich;

import me.musich.base.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int p1wins = 0;
        int p2wins = 0;

        System.out.println("How many games do you want run?");
        Scanner scanner = new Scanner(System.in);
        String numGames = scanner.nextLine();
        //gen all possible games

        for (int x = 0; x < Integer.parseInt(numGames); x++) {
            //gen board
            Board board = new Board();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board.getSlots()[i][j] = new Slot();
                }
            }
            //gen players
            Player p1 = new Player("Player 1");
            Player p2 = new Player("Player 2");
            //gen hands/cards p1
            Card c1 = new Card("onezard", 1, 1, 5, 4, 1, 0);
            Card c2 = new Card("twozard", 5, 4, 1, 1, 1, 0);
            Card c3 = new Card("threezard", 5, 1, 1, 4, 1, 0);
            Card c4 = new Card("fourzard", 4, 1, 5, 1, 1, 0);
            Card c5 = new Card("fivezard", 1, 5, 4, 1, 1, 0);
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
            Card c6 = new Card("onezard2", 1, 1, 5, 4, 1, 1);
            Card c7 = new Card("twozard2", 5, 4, 1, 1, 1, 1);
            Card c8 = new Card("threezard2", 5, 1, 1, 4, 1, 1);
            Card c9 = new Card("fourzard2", 4, 1, 5, 1, 1, 1);
            Card c10 = new Card("fivezard2", 1, 5, 4, 1, 1, 1);
            List<Card> p2cards = new ArrayList<>();
            p2cards.add(c6);
            p2cards.add(c7);
            p2cards.add(c8);
            p2cards.add(c9);
            p2cards.add(c10);
            Hand p2hand = new Hand("p2hand");
            p2hand.setCards(p2cards);
            p2.setHand(p2hand);

            GameController game = new GameController(board,p1,p2);

            List<Integer> stats = game.startGame();
            if (stats.get(0) == 0){
                p1wins++;
            } else{
                p2wins++;
            }

            System.out.println("Player 1 Wins: " + p1wins);
            System.out.println("Player 2 Wins: " + p2wins);
        }

//        Slot[][] test = board.getSlots();
//        test[0][1].setCard(p1cards.get(0));
//        test[2][0].setCard(p2.getCurrentHand().getCards().get(2));
//        board.setSlots(test);
//
//        System.out.println(p1.getCurrentHand().toString());
//        System.out.println(board.showBoard());

        //start game

        /*
        System.out.println(p1.getCurrentHand().toString());
        System.out.println(board.showBoard());
        System.out.println("Player 1 select card index:");
        Scanner scanner = new Scanner(System.in);
        String cIndex = scanner.nextLine();
        System.out.println("Player 1 select Slot:");
        String sIndex = scanner.nextLine();

        board.setSlot(Integer.parseInt(sIndex), p1.getCurrentHand().getCards().get(Integer.parseInt(cIndex)));


        System.out.println(board.showBoard());
        */
        //call actionHandler and loop
        /*
        for (int i = 1; i <= 9; i++){
            System.out.println(board.showBoard());
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9){
//                System.out.println(p1.getCurrentHand().toString());
//                System.out.println("Player 1 select card index:");
//                Scanner scanner = new Scanner(System.in);
//                String cIndex = scanner.nextLine();
//                System.out.println("Player 1 select Slot:");
//                String sIndex = scanner.nextLine();
//                board.setSlot(Integer.parseInt(sIndex), p1.getCurrentHand().getCards().get(Integer.parseInt(cIndex)));
                int c = getCommand().get(0);
                int s = getCommand().get(1);
                board.setSlot(c, p1.getCurrentHand().getCards().get(s));

            } else {
//                System.out.println(p2.getCurrentHand().toString());
//                System.out.println("Player 2 select card index:");
//                Scanner scanner2 = new Scanner(System.in);
//                String cIndex2 = scanner2.nextLine();
//                System.out.println("Player 2 select Slot:");
//                String sIndex2 = scanner2.nextLine();
//                board.setSlot(Integer.parseInt(sIndex2), p2.getCurrentHand().getCards().get(Integer.parseInt(cIndex2)));
                int c = getCommand().get(0);
                int s = getCommand().get(1);
                board.setSlot(c, p2.getCurrentHand().getCards().get(s));
            }

        }
        */

        //end the game, loop if more than one game


        //End program

    }





}
