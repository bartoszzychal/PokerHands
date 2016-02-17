package com.capgemini.pokerHands;

public enum CardValue {
	TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"),
	EIGHT(8,"8"), NINE(9,"9"), TEEN(10,"T"), JACK(11,"J"), QUEEN(12,"Q"), KING(13,"K"), ACE(14,"A");

	private Integer value;
	private String stringValue;
	
	private CardValue(int value, String stringValue) {
		this.value = value;
		this.stringValue = stringValue;
	}

	public Integer getIntegerValue() {
		return value;
	}
	
	private String getStringValue(){
		return stringValue;
	}
		
	public static CardValue getIntegerColorForStringColor(String valueStr){
		for (CardValue value: CardValue.values()) {
			if(value.getStringValue().equals(valueStr)){
				return value;
			}
		}
		return null;
	}

}