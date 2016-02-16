package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandAnalyzerTest {

	
	@Test
	public void shouldBePoker() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("4C"));
		hand.addCard(CardParser.parseString("5C"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer	poker = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(11), poker);
	}
	
	@Test
	public void shouldBeFour() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("2S"));
		hand.addCard(CardParser.parseString("2H"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer four = HandAnalyzer.analyzeHand(hand);
		
		//then
		assertEquals(Integer.valueOf(8), four);
	}
	
	@Test
	public void shouldBeFullHouse() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("6S"));
		hand.addCard(CardParser.parseString("6H"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer fullHouse = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(7), fullHouse);
	}
	@Test
	public void shouldBeFlush() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("8C"));
		hand.addCard(CardParser.parseString("TC"));
		hand.addCard(CardParser.parseString("KC"));
		hand.addCard(CardParser.parseString("9C"));
		hand.addCard(CardParser.parseString("4C"));
		hand.prepareHandToCompare();
		//when
		Integer flush = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(6), flush);
	}
		
	@Test
	public void shouldBeStraight() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("4D"));
		hand.addCard(CardParser.parseString("5C"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer straight = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(5), straight);
	}
	
	@Test
	public void shouldBeThreeOfKind() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3D"));
		hand.addCard(CardParser.parseString("6S"));
		hand.addCard(CardParser.parseString("6H"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer three = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(4), three);
	}
	
	@Test
	public void shouldBeTwoPair() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("3S"));
		hand.addCard(CardParser.parseString("3H"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer twoPair = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(3), twoPair);
	}
	
	@Test
	public void shouldBeOnePair() {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("4S"));
		hand.addCard(CardParser.parseString("5H"));
		hand.addCard(CardParser.parseString("6C"));
		hand.prepareHandToCompare();
		//when
		Integer onePair = HandAnalyzer.analyzeHand(hand);
		//then
		assertEquals(Integer.valueOf(2), onePair);
	}

}
