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
 * This is the BETA AI for the final project
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
                        /* Next slot */
                    } else {
                        /*check if there are enemy cards next to the empty slot
                         if so a card will be chosen to fill the slot if any of the cards in the hand can capture the adjacent cards*/
                        //System.out.println("slot [" + i + "," + j + "] is empty");

                        /* Starts of the card choice with the weakest card in your hand
                        * It will be replaced if there is a better choice as it checks the adjacent cards*/
                        int bestCard = p.getCurrentHand().getWeakestCard();

                        //Checks the card above for possible capture
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

                        //Checks the card to the right for possible capture
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

                        //checks the card below for possible capture
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

                        //checks the card to the left for possible capture
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

                        //takes the card and slot choice and converts it into a data that can be used for making a play in the GameController
                        int cIndex = bestCard;
                        data.add(cIndex);
                        int sIndex = getSlotIndex(i,j);
                        data.add(sIndex);
                        //System.out.println("cIndex " + cIndex + "  sIndex " + sIndex);
                        return data; //returns when a good card is found
                        /* Turn End */
                    }
                }

                //If no captures can be made on the turn, then the AI will pick a random card and slot as a last resort
                int cIndex = ThreadLocalRandom.current().nextInt(0, p.getCurrentHand().getCards().size());
                //int cIndex = p.getCurrentHand().getWeakestCard();  // .1% decline in wins  Weird that random is better more often than weak card
                data.add(cIndex);
                //System.out.println("Turn 2 Card Choice: " +cIndex);
                int sIndex = ThreadLocalRandom.current().nextInt(1, 10);
                data.add(sIndex);
            }

            return data; //returns all random choices
            /* Turn End */
        }
        return data; //returns first turn
        /* Turn End */
    }

    //Check if a position is valid in the grid  Used for Short Circuiting on Array edge cases to prevent crashes
    public boolean isInGrid(int x, int y) {
        if(x < 0 || y < 0){
            return false;
        }
        if(x >= 3 || y >= 3) {
            return false;
        }
        //System.out.println("isInGrid "+ x + "," + y);
        return true;
    }

    //converts the 2d array coords to a slot number
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
