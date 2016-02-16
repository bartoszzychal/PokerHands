package com.capgemini.pokerHands;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class HandAnalyzer {

	private static final int FOUR = 8;
	private static final int FULLHOUSE = 7;
	private static final int FLUSH = 6;
	private static final int STRAIGHT = 5;
	private static final int THREE_OF_KIND = 4;
	private static final int TWO_PAIRS = 3;
	private static final int ONE_PAIR = 2;
	private static final int NO_CONDITION = 0;

	public static Integer analyzeHand(Hand hand) {
		return isFlush(hand) 
				+ isFour(hand) 
				+ isFullHouse(hand) 
				+ isOnePair(hand) 
				+ isStraight(hand)
				+ isThreeOfKind(hand) 
				+ isTwoPairs(hand);
	}
	
	public static int findHigherCard(Hand hand, Hand secondHand) {
		Iterator<Entry<CardValue, Integer>> iteratorHand = hand.getListAppearance().iterator();
		Iterator<Entry<CardValue, Integer>> iteratorSecondHand = secondHand.getListAppearance().iterator();
		while(iteratorHand.hasNext()&&iteratorSecondHand.hasNext()){
			int compareTo = iteratorHand.next().getKey().intValue().compareTo(iteratorSecondHand.next().getKey().intValue());
			if(compareTo!=0){
				return compareTo;
			}
		}
		return 0;
	}
	
	private static int isFour(Hand hand) {
		if (hand.getListAppearance().get(0).getValue() == 4) {
			return FOUR;
		}
		return NO_CONDITION;
	}

	private static int isFullHouse(Hand hand) {
		List<Entry<CardValue, Integer>> listAppearance = hand.getListAppearance();
		if (listAppearance.size() == 2 && listAppearance.get(0).getValue() == 3) {
			return FULLHOUSE;
		}
		return NO_CONDITION;
	}

	private static int isFlush(Hand hand) {
		Integer color = hand.getCardList().get(0).getColor();
		for (Card card : hand.getCardList()) {
			if (!card.getColor().equals(color)) {
				return NO_CONDITION;
			}
		}
		return FLUSH;
	}

	private static int isStraight(Hand hand) {
		if ((hand.getCardList().getFirst().getValue() - hand.getCardList().getLast().getValue() == 4)
				&& (hand.getListAppearance().size() == 5)) {
			return STRAIGHT;
		}
		return NO_CONDITION;
	}

	private static int isThreeOfKind(Hand hand) {
		if (hand.getListAppearance().get(0).getValue().equals(3) && hand.getListAppearance().size() == 3) {
			return THREE_OF_KIND;
		}
		return NO_CONDITION;
	}

	private static int isTwoPairs(Hand hand) {
		if (hand.getListAppearance().get(0).getValue().equals(2)
				&& hand.getListAppearance().get(1).getValue().equals(2)) {
			return TWO_PAIRS;
		}
		return NO_CONDITION;
	}

	private static int isOnePair(Hand hand) {
		if (hand.getListAppearance().size() == 4) {
			return ONE_PAIR;
		}
		return NO_CONDITION;
	}

}
