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
                cardCapture(pos,card);
                break;
            case 2:
                slots[1][0].setCard(card);
                cardCapture(pos,card);
                break;
            case 3:
                slots[2][0].setCard(card);
                cardCapture(pos,card);
                break;
            case 4:
                slots[0][1].setCard(card);
                cardCapture(pos,card);
                break;
            case 5:
                slots[1][1].setCard(card);
                cardCapture(pos,card);
                break;
            case 6:
                slots[2][1].setCard(card);
                cardCapture(pos,card);
                break;
            case 7:
                slots[0][2].setCard(card);
                cardCapture(pos,card);
                break;
            case 8:
                slots[1][2].setCard(card);
                cardCapture(pos,card);
                break;
            case 9:
                slots[2][2].setCard(card);
                cardCapture(pos,card);
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
                if(slots[1][0].getCard() != null) {
                    if (slots[0][0].getCard().getrightVal() > slots[1][0].getCard().getleftVal()) { // right
                        slots[1][0].getCard().flipStatus();
                    }
                }
                if(slots[0][1].getCard() != null) {
                    if (slots[0][0].getCard().getdownVal() > slots[0][1].getCard().getupVal()) { // down
                        slots[0][1].getCard().flipStatus();
                    }
                }
                break;
            case 2:
                if(slots[0][0].getCard() != null) {
                    if (slots[1][0].getCard().getleftVal() > slots[0][0].getCard().getrightVal()) { //left
                        slots[0][0].getCard().flipStatus();
                    }
                }
                if(slots[2][0].getCard() != null) {
                    if (slots[1][0].getCard().getrightVal() > slots[2][0].getCard().getleftVal()) { //right
                        slots[2][0].getCard().flipStatus();
                    }
                }
                if(slots[1][1].getCard() != null) {
                    if (slots[1][0].getCard().getdownVal() > slots[1][1].getCard().getupVal()) { //down
                        slots[1][1].getCard().flipStatus();
                    }
                }
                break;
            case 3:
                if(slots[1][0].getCard() != null) {
                    if (slots[2][0].getCard().getleftVal() > slots[1][0].getCard().getrightVal()) { // left
                        slots[1][0].getCard().flipStatus();
                    }
                }
                if(slots[2][1].getCard() != null) {
                    if (slots[2][0].getCard().getdownVal() > slots[2][1].getCard().getupVal()) { // down
                        slots[2][1].getCard().flipStatus();
                    }
                }
                break;
            case 4:
                if(slots[0][0].getCard() != null) {
                    if (slots[0][1].getCard().getupVal() > slots[0][0].getCard().getdownVal()) { //up
                        slots[0][0].getCard().flipStatus();
                    }
                }
                if(slots[1][1].getCard() != null) {
                    if (slots[0][1].getCard().getrightVal() > slots[1][1].getCard().getleftVal()) { //right
                        slots[1][1].getCard().flipStatus();
                    }
                }
                if(slots[0][2].getCard() != null) {
                    if(slots[0][1].getCard().getdownVal() > slots[0][2].getCard().getupVal()){ //down
                        slots[0][2].getCard().flipStatus();
                    }
                }
                break;
            case 5:
                if(slots[1][0].getCard() != null) {
                    if (slots[1][1].getCard().getupVal() > slots[1][0].getCard().getdownVal()) { //up
                        slots[1][0].getCard().flipStatus();
                    }
                }
                if(slots[0][1].getCard() != null) {
                    if (slots[1][1].getCard().getleftVal() > slots[0][1].getCard().getrightVal()) { //left
                        slots[0][1].getCard().flipStatus();
                    }
                }
                if(slots[2][1].getCard() != null) {
                    if (slots[1][1].getCard().getrightVal() > slots[2][1].getCard().getleftVal()) { //right
                        slots[2][1].getCard().flipStatus();
                    }
                }
                if(slots[1][2].getCard() != null) {
                    if (slots[1][1].getCard().getdownVal() > slots[1][2].getCard().getupVal()) { //down
                        slots[1][2].getCard().flipStatus();
                    }
                }
                break;
            case 6:
                if(slots[2][0].getCard() != null) {
                    if (slots[2][1].getCard().getupVal() > slots[2][0].getCard().getdownVal()) { //up
                        slots[2][0].getCard().flipStatus();
                    }
                }
                if(slots[1][1].getCard() != null) {
                    if (slots[2][1].getCard().getleftVal() > slots[1][1].getCard().getrightVal()) { //left
                        slots[1][1].getCard().flipStatus();
                    }
                }
                if(slots[2][2].getCard() != null) {
                    if (slots[2][1].getCard().getdownVal() > slots[2][2].getCard().getupVal()) { //down
                        slots[2][2].getCard().flipStatus();
                    }
                }
                break;
            case 7:
                if(slots[0][1].getCard() != null) {
                    if (slots[0][2].getCard().getupVal() > slots[0][1].getCard().getdownVal()) { // up
                        slots[0][1].getCard().flipStatus();
                    }
                }
                if(slots[1][2].getCard() != null) {
                    if (slots[0][2].getCard().getrightVal() > slots[1][2].getCard().getleftVal()) { // right
                        slots[1][2].getCard().flipStatus();
                    }
                }
                break;
            case 8:
                if(slots[1][1].getCard() != null) {
                    if (slots[1][2].getCard().getupVal() > slots[1][1].getCard().getdownVal()) { //up
                        slots[1][1].getCard().flipStatus();
                    }
                }
                if(slots[0][2].getCard() != null) {
                    if (slots[1][2].getCard().getleftVal() > slots[0][2].getCard().getrightVal()) { // left
                        slots[0][2].getCard().flipStatus();
                    }
                }
                if(slots[2][2].getCard() != null) {
                    if (slots[1][2].getCard().getrightVal() > slots[2][2].getCard().getleftVal()) { //right
                        slots[2][2].getCard().flipStatus();
                    }
                }
                break;
            case 9:
                if(slots[1][2].getCard() != null) {
                    if (slots[2][2].getCard().getleftVal() > slots[1][2].getCard().getrightVal()) { // left
                        slots[1][2].getCard().flipStatus();
                    }
                }
                if(slots[2][1].getCard() != null) {
                    if (slots[2][2].getCard().getupVal() > slots[2][1].getCard().getdownVal()) { // up
                        slots[2][1].getCard().flipStatus();
                    }
                }
                break;
        }
    }
}
