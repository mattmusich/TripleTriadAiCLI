package me.musich.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 10/28/2015.
 */
public class Player {

    public static final int PLAYER_NUMBER_ONE = 1;
    public static final int PLAYER_NUMBER_TWO = 2;

    private String name;
    private Hand cards;
    private int currentDeckIndex;
    private int playerNumber;

    public Player(String name) {
        this.name = name;

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
