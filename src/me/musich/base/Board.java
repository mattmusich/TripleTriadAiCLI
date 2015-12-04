package me.musich.base;

/**
 * Created by matt on 10/27/2015.
 */
public class Board {

    public Slot[][] slots;

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

    public String showBoardCondensed(){
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

    public String showBoard(){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "-----------------------";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "-----------------------";
        String s9 = "";
        String s10 = "";
        String s11 = "";

        //s1 s2 s3
        if(slots[0][0].getCard() != null) {
            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[0][0].getCard().getleftVal();
            s3 += " ";

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += slots[0][0].getCard().getupVal();
            s2 += slots[0][0].getCard().getStatus();
            s3 += slots[0][0].getCard().getdownVal();

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[0][0].getCard().getrightVal();
            s3 += " ";

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += "|";
            s2 += "|";
            s3 += "|";
        } else {
            s1 += "       |";
            s2 += "       |";
            s3 += "       |";
        }
        if(slots[1][0].getCard() != null) {
            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[1][0].getCard().getleftVal();
            s3 += " ";

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += slots[1][0].getCard().getupVal();
            s2 += slots[1][0].getCard().getStatus();
            s3 += slots[1][0].getCard().getdownVal();

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[1][0].getCard().getrightVal();
            s3 += " ";

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += "|";
            s2 += "|";
            s3 += "|";
        } else {
            s1 += "       |";
            s2 += "       |";
            s3 += "       |";
        }
        if(slots[2][0].getCard() != null) {
            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[2][0].getCard().getleftVal();
            s3 += " ";

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += slots[2][0].getCard().getupVal();
            s2 += slots[2][0].getCard().getStatus();
            s3 += slots[2][0].getCard().getdownVal();

            s1 += " ";
            s2 += " ";
            s3 += " ";

            s1 += " ";
            s2 += slots[2][0].getCard().getrightVal();
            s3 += " ";

        } else {
            s1 += "       ";
            s2 += "       ";
            s3 += "       ";
        }

        //s5 s6 s7
        if(slots[0][1].getCard() != null) {
            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[0][1].getCard().getleftVal();
            s7 += " ";

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += slots[0][1].getCard().getupVal();
            s6 += slots[0][1].getCard().getStatus();
            s7 += slots[0][1].getCard().getdownVal();

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[0][1].getCard().getrightVal();
            s7 += " ";

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += "|";
            s6 += "|";
            s7 += "|";
        } else {
            s5 += "       |";
            s6 += "       |";
            s7 += "       |";
        }
        if(slots[1][1].getCard() != null) {
            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[1][1].getCard().getleftVal();
            s7 += " ";

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += slots[1][1].getCard().getupVal();
            s6 += slots[1][1].getCard().getStatus();
            s7 += slots[1][1].getCard().getdownVal();

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[1][1].getCard().getrightVal();
            s7 += " ";

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += "|";
            s6 += "|";
            s7 += "|";
        } else {
            s5 += "       |";
            s6 += "       |";
            s7 += "       |";
        }
        if(slots[2][1].getCard() != null) {
            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[2][1].getCard().getleftVal();
            s7 += " ";

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += slots[2][1].getCard().getupVal();
            s6 += slots[2][1].getCard().getStatus();
            s7 += slots[2][1].getCard().getdownVal();

            s5 += " ";
            s6 += " ";
            s7 += " ";

            s5 += " ";
            s6 += slots[2][1].getCard().getrightVal();
            s7 += " ";

        } else {
            s5 += "       ";
            s6 += "       ";
            s7 += "       ";
        }

        //s9 s10 s11
        if(slots[0][2].getCard() != null) {
            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[0][2].getCard().getleftVal();
            s11 += " ";

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += slots[0][2].getCard().getupVal();
            s10 += slots[0][2].getCard().getStatus();
            s11 += slots[0][2].getCard().getdownVal();

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[0][2].getCard().getrightVal();
            s11 += " ";

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += "|";
            s10 += "|";
            s11 += "|";
        } else {
            s9 += "       |";
            s10 += "       |";
            s11 += "       |";
        }
        if(slots[1][2].getCard() != null) {
            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[1][2].getCard().getleftVal();
            s11 += " ";

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += slots[1][2].getCard().getupVal();
            s10 += slots[1][2].getCard().getStatus();
            s11 += slots[1][2].getCard().getdownVal();

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[1][2].getCard().getrightVal();
            s11 += " ";

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += "|";
            s10 += "|";
            s11 += "|";
        } else {
            s9 += "       |";
            s10 += "       |";
            s11 += "       |";
        }
        if(slots[2][2].getCard() != null) {
            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[2][2].getCard().getleftVal();
            s11 += " ";

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += slots[2][2].getCard().getupVal();
            s10 += slots[2][2].getCard().getStatus();
            s11 += slots[2][2].getCard().getdownVal();

            s9 += " ";
            s10 += " ";
            s11 += " ";

            s9 += " ";
            s10 += slots[2][2].getCard().getrightVal();
            s11 += " ";

        } else {
            s9 += "       ";
            s10 += "       ";
            s11 += "       ";
        }

        return s1 + "\n" + s2  + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n" + s9 + "\n" + s10 + "\n" + s11 + "\n";
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

    public boolean isBoardEmpty(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Slot s = slots[i][j];
                if (s.getCard() != null){
                    return false;
                }
            }
        }
        return true;

    }


}
