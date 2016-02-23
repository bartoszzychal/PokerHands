package com.capgemini.pokerHands;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class HandAnalyzerTest {

	
	@Test
	public void shouldBePoker() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("4C"));
		hand.addCard(CardParser.parseString("5C"));
		hand.addCard(CardParser.parseString("6C"));
		
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);
		//when
		Integer	poker = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(9), poker);
	}
	
	@Test
	public void shouldBeFour() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("2S"));
		hand.addCard(CardParser.parseString("2H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer four = HandAnalyzer.getScoreForHand(hand);
		
		//then
		assertEquals(Integer.valueOf(8), four);
	}
	
	@Test
	public void shouldBeFullHouse() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("6S"));
		hand.addCard(CardParser.parseString("6H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer fullHouse = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(7), fullHouse);
	}
	@Test
	public void shouldBeFlush() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("8C"));
		hand.addCard(CardParser.parseString("TC"));
		hand.addCard(CardParser.parseString("KC"));
		hand.addCard(CardParser.parseString("9C"));
		hand.addCard(CardParser.parseString("4C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer flush = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(6), flush);
	}
		
	@Test
	public void shouldBeStraight() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3C"));
		hand.addCard(CardParser.parseString("4D"));
		hand.addCard(CardParser.parseString("5C"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer straight = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(5), straight);
	}
	
	@Test
	public void shouldBeThreeOfKind() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("3D"));
		hand.addCard(CardParser.parseString("6S"));
		hand.addCard(CardParser.parseString("6H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer three = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(4), three);
	}
	
	@Test
	public void shouldBeTwoPair() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("3S"));
		hand.addCard(CardParser.parseString("3H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);
		//when
		Integer twoPair = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(3), twoPair);
	}
	
	@Test
	public void shouldBeOnePair() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		//given
		Hand hand = new Hand();
		hand.addCard(CardParser.parseString("2C"));
		hand.addCard(CardParser.parseString("2D"));
		hand.addCard(CardParser.parseString("4S"));
		hand.addCard(CardParser.parseString("5H"));
		hand.addCard(CardParser.parseString("6C"));
		
		Method method = Class.forName("com.capgemini.pokerHands.Hand").getDeclaredMethod("prepareHandToCompare");
		method.setAccessible(true);
		method.invoke(hand);		//when
		Integer onePair = HandAnalyzer.getScoreForHand(hand);
		//then
		assertEquals(Integer.valueOf(2), onePair);
	}

}
