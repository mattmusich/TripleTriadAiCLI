package me.musich.base;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by matt on 10/27/2015.
 * A hand contains the list of Cards and a Hand is assigned to the Player object
 * Some of the AI processing is done here to find strong and weak cards in the hand
 */
public class Hand {

    private String name;
    private List<Card> cards;

    public Hand(String name) {
        this.name = name;

        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < this.getCards().size(); i++) {
            s += i + ")";
            s += this.getCards().get(i).getName() + ": ";
            s += this.getCards().get(i).getVals();
            s += "\n";
        }
        return s;
    }

    public int getCardIndex(Card c){
        for(int i = 0; i < this.cards.size(); i++){
            if (c == this.cards.get(i)){
                return i;
            }
        }
        return -1;
    }

    //will return the lowest avg valued card
    public int getWeakestCard(){
        Card worstCard = new Card("default", 9, 9, 9, 9, 0, 0);
        for (Card c: cards) {
            if(c.sumVals() <= worstCard.sumVals()){
                worstCard = c;
            }
        }
        //System.out.println(worstCard.getVals());
        return getCardIndex(worstCard);
    }

    //will return the best card suited for placement in the top left corner of the board
    public int getBestTopLeftCornerCard(){
        Card bestCard = new Card("default", 0, 0, 0, 0, 0, 0);
        for (Card c: cards) {
            if (c.getdownVal() + c.getrightVal() > bestCard.getdownVal() + bestCard.getrightVal()){
                bestCard = c;
            }
        }
        return getCardIndex(bestCard);
    }
}
