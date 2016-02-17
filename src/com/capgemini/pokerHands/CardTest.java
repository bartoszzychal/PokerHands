package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void shouldBeValue2andColor1ForDueceDiamonds() {
		//given
		Integer value_ex = CardValue.TWO.getIntegerValue();
		Integer color_ex = CardColor.CLUBS.getIntegerValue();
	
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

}
