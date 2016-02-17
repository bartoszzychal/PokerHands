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

	private static final int FIVE_DIFFERENT_VALUE_CARD = 5;
	private static final int FOUR_DIFFERENT_VALUE_CARD = 4;
	private static final int THREE_DIFFERENT_VALUE_CARD = 3;
	private static final int FOUR_CARD_THE_SAME_VALUE = 4;
	private static final int THREE_CARD_THE_SAME_VALUE = 3;
	private static final int TWO_CARD_THE_SAME_VALUE = 2;
	private static final int DIFFERENCE_BEETWEEN_VALUE_FIRST_CARD_AND_VALUE_LAST_CARD_IS_FOUR = 4;
	
	public static Integer getScoreForHand(Hand hand) {
		return getScoreForFlush(hand) 
				+ getScoreForStraight(hand)
				+ getScoreForFour(hand) 
				+ getScoreForFullHouse(hand) 
				+ getScoreForThreeOfKind(hand) 
				+ getScoreForTwoPairs(hand)
				+ getScoreForOnePair(hand); 
	}
	
	public static int findHigherCard(Hand hand, Hand secondHand) {
		Iterator<Entry<CardValue, Integer>> iteratorHand = hand.getSortedByAppearanceAndCardValueEntryList().iterator();
		Iterator<Entry<CardValue, Integer>> iteratorSecondHand = secondHand.getSortedByAppearanceAndCardValueEntryList().iterator();
		while(iteratorHand.hasNext()&&iteratorSecondHand.hasNext()){
			int compareValue = iteratorHand.next().getKey().getIntegerValue().compareTo(iteratorSecondHand.next().getKey().getIntegerValue());
			if(compareValue!=0){
				return compareValue;
			}
		}
		return 0;
	}
	
	private static int getScoreForFour(Hand hand) {
		if (isFour(hand)) {
			return FOUR;
		}
		return NO_CONDITION;
	}

	private static boolean isFour(Hand hand) {
		return hand.getSortedByAppearanceAndCardValueEntryList().get(0).getValue() == FOUR_CARD_THE_SAME_VALUE;
	}

	private static int getScoreForFullHouse(Hand hand) {
		if (isFullHouse(hand)) {
			return FULLHOUSE;
		}
		return NO_CONDITION;
	}

	private static boolean isFullHouse(Hand hand) {
		List<Entry<CardValue, Integer>> listAppearance = hand.getSortedByAppearanceAndCardValueEntryList();
		return listAppearance.size() == TWO_CARD_THE_SAME_VALUE && listAppearance.get(0).getValue() == THREE_CARD_THE_SAME_VALUE;
	}
	
	private static int getScoreForFlush(Hand hand) {
		if(isFlush(hand)) {
			return FLUSH;
		}
		return NO_CONDITION ;
	}
	
	private static boolean isFlush(Hand hand){
		Integer color = hand.getCardList().get(0).getColor();
		for (Card card : hand.getCardList()) {
			if (!card.getColor().equals(color)) {
				return false;
			}
		}
		return true;
	}

	private static int getScoreForStraight(Hand hand) {
		if (isStraight(hand)) {
			return STRAIGHT;
		}
		return NO_CONDITION;
	}

	private static boolean isStraight(Hand hand) {
		return (hand.getCardList().getFirst().getValue() - hand.getCardList().getLast().getValue()
				== DIFFERENCE_BEETWEEN_VALUE_FIRST_CARD_AND_VALUE_LAST_CARD_IS_FOUR)
				&& (hand.getSortedByAppearanceAndCardValueEntryList().size() == FIVE_DIFFERENT_VALUE_CARD);
	}

	private static int getScoreForThreeOfKind(Hand hand) {
		if (isThreeOfKind(hand)) {
			return THREE_OF_KIND;
		}
		return NO_CONDITION;
	}

	private static boolean isThreeOfKind(Hand hand) {
		return hand.getSortedByAppearanceAndCardValueEntryList().get(0).getValue().equals(THREE_CARD_THE_SAME_VALUE) && hand.getSortedByAppearanceAndCardValueEntryList().size() == THREE_DIFFERENT_VALUE_CARD;
	}

	private static int getScoreForTwoPairs(Hand hand) {
		if (isTwoPairs(hand)) {
			return TWO_PAIRS;
		}
		return NO_CONDITION;
	}

	private static boolean isTwoPairs(Hand hand) {
		return hand.getSortedByAppearanceAndCardValueEntryList().get(0).getValue().equals(TWO_CARD_THE_SAME_VALUE)
				&& hand.getSortedByAppearanceAndCardValueEntryList().get(1).getValue().equals(TWO_CARD_THE_SAME_VALUE);
	}

	private static int getScoreForOnePair(Hand hand) {
		if (isPair(hand)) {
			return ONE_PAIR;
		}
		return NO_CONDITION;
	}

	private static boolean isPair(Hand hand) {
		return hand.getSortedByAppearanceAndCardValueEntryList().size() == FOUR_DIFFERENT_VALUE_CARD;
	}

}
