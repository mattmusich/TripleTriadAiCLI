package me.musich.base;

/**
 * Created by matt on 10/27/2015.
 */
public class Board {

    private Slot[][] slots;

    public Board() {
        slots = new Slot[3][3];
    }

    public Slot[][] getSlots() {
        return slots;
    }

    public void setSlots(Slot[][] slots) {
        this.slots = slots;
    }


    public String showBoard(){
        String b = "";

        if(slots[0][0].getCard() != null) {
            b += slots[0][0].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[1][0].getCard() != null) {
            b += slots[1][0].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[2][0].getCard() != null) {
            b += slots[2][0].getCard().getVals();
        } else { b += "       ";}
        b += "\n-----------------------\n";
        if(slots[0][1].getCard() != null) {
            b += slots[0][1].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[1][1].getCard() != null) {
            b += slots[1][1].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[2][1].getCard() != null) {
            b += slots[2][1].getCard().getVals();
        } else { b += "       ";}
        b += "\n-----------------------\n";
        if(slots[0][2].getCard() != null) {
            b += slots[0][2].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[1][2].getCard() != null) {
            b += slots[1][2].getCard().getVals();
        } else { b += "       ";}
        b += "|";
        if(slots[2][2].getCard() != null) {
            b += slots[2][2].getCard().getVals();
        } else { b += "       ";}
        b += "\n";
        return b;
    }
}
