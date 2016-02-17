package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class HandTest {

	@Test
	public void shouldTwoPairFirst44Second33() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("3D"));
		hand.addCard(CardParser.parseString("4S"));
		hand.addCard(CardParser.parseString("4H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);
		//when

		List<Entry<CardValue, Integer>> listAppearance = hand.getSortedByAppearanceAndCardValueEntryList();
		CardValue valueOfHigherPair = listAppearance.get(0).getKey();
		CardValue valueOfLowerPair = listAppearance.get(1).getKey();
		//then
		assertTrue(CardValue.FOUR.equals(valueOfHigherPair)&&CardValue.THREE.equals(valueOfLowerPair));
	}
	
	
}
