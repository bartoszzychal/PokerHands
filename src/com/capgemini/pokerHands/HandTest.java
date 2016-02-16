package com.capgemini.pokerHands;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class HandTest {

	@Test
	public void shouldBeTheSameColor() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("8C"));
		hand.addCard(CardParser.parseString("TC"));
		hand.addCard(CardParser.parseString("KC"));
		hand.addCard(CardParser.parseString("9C"));
		hand.addCard(CardParser.parseString("4C"));
		//when
		boolean allCardsAreTheSameColor = hand.isColor();
		//then
		assertEquals(true, allCardsAreTheSameColor);
	}
		
	@Test
	public void shouldBeStrit() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("4C"));
		hand.addCard(CardParser.parseString("5C"));
		hand.addCard(CardParser.parseString("6C"));
		//when
		boolean stepOneByOne = hand.isStrit();
		
		//then
		assertEquals(true, stepOneByOne);
	}

	@Test
	public void shouldMapOfAppearenceWithPairOfSix() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3D"));
		hand.addCard(CardParser.parseString("4C"));
		hand.addCard(CardParser.parseString("6C"));
		hand.addCard(CardParser.parseString("6C"));
		//when
		Comparator<CardValue> sortByGreater = new Comparator<CardValue>() {
			@Override
			public int compare(CardValue value1, CardValue value2) {
				return value2.getCardValue().compareTo(value1.getCardValue());
			}
		
		};
		Map<CardValue, Integer> map = new TreeMap<>(sortByGreater);
		
		map.put(CardValue.TWO, 1);
		map.put(CardValue.THREE, 1);
		map.put(CardValue.FOUR, 1);
		map.put(CardValue.SIX, 2);
		Map<CardValue, Integer> appearence = hand.createAppearanceMap();
		//then
		assertEquals(map.entrySet().toArray(), appearence.entrySet().toArray());
	}

}
