package com.capgemini.pokerHands;

public class CardParser {

    public static Card parseString(String card) {
        return new Card(getValue(card), getColor(card));
    }

    private static CardColor getColor(String card) {
        // REVIEW bzychal - there is a dedicated method for build the enum value out of the name, please see below.
        CardColor color = CardColor.valueOf(card.substring(1, 2));// getIntegerValueForStringValue(card.substring(1,
                                                                  // 2));
        // REVIEW bzychal - then if above is defined it will throw an exception if not matching value is given to the
        // valueOf method, so this case cannot happen
        if (color == null) {
            throw new IllegalArgumentException("Color does not exists");
        }
        return color;
    }

    private static CardValue getValue(String card) {
        CardValue value = CardValue.getIntegerColorForStringColor(card.substring(0, 1));
        if (value == null) {
            throw new IllegalArgumentException("Value does not exists");
        }
        return value;
    }
}
