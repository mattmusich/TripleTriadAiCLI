package me.musich;

import me.musich.base.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * Created by matt on 11/2/2015.
 * This runs Initialization of the games and the statistics to track the AI
 */
public class Main {

    public static void main(String[] args) {
	    int p1wins = 0;
        int p2wins = 0;

        /* User Inputs for setup */
        System.out.println("How many Human Players? (0,1,2) \n 0) Two AI's will play  \n 1) You will play an AI \n 2) You will play another Human, taking turns ");
        Scanner scannerP = new Scanner(System.in);
        String numPlayers = scannerP.nextLine();

        System.out.println("How many games do you want run? (1 to Millions)");
        if(Integer.parseInt(numPlayers) == 0){
            System.out.printf(" Running 25 or less games will show the full moves made \n While running 26 or more games will just show the outcomes \n");
        }
        Scanner scanner = new Scanner(System.in);
        String numGames = scanner.nextLine();

        String aiDiff = "0";
        if(Integer.parseInt(numPlayers) != 2) {
            System.out.println("Select Opponent Difficulty \n 0) Easy - Random moves - ALPHA \n 1) Advanced - Full Ai - BETA");
            Scanner scannerQ = new Scanner(System.in);
            aiDiff = scannerQ.nextLine();
        }

        //gen all possible games
        int roundCount = Integer.parseInt(numGames);
        int diff = Integer.parseInt(aiDiff);

        /* Loop that runs all of the initialization of the boards players and cards to run a single game.
        This will loop as many times as the user enters for games wanted to run*/
        for (int x = 0; x < roundCount; x++) {

            //gen board
            Board board = new Board();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board.getSlots()[i][j] = new Slot();
                }
            }

            //gen players
            Player p1 = new Player("Player 1",0);
            Player p2 = new Player("Player 2",1);

            //gen hands/cards p1
            Card c1 = randomCard(0);
            Card c2 = randomCard(0);
            Card c3 = randomCard(0);
            Card c4 = randomCard(0);
            Card c5 = randomCard(0);
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
            Card c6 = randomCard(1);
            Card c7 = randomCard(1);
            Card c8 = randomCard(1);
            Card c9 = randomCard(1);
            Card c10 = randomCard(1);
            List<Card> p2cards = new ArrayList<>();
            p2cards.add(c6);
            p2cards.add(c7);
            p2cards.add(c8);
            p2cards.add(c9);
            p2cards.add(c10);
            Hand p2hand = new Hand("p2hand");
            p2hand.setCards(p2cards);
            p2.setHand(p2hand);

            //Builds the game with all of the objects needed
            GameController game = new GameController(board,p1,p2,Integer.parseInt(numPlayers),roundCount, diff);

            //Starts the game and tracks the winner in the global vars
            List<Integer> stats = game.startGame();
            if (stats.get(0) == 0){
                p1wins++;
            } else{
                p2wins++;
            }


        }

        /* Stat output */
        float p1float = ((p1wins * 100.0f) / roundCount);
        float p2float = ((p2wins * 100.0f)/ roundCount);
        System.out.println("\n");
        System.out.println("Player 1 Wins: " + p1wins + "  " + p1float +"%");
        System.out.println("Player 2 Wins: " + p2wins + "  " + p2float +"%");

        double x = p1wins;
        double u = floor(roundCount / 2);
        double n = roundCount;
        double q = .55;
        double r = (1 - q);
        double z;
        String val;
        double num = (x - u);
        double sq = sqrt(n * q * r);
        z = num / sq;
        val = Double.toString(z);
        System.out.println("Z-Score Against Random Card Placing AI: " + val);

    }

    //random Card generation for a different hand for each game
    public static Card randomCard(int p){
        String[] names = {"Kinemon","Shaymon","Cryomon","Twimon","Jillmon","Venomon","Sarumon","Canimon","Purimon","Saltmon","liemon","Pokemon","Monmon","Geemon","Deemon"};
        int index = new Random().nextInt(names.length);
        String name = names[index];
        int player = 0;
        if(p == 1){
            player = 1;
        }
        Card c = new Card(name, ThreadLocalRandom.current().nextInt(1, 9),ThreadLocalRandom.current().nextInt(1, 9),ThreadLocalRandom.current().nextInt(1, 9),ThreadLocalRandom.current().nextInt(1, 9),1,player);
        return c;
    }



}
