package com.capgemini.pokerHands;

public class CardParser {

    public static Card parseString(String card) {
        return new Card(getValue(card), getColor(card));
    }

    private static CardColor getColor(String card) {
    	return CardColor.valueOf(card.substring(1, 2));
    }

    private static CardValue getValue(String card) {
        return CardValue.getValueOf(card.substring(0,1));
    }
}
