package com.capgemini.pokerHands;

import java.util.logging.Logger;

public class CardParser {
	
	static Logger logger = Logger.getGlobal();
	public static Card parseString(String card){
		return new Card(getValue(card),getColor(card));
	}

	private static CardColor getColor(String card){
		CardColor color = CardColor.getValueForColorString(card.substring(1, 2));
		if(color == null){
			throw new IllegalArgumentException("Color does not exists");
		}
		return color;
	}
	
	private static CardValue getValue(String card){
		CardValue value = CardValue.getValueForColorString(card.substring(0,1));
		if(value == null){
			throw new IllegalArgumentException("Value does not exists");
		}
		return value;
	}
}
