package com.capgemini.pokerHands;

public class CardParser {

    public static Card parseString(String card) {
        return new Card(getValue(card), getColor(card));
    }

    private static CardColor getColor(String card) {
        //FIX REVIEW bzychal - there is a dedicated method for build the enum value out of the name, please see below.
        // getIntegerValueForStringValue(card.substring(1,2));
    	return CardColor.valueOf(card.substring(1, 2));
    }

    private static CardValue getValue(String card) {
    	//FIX cannot create numeric enum, so this enum must be like past
        return CardValue.getValueOf(card.substring(0,1)); //getIntegerColorForStringColor(card.substring(0, 1));
    }
}
