package com.capgemini.pokerHands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {

    @Test
    public void shouldBeValue2andColor1ForDueceDiamonds() {
        // given
        Integer value_ex = CardValue.TWO.getIntegerValue();
        Integer color_ex = CardColor.C.getIntegerValue();

        // when
        Card card = new Card(CardValue.TWO, CardColor.C);
        // then
        assertTrue(card.getColor() == color_ex && card.getValue() == value_ex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldIllegalArgumentExceptionForIllegallValue() {

        // when
        new Card(null, CardColor.C);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldIllegalArgumentExceptionForIllegallColor() {
    	
    	// when
    	new Card(CardValue.ACE,null);
    }
}
