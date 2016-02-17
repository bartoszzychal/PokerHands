package com.capgemini.pokerHands;

public class CardParser {
	
	public static Card parseString(String card){
		return new Card(getValue(card),getColor(card));
	}

	private static CardColor getColor(String card){
		CardColor color = CardColor.getIntegerValueForStringValue(card.substring(1, 2));
		if(color == null){
			throw new IllegalArgumentException("Color does not exists");
		}
		return color;
	}
	
	private static CardValue getValue(String card){
		CardValue value = CardValue.getIntegerColorForStringColor(card.substring(0,1));
		if(value == null){
			throw new IllegalArgumentException("Value does not exists");
		}
		return value;
	}
}
