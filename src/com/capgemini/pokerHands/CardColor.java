package com.capgemini.pokerHands;

public enum CardColor {
	
	DIAMONDS (1,"D"), CLUBS(2,"C"), SPADES(3,"S"),HEARTS(4,"H");
	
	private Integer color;
	private String stringColor;
	
	private CardColor(Integer color, String strColor){
		this.color = color;
		this.stringColor = strColor;
	}
		
	public Integer getIntegerValue(){
		return color;
	}
	
	private String getStringValue(){
		return stringColor;
	}
	
	public static CardColor getIntegerValueForStringValue(String colorStr){
		for (CardColor color : CardColor.values()) {
			if(color.getStringValue().equals(colorStr)){
				return color;
			}
		}
		return null;
	}
}


