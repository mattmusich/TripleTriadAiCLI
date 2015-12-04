package me.musich.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 10/28/2015.
 */
public class Player {

    private String name;
    private Hand cards;
    private int playerNumber;

    public Player(String name, int num) {
        this.name = name;
        this.playerNumber = num;
        cards = null;
    }

    //getters and Setters for Player
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(Hand cards) {
        this.cards = cards;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Hand getCurrentHand() {
        return cards;
    }

}
