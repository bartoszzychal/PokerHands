package com.capgemini.pokerHands;

public class Card implements Comparable<Card> {

    private final CardValue value;
    private final CardColor color;

    public Card(CardValue value, CardColor color) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (color == null) {
        	//FIX create test
            throw new IllegalArgumentException("Color is null");
        }
        this.value = value;
        this.color = color;
    }

    public Integer getValue() {
        return value.getIntegerValue();
    }

    public Integer getColor() {
        return color.getIntegerValue();
    }

    public CardValue getCardValue() {
        return value;
    }

    public CardColor getCardColor() {
        return color;
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        if (color != other.color) {
            return false;
        }
        if (value != other.value) {
            return false;
        }
        return true;
    }

	@Override
	public int compareTo(Card arg0) {
		int compareTo = color.compareTo(arg0.color);
		if(compareTo == 0){
			return value.compareTo(arg0.value);
		}
		return compareTo;
	}

}
