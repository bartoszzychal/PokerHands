package com.capgemini.pokerHands;

public class Card {
	
	private CardValue value;
	private CardColor color;

	public Card(CardValue value, CardColor color) {
		if (value== null) {
			throw new IllegalArgumentException("Value is null");
		}
		if (color == null) {
			throw new IllegalArgumentException("Color is null");
		}
		this.value = value;
		this.color = color;
	}

	public Integer getValue() {
		return value.intValue();
	}
	
	public Integer getColor() {
		return color.getCardColor();
	}
	
	public CardValue getCardValue(){
		return value;
	}
	
	public CardColor getCardColor(){
		return color;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}	
}
