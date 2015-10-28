package me.musich.base;

/**
 * Created by matt on 10/27/2015.
 */
public class Card {

    private String name;

    private int upVal;
    private int downVal;
    private int leftVal;
    private int rightVal;

    private int level; //artificial avg of the vals to balance cards

    public Card(String name,int upVal, int downVal, int leftVal, int rightVal, int level) {
        this.name = name;
        this.upVal = upVal;
        this.downVal = downVal;
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getupVal() {
        return upVal;
    }

    public void setupVal(int upVal) {
        this.upVal = upVal;
    }

    public int getdownVal() {
        return downVal;
    }

    public void setdownVal(int downVal) {
        this.downVal = downVal;
    }

    public int getleftVal() {
        return leftVal;
    }

    public void setleftVal(int leftVal) {
        this.leftVal = leftVal;
    }

    public int getrightVal() {
        return rightVal;
    }

    public void setrightVal(int rightVal) {
        this.rightVal = rightVal;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getVals(){
        String v = this.upVal + "," + this.rightVal + "," + this.downVal + "," + this.leftVal;
        return v;
    }
}
