package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardParserTest {

	@Test
	public void shouldBeValue2andColor1ForDueceDiamonds() {
		//given
		String dueceDiamonds = "2D";
		//when
		Card parseString = CardParser.parseString(dueceDiamonds);
		//then
		assertTrue(parseString.getValue() == 2 && parseString.getColor() == 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldIllegalArgumentExceptionForIllegallValue() {
		//given
		String card = "1D";
		//when
		CardParser.parseString(card);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldIllegalArgumentExceptionForIllegallColor() {
		//given
		String card = "1O";
		//when
		CardParser.parseString(card);
	}
}
