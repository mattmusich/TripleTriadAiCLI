package me.musich.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 10/28/2015.
 */
public class Player {


    private String name;
    private Hand cards;
    private int currentDeckIndex;
    private int playerNumber;

    public Player(String name, int num) {
        this.name = name;
        this.playerNumber = num;
        cards = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return cards;
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

    public int getCurrentHandIndex() {
        return currentDeckIndex;
    }

    public void setCurrentHandIndex(int currentDeckIndex) {
        this.currentDeckIndex = currentDeckIndex;
    }

    public Hand getCurrentHand() {
        return cards;
    }

}
