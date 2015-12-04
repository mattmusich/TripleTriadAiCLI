package me.musich;
import me.musich.base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by matt on 11/2/2015.
 * This runs the bulk of the basic game operations including user input if a human is playing
 */
public class GameController {

    public Player p1;
    public Player p2;
    public Player currentP;
    public int playerCount; //0 = ai ai | 1 = player ai | 2 = player player
    public int games;
    public int diff;
    public Board board;

    public ArrayList<Integer> usedSlots;

    //constructor
    public GameController(Board board, Player p1, Player p2, int playerCount, int games, int diff){
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.playerCount = playerCount;
        this.games = games;
        this.diff = diff;
    }

    //a single game is run through this function
    public List<Integer> startGame(){
        List<Integer> stats = new ArrayList<>();
        usedSlots = new ArrayList<>();

        //loops for the 9 needed turns to fill the board
        for (int i = 1; i <= 9; i++){

            //board output and hand output for AI monitoring
            if(playerCount != 0 || games <= 25 ) {
                System.out.println(board.showBoard() + "\n\n");
              if(playerCount == 0){
                  System.out.println(p1.getCurrentHand().toString() + "\n" + p2.getCurrentHand().toString());
              }
            }

            //All plays are routed to here and are added to the board using the setSlot() on the board object
            // s = the slot index     c = the card index
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9){ //turns 1 3 5 7 9
                if(playerCount == 0) { //ai
                    List<Integer> data = getAdvAICommand(p1);
                    int s = data.get(1);
                    int c = data.get(0);
                    board.setSlot(s, p1.getCurrentHand().getCards().get(c));
                    p1.getCurrentHand().getCards().remove(c);
                }
                if(playerCount == 1 || playerCount == 2){ //human
                    List<Integer> data = getCommand(p1);
                    int s = data.get(1);
                    int c = data.get(0);
                    board.setSlot(s, p1.getCurrentHand().getCards().get(c));
                    p1.getCurrentHand().getCards().remove(c);
                }
            } else { //turns 2 4 6 8
                if(playerCount == 0 || playerCount == 1) { //ai If the diff is 0 then it runs the basic AI and if diff is 1 it runs the advanced aI
                    List<Integer> data;
                    if(diff == 0) {
                        data = getAICommand(p2); //basic 0
                    } else {
                        data = getAdvAICommand(p2); //advanced 1
                    }
                    int s = data.get(1);
                    int c = data.get(0);
                    board.setSlot(s, p2.getCurrentHand().getCards().get(c));
                    p2.getCurrentHand().getCards().remove(c);
                }
                if(playerCount == 2){ //human
                    List<Integer> data = getCommand(p2);
                    int s = data.get(1);
                    int c = data.get(0);
                    board.setSlot(s, p2.getCurrentHand().getCards().get(c));
                    p2.getCurrentHand().getCards().remove(c);
                }
            }
        }

        //shows the winner if humans are playing or for ai monitoring
        if(playerCount != 0 || games <= 25) {
            System.out.println("FINAL BOARD:\n");
            System.out.println(board.showBoard());
            System.out.println(getWinner().getName() + " Is the Winner!");
            System.out.println("Game Over");
        } else {
            System.out.println(getWinner().getName() + " Is the Winner!");
        }

        //finds the winner and returns who won to the main method
        if (getWinner().getName().equals("Player 1")){
            stats.add(0);
        } else {
            stats.add(1);
        }

        return stats;
    }

    //gets the human players command for card and slot
    public List<Integer> getCommand(Player p){ //User input
        List<Integer> data = new ArrayList<>();
        boolean used = false;
        boolean cardused = false;
        //gets the card and prevents crashes
        while (!cardused) {
            System.out.println(p.getCurrentHand().toString());
            System.out.println(p.getName() + " select card index (0-" + (p.getCurrentHand().getCards().size()-1) + "):");
            Scanner scanner = new Scanner(System.in);
            String cIndex = scanner.nextLine();
            if(!cIndex.equals("")) {
                if (Integer.parseInt(cIndex) <= p.getCurrentHand().getCards().size() - 1 && Integer.parseInt(cIndex) >= 0) {
                    data.add(Integer.parseInt(cIndex));
                    cardused = true;
                } else {
                    System.out.println("Error: Card out of Range \n Please enter a number from 0-" + (p.getCurrentHand().getCards().size() - 1));

                }
            } else {
                System.out.println("Error: Please enter a number \n Please enter a number from 0-" + (p.getCurrentHand().getCards().size() - 1));
            }
        }
        //gets the slot and prevents crashes
        while(!used) { //error check to see if slot is used in the game without having to parse the board
            System.out.println(p.getName() + " select Slot (1-9):");
            Scanner scanner = new Scanner(System.in);
            String sIndex = scanner.nextLine();
            if(!sIndex.equals("")) {
                if (Integer.parseInt(sIndex) <= 9 && Integer.parseInt(sIndex) >= 1) {
                    if (!usedSlots.contains(Integer.parseInt(sIndex))) {
                        used = true;
                        data.add(Integer.parseInt(sIndex));
                        usedSlots.add(Integer.parseInt(sIndex));
                    } else {
                        System.out.println("Error: Slot already used");
                    }
                } else {
                    System.out.println("Error: Slot out of Range \n Please enter a number from 1-9");
                }
            } else {
                System.out.println("Error: Please enter a number from 1-9");
            }
        }
        return data;
    }

    /* This is the ALPHA AI, it selects a random card and a random slot and send back the data to make the play*/
    public List<Integer> getAICommand(Player p){ //Basic AI input
        List<Integer> data = new ArrayList<>();
        boolean used = false;

        int cIndex = ThreadLocalRandom.current().nextInt(0, p.getCurrentHand().getCards().size());
        data.add(cIndex);
        while(!used) { //error check to see if slot is used in the game without having to parse the board
            int sIndex = ThreadLocalRandom.current().nextInt(1, 10);
            //System.out.println(sIndex);
            if (!usedSlots.contains(sIndex)) {
                used = true;
                data.add(sIndex);
                usedSlots.add(sIndex);
            } else {
                //System.out.println("Error: Slot already used");
            }
        }
        return data;
    }

    /* This is the BETA AI, it preps for the output the AI will make,
     then creates an AdvAi object which controls the decisions made and gets a play from the obj by sending it a player and the current board*/
    public List<Integer> getAdvAICommand(Player p) { //
        List<Integer> data = new ArrayList<>();
        boolean used = false;
        while(!used) { //error check to see if slot is used in the game without having to parse the board
            Board b = board;
            AdvAi play = new AdvAi(b);
            data = play.getPlay(p);
            int sIndex = data.get(1);
            if (!usedSlots.contains(sIndex)) {
                used = true;
                data.add(sIndex);
                usedSlots.add(sIndex);
            } else {
                //System.out.println("Error: Slot already used");
            }
        }

        return data;
    }

    // Tallies up the cards on the board to decide the winner
    public Player getWinner(){
        int p1c = 0;
        int p2c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board.getSlots()[i][j].getCard().getStatus() == 0){
                    p1c++;
                } else {
                    p2c++;
                }
            }
        }
        if(p1c > p2c){
            return p1;
        } else{
            return p2;
        }
    }
}
