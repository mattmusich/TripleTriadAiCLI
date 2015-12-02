package me.musich;

import me.musich.base.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//TODO BETTER GUI, HAND REMOVAL, OUT OF HAND CARD PLAY ERROR, CANT PLAY ON SAME SPOT TWICE, ACTUAL AI


    public static void main(String[] args) {
	    int p1wins = 0;
        int p2wins = 0;

        System.out.println("How many Human Players? (0,1,2)");
        Scanner scannerP = new Scanner(System.in);
        String numPlayers = scannerP.nextLine();

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
            Card c1 = new Card("1154zard", 1, 1, 5, 4, 1, 0);
            Card c2 = new Card("5411zard", 5, 4, 1, 1, 1, 0);
            Card c3 = new Card("5114zard", 5, 1, 1, 4, 1, 0);
            Card c4 = new Card("4151zard", 4, 1, 5, 1, 1, 0);
            Card c5 = new Card("1541zard", 1, 5, 4, 1, 1, 0);
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
            Card c6 = new Card("1154zard2", 1, 1, 5, 4, 1, 1);
            Card c7 = new Card("5411zard2", 5, 4, 1, 1, 1, 1);
            Card c8 = new Card("5114zard2", 5, 1, 1, 4, 1, 1);
            Card c9 = new Card("4151zard2", 4, 1, 5, 1, 1, 1);
            Card c10 = new Card("1541zard2", 1, 5, 4, 1, 1, 1);
            List<Card> p2cards = new ArrayList<>();
            p2cards.add(c6);
            p2cards.add(c7);
            p2cards.add(c8);
            p2cards.add(c9);
            p2cards.add(c10);
            Hand p2hand = new Hand("p2hand");
            p2hand.setCards(p2cards);
            p2.setHand(p2hand);

            GameController game = new GameController(board,p1,p2,Integer.parseInt(numPlayers));

            List<Integer> stats = game.startGame();
            if (stats.get(0) == 0){
                p1wins++;
            } else{
                p2wins++;
            }


        }
        //Stat output
        float p1float = ((p1wins * 100.0f) / Integer.parseInt(numGames));
        float p2float = ((p2wins * 100.0f)/ Integer.parseInt(numGames));
        System.out.println("\n");
        System.out.println("Player 1 Wins: " + p1wins + "  " + p1float +"%");
        System.out.println("Player 2 Wins: " + p2wins + "  " + p2float +"%");


    }





}
