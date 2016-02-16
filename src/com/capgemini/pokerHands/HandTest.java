package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class HandTest {

	@Test
	public void shouldTwoPairFirst44Second33() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("3D"));
		hand.addCard(CardParser.parseString("4S"));
		hand.addCard(CardParser.parseString("4H"));
		hand.addCard(CardParser.parseString("6C"));
		//when
		hand.prepareHandToCompare();
		List<Entry<CardValue, Integer>> listAppearance = hand.getListAppearance();
		CardValue valueOfHigherPair = listAppearance.get(0).getKey();
		CardValue valueOfLowerPair = listAppearance.get(1).getKey();
		//then
		assertTrue(CardValue.FOUR.equals(valueOfHigherPair)&&CardValue.THREE.equals(valueOfLowerPair));
	}
	
	
}
