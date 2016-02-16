package com.capgemini.pokerHands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PokerHand {

	private DataFileParser parser = new DataFileParser();
	private ArrayList<Hand> round;
	private Hand handFirst;
	private Hand handSecond;

	public PokerHand(String file) throws IOException {
		parser.prepareParser(file);
	}

	private Boolean compareAppearanceAndValueOfHands() {

		Iterator<Entry<CardValue, Integer>> iteratorFirstHand = handFirst.createAppearanceMap().entrySet().iterator();
		Iterator<Entry<CardValue, Integer>> iteratorSecondHand = handSecond.createAppearanceMap().entrySet().iterator();

		while (iteratorFirstHand.hasNext() && iteratorSecondHand.hasNext()) {
			Entry<CardValue, Integer> first = iteratorFirstHand.next();
			Entry<CardValue, Integer> second = iteratorSecondHand.next();
			Boolean compareApperance = compareApperance(first, second);
			if (compareApperance != null) {
				return compareApperance;
			}
		}
		return false;
	}

	private Boolean compareApperance(Entry<CardValue, Integer> first, Entry<CardValue, Integer> second) {
		Boolean compareAppearance = compareValue(first.getValue().compareTo(second.getValue()));
		if(compareAppearance == null){
			return compareValue(first.getKey().compareTo(second.getKey()));
		}
		return compareAppearance;
	}

	private Boolean compareValue(int compareValue) {
		if (compareValue > 0) {
			return true;
		} else if (compareValue < 0) {
			return false;
		}
		return null;
	}

	private void readNextRound() throws IOException {
			round = parser.readNextRound();
			handFirst = round.get(0);
			handSecond = round.get(1);
	}

	public void nextRound() throws IOException {
		readNextRound();
	}

	public Boolean analyze() {
		Boolean compareAppearanceAndValueOfHands = compareAppearanceAndValueOfHands();
		return compareAppearanceAndValueOfHands;
	}

}
