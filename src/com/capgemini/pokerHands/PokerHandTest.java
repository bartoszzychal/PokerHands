package com.capgemini.pokerHands;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class PokerHandTest {

	@Test
	public void shouldWinFirstHandWithHigherCard() throws IOException {
		//given
		String file = "poker.txt";
		
		PokerHand poker = new PokerHand(file);
		//when
		int winner = poker.getWinner();
		//then
		assertEquals(-248,winner);
	}
	@Test
	public void shouldWinFirst45Times() throws IOException {
		//given
		String testfile = "test_file.txt";
		
		PokerHand poker = new PokerHand(testfile);
		//when
		int winner = poker.getWinner();
		//then
		assertEquals(46,winner);
	}
	@Test
	public void shouldWinFirstFourTimes() throws IOException {
		//given
		String testfile = "four.txt";
		
		PokerHand poker = new PokerHand(testfile);
		//when
		int winner = poker.getWinner();
		//then
		assertEquals(4,winner);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void shouldWBeExceptionFileNotFound() throws IOException {
		new PokerHand("");
	}
	@Test
	public void shouldBeIOException() throws IOException {
		PokerHand pokerHand = new PokerHand("poker_empty_file.txt");
		int winner = pokerHand.getWinner();
		assertEquals(0, winner);
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldBeIllegalArgumentExceptionForColor() throws IOException {
		PokerHand pokerHand = new PokerHand("exception_test_illegal_color.txt");
		pokerHand.getWinner();
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldBeIllegalArgumentExceptionForValue() throws IOException {
		PokerHand pokerHand = new PokerHand("exception_test_illegal_value.txt");
		pokerHand.getWinner();
	}
	


}
