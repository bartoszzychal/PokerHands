package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void shouldBeValue2andColor1ForDueceDiamonds() {
		//given
		Integer value_ex = CardValue.TWO.getCardValue();
		Integer color_ex = CardColor.CLUBS.getCardColor();
	
		//when
		Card card = new Card(CardValue.TWO,CardColor.CLUBS);
		//then
		assertTrue(card.getColor()==color_ex && card.getValue()==value_ex);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldIllegalArgumentExceptionForIllegallValue() {
	
		//when
		new Card(null,CardColor.CLUBS);
	}

	@Test(expected = ClassCastException.class)
	public void shouldIllegalArgumentExceptionForIllegallColor() {
		
		//when
		Integer integer = new Integer(15);
		Object object = integer;
		new Card(CardValue.ACE,(CardColor)object);
	}

}
