package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PokerHandTest {

	@Test
	public void shouldWinFirstHandWithHigherCard() throws IOException {
		//given
		String file = "poker_win.txt";
		PokerHand hand = new PokerHand(file);
		//when
		hand.nextRound();
		hand.nextRound();
		hand.nextRound();
		Boolean winner = hand.analyze();
		//then
		assertTrue(winner);
	}

}
