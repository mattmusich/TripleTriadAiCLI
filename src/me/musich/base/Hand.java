package me.musich.base;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by matt on 10/27/2015.
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

    public int getBestCornerCard(){
        Card bestCard = new Card("default", 0, 0, 0, 0, 0, 0);
        for (Card c: cards) {
            if(c.getdownVal() > bestCard.getdownVal()){
                if(c.getrightVal() > bestCard.getrightVal()){
                    bestCard = c;
                } else if (c.getdownVal() > bestCard.getrightVal()){
                    bestCard = c;
                }
            }
        }
        return getCardIndex(bestCard);
    }
}
