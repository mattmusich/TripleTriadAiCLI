package me.musich;

import me.musich.base.Board;
import me.musich.base.Card;
import me.musich.base.Player;
import me.musich.base.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by matt on 11/24/2015.
 */
public class AdvAi {

    List<Integer> data = new ArrayList<>();
    public int cIndex;
    public int sIndex;

    public Board board;

    public AdvAi(Board b) {
        this.board = b;
    }

    public List<Integer> getPlay(Player p) {

        if (board.isBoardEmpty()) { //Plays the best corner card in the top right corner on first turn
            int cIndex = p.getCurrentHand().getBestTopLeftCornerCard();
            data.add(cIndex);
            int sIndex = 1;
            data.add(sIndex);
            /*Turn End*/
            //System.out.println("Turn 1 Card Choice: " +cIndex);
        } else {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Slot s = board.slots[i][j];
                    if (s.getCard() != null) { //card is in the slot
                        //System.out.println("slot [" + i + "," + j + "] has a card");
                    } else {
                        //check if there are 2 enemy cards next to the empty slot
                        //System.out.println("slot [" + i + "," + j + "] is empty");


                        int bestCard = p.getCurrentHand().getWeakestCard();  //TODO Get the best card to play based on 2 captures
                        if (isInGrid(i,j-1) && board.slots[i][j-1].getCard() != null) {
                            //System.out.println("Card is above " + board.slots[i][j-1].getCard().getName());
                            if(board.slots[i][j-1].getCard().getStatus() != p.getPlayerNumber()) {
                                for (Card c : p.getCurrentHand().getCards()) {
                                    if (c.getupVal() > board.slots[i][j - 1].getCard().getdownVal()) {
                                        //if (c.getupVal() < p.getCurrentHand().getCards().get(bestCard).getupVal()) {
                                            bestCard = p.getCurrentHand().getCardIndex(c);
                                            //System.out.println("BestCard Beat Above = " + c.getName());
                                        //}
                                    }
                                }
                            }
                        }
                        if (isInGrid(i+1,j) && board.slots[i+1][j].getCard() != null) {
                            //System.out.println("Card is right " + board.slots[i+1][j].getCard().getName());
                            if(board.slots[i+1][j].getCard().getStatus() != p.getPlayerNumber()) {
                                for (Card c : p.getCurrentHand().getCards()) {
                                    if (c.getrightVal() > board.slots[i + 1][j].getCard().getleftVal()) {
                                        //if (c.getrightVal() < p.getCurrentHand().getCards().get(bestCard).getrightVal()) {
                                            bestCard = p.getCurrentHand().getCardIndex(c);
                                            //System.out.println("BestCard Beat Right = " + c.getName());
                                        //}
                                    }
                                }
                            }

                        }
                        if (isInGrid(i,j+1) && board.slots[i][j+1].getCard() != null) {
                            //System.out.println("Card is below " + board.slots[i][j+1].getCard().getName());
                            if(board.slots[i][j+1].getCard().getStatus() != p.getPlayerNumber()) {
                                for (Card c : p.getCurrentHand().getCards()) {
                                    if (c.getdownVal() > board.slots[i][j + 1].getCard().getupVal()) {
                                        //if (c.getdownVal() < p.getCurrentHand().getCards().get(bestCard).getdownVal()) {
                                            bestCard = p.getCurrentHand().getCardIndex(c);
                                            //System.out.println("BestCard Beat Below = " + c.getName());
                                        //}
                                    }
                                }
                            }
                        }
                        if (isInGrid(i-1,j) && board.slots[i-1][j].getCard() != null) {
                            //System.out.println("Card is left " + board.slots[i-1][j].getCard().getName());
                            if(board.slots[i-1][j].getCard().getStatus() != p.getPlayerNumber()) {
                                for (Card c : p.getCurrentHand().getCards()) {
                                    if (c.getleftVal() > board.slots[i - 1][j].getCard().getrightVal()) {
                                        //if (c.getleftVal() < p.getCurrentHand().getCards().get(bestCard).getleftVal()) {
                                            bestCard = p.getCurrentHand().getCardIndex(c);
                                            //System.out.println("BestCard Beat Left = " + c.getName());
                                        //}
                                    }
                                }
                            }
                        }


                        //TODO if not get one for one capture

                        int cIndex = bestCard;
                        data.add(cIndex);
                        int sIndex = getSlotIndex(i,j);
                        data.add(sIndex);
                        //System.out.println("cIndex " + cIndex + "  sIndex " + sIndex);
                        return data; //returns when a good card is found
                    }
                }




                int cIndex = ThreadLocalRandom.current().nextInt(0, p.getCurrentHand().getCards().size());
                data.add(cIndex);
//            System.out.println("Turn 2 Card Choice: " +cIndex);
                int sIndex = ThreadLocalRandom.current().nextInt(1, 10);
                data.add(sIndex);
            }

            return data; //returns all random choices
        }
        return data; //returns first turn
    }

    public boolean isInGrid(int x, int y) {
        //Check if a position is valid in the grid

        if(x < 0 || y < 0){
            return false;
        }
        if(x >= 3 || y >= 3) {
            return false;
        }
        //System.out.println("isInGrid "+ x + "," + y);
        return true;
    }

    public int getSlotIndex(int x, int y){
        if(x == 0 && y == 0){return 1;}
        if(x == 1 && y == 0){return 2;}
        if(x == 2 && y == 0){return 3;}
        if(x == 0 && y == 1){return 4;}
        if(x == 1 && y == 1){return 5;}
        if(x == 2 && y == 1){return 6;}
        if(x == 0 && y == 2){return 7;}
        if(x == 1 && y == 2){return 8;}
        if(x == 2 && y == 2){return 9;}
        return -1;
    }

}
