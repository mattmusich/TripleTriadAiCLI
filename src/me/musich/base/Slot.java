package me.musich.base;

/**
 * Created by matt on 10/27/2015.
 * A Slot contains a single card object or nothing
 */
public class Slot {

    private Card card = null;

    public Slot() {}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
