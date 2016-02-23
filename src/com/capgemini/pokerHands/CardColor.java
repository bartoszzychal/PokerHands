package com.capgemini.pokerHands;

public enum CardColor {

    D(1), C(2), S(3), H(4);

    private int color;

    private CardColor(int color) {
        this.color = color;
    }

    public int getIntegerValue() {
        return color;
    }
}
