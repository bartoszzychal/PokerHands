package com.capgemini.pokerHands;

import java.io.IOException;
import java.util.List;

public class PokerHand {

	private final DataFileParser parser = new DataFileParser();
	// FIX REVIEW bzychal - please use List<Hand> as type
	private List<Hand> round;
	private Hand handFirst;
	private Hand handSecond;

	public PokerHand(String file) throws IOException {
		parser.prepareParser(file);
	}

	public int getNumberOfWonRoundByFirstPlayer() throws IOException {
		int numberOfRoundWonByFirstPlayer = 0;
		while (parser.ready()) {
			nextRound();
			if (getWinnerRound() > 0) {
				numberOfRoundWonByFirstPlayer++;
			}
		}
		return numberOfRoundWonByFirstPlayer;
	}

	private void nextRound() throws IOException {
		round = parser.readNextRound();
		handFirst = round.get(0);
		handSecond = round.get(1);
	}

	private int getWinnerRound() {
		return handFirst.compareTo(handSecond);
	}
}
