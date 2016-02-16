package com.capgemini.pokerHands;

public enum CardColor {
	
	DIAMONDS (1,"D"), CLUBS(2,"C"), SPADES(3,"S"),HEARTS(4,"H");
	
	private Integer color;
	private String colorStr;
	
	private CardColor(Integer color, String colorStr){
		this.color = color;
		this.colorStr = colorStr;
	}
		
	public Integer getCardColor(){
		return color;
	}
	
	private String getCardColorStr(){
		return colorStr;
	}
	
	public static CardColor getValueForColorString(String colorStr){
		for (CardColor color : CardColor.values()) {
			if(color.getCardColorStr().equals(colorStr)){
				return color;
			}
		}
		return null;
	}
}


