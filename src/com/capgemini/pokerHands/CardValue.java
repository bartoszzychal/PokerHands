package com.capgemini.pokerHands;

public enum CardValue {
	TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"),
	EIGHT(8,"8"), NINE(9,"9"), TEEN(10,"T"), JACK(11,"J"), QUEEN(12,"Q"), KING(13,"K"), ACE(14,"A");

	private Integer value;
	private String valueStr;
	
	private CardValue(int value, String valueStr) {
		this.value = value;
		this.valueStr = valueStr;
	}

	public Integer getCardValue() {
		return value;
	}
	
	private String getCardValueStr(){
		return valueStr;
	}
	
	public static CardValue getValueForColorString(String valueStr){
		for (CardValue value: CardValue.values()) {
			if(value.getCardValueStr().equals(valueStr)){
				return value;
			}
		}
		return null;
	}
	
	
}