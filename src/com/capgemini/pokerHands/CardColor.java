package com.capgemini.pokerHands;

public enum CardColor {

    D(1, "D"), C(2, "C"), S(3, "S"), H(4, "H");

    private Integer color;
    private String stringColor;

    private CardColor(Integer color, String strColor) {
        this.color = color;
        this.stringColor = strColor;
    }

    public Integer getIntegerValue() {
        return color;
    }

    private String getStringValue() {
        return stringColor;
    }

    public static CardColor getIntegerValueForStringValue(String colorStr) {
        // REVIEW bzychal - please change to Java8 findFirst
        for (CardColor color : CardColor.values()) {
            if (color.getStringValue().equals(colorStr)) {
                return color;
            }
        }
        return null;
    }
}
