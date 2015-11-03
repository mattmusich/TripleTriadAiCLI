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

    public void setSlot(int pos, Card card){
        switch (pos) {
            case 1:
                slots[0][0].setCard(card);
                break;
            case 2:
                slots[1][0].setCard(card);
                break;
            case 3:
                slots[2][0].setCard(card);
                break;
            case 4:
                slots[0][1].setCard(card);
                break;
            case 5:
                slots[1][1].setCard(card);
                break;
            case 6:
                slots[2][1].setCard(card);
                break;
            case 7:
                slots[0][2].setCard(card);
                break;
            case 8:
                slots[1][2].setCard(card);
                break;
            case 9:
                slots[2][2].setCard(card);
                break;
        }
    }

    public String showBoard(){
        String b = "";

        if(slots[0][0].getCard() != null) {
            b += slots[0][0].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[1][0].getCard() != null) {
            b += slots[1][0].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[2][0].getCard() != null) {
            b += slots[2][0].getCard().getBoardString();
        } else { b += "         ";}
        b += "\n-----------------------------\n";
        if(slots[0][1].getCard() != null) {
            b += slots[0][1].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[1][1].getCard() != null) {
            b += slots[1][1].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[2][1].getCard() != null) {
            b += slots[2][1].getCard().getBoardString();
        } else { b += "         ";}
        b += "\n-----------------------------\n";
        if(slots[0][2].getCard() != null) {
            b += slots[0][2].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[1][2].getCard() != null) {
            b += slots[1][2].getCard().getBoardString();
        } else { b += "         ";}
        b += "|";
        if(slots[2][2].getCard() != null) {
            b += slots[2][2].getCard().getBoardString();
        } else { b += "         ";}
        b += "\n";
        return b;
    }

    public void cardCapture(int pos, Card card){
        switch (pos) {
            case 1:
                
                slots[0][0].setCard(card);
                break;
            case 2:
                slots[1][0].setCard(card);
                break;
            case 3:
                slots[2][0].setCard(card);
                break;
            case 4:
                slots[0][1].setCard(card);
                break;
            case 5:
                slots[1][1].setCard(card);
                break;
            case 6:
                slots[2][1].setCard(card);
                break;
            case 7:
                slots[0][2].setCard(card);
                break;
            case 8:
                slots[1][2].setCard(card);
                break;
            case 9:
                slots[2][2].setCard(card);
                break;
        }
    }
}
