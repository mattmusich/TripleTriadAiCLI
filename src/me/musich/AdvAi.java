package me.musich;

import me.musich.base.Board;
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

    public List<Integer> getPlay(Player p){

        if(board.isBoardEmpty()){
            int cIndex = p.getCurrentHand().getBestCornerCard();
            data.add(cIndex);
//            System.out.println("Turn 1 Card Choice: " +cIndex);
            int sIndex = 1;
            data.add(sIndex);
        } else{
            int cIndex = ThreadLocalRandom.current().nextInt(0, 4);
            data.add(cIndex);
//            System.out.println("Turn 2 Card Choice: " +cIndex);
            int sIndex = ThreadLocalRandom.current().nextInt(1, 10);
            data.add(sIndex);
        }

        return data;
    }


}
