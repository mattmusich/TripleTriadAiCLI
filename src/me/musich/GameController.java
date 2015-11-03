package me.musich;
import me.musich.base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by matt on 11/2/2015.
 */
public class GameController {

    public Player p1;
    public Player p2;
    public Player currentP;

    public Board board;

    public ArrayList<Integer> usedSlots;

    public GameController(Board board, Player p1, Player p2){
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void startGame(){

        usedSlots = new ArrayList<>();

        for (int i = 1; i <= 9; i++){
            System.out.println(board.showBoard());

            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9){ //turns 1 3 5 7 9
                List<Integer> data = getAICommand(p1);
                int c = data.get(1);
                int s = data.get(0);
                System.out.println(c + " " + s);
                System.out.println(c + " " + p1.getCurrentHand().getCards().get(s).getName());
                board.setSlot(c, p1.getCurrentHand().getCards().get(s));

            } else { //turns 2 4 6 8
                List<Integer> data = getAICommand(p2);
                int c = data.get(1);
                int s = data.get(0);
                System.out.println(c + " " + s);
                System.out.println(c + " " + p1.getCurrentHand().getCards().get(s).getName());
                board.setSlot(c, p2.getCurrentHand().getCards().get(s));
            }

        }
        System.out.println("FINAL BOARD:\n");
        System.out.println(board.showBoard());
        System.out.println(getWinner().getName() + " Is the Winner!");
        System.out.println("Game Over");
    }

    public List<Integer> getCommand(Player p){ //User input
        List<Integer> data = new ArrayList<>();
        boolean used = false;
        System.out.println(p.getCurrentHand().toString());
        System.out.println(p.getName() + " select card index:");
            Scanner scanner = new Scanner(System.in);
            String cIndex = scanner.nextLine();
            data.add(Integer.parseInt(cIndex));
        while(!used) { //error check to see if slot is used in the game without having to parse the board
            System.out.println(p.getName() + " select Slot:");
            String sIndex = scanner.nextLine();
            if (!usedSlots.contains(Integer.parseInt(sIndex))) {
                used = true;
                data.add(Integer.parseInt(sIndex));
                usedSlots.add(Integer.parseInt(sIndex));
            } else {
                System.out.println("Error: Slot already used");
            }
        }
        return data;
    }

    public List<Integer> getAICommand(Player p){ //User input
        List<Integer> data = new ArrayList<>();
        boolean used = false;

        int cIndex = ThreadLocalRandom.current().nextInt(0, 4);
        data.add(cIndex);
        while(!used) { //error check to see if slot is used in the game without having to parse the board
            int sIndex = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.println(sIndex);
            if (!usedSlots.contains(sIndex)) {
                used = true;
                data.add(sIndex);
                usedSlots.add(sIndex);
            } else {
                System.out.println("Error: Slot already used");
            }
        }
        return data;
    }

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
