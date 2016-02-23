package com.capgemini.pokerHands;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class HandAnalyzer {

	private static final int POKER = 9;
	private static final int FOUR = 8;
	private static final int FULLHOUSE = 7;
	private static final int FLUSH = 6;
	private static final int STRAIGHT = 5;
	private static final int THREE_OF_KIND = 4;
	private static final int TWO_PAIRS = 3;
	private static final int ONE_PAIR = 2;

	private static final int FIVE_DIFFERENT_VALUE_CARD = 5;
	private static final int FOUR_DIFFERENT_VALUE_CARD = 4;
	private static final int THREE_DIFFERENT_VALUE_CARD = 3;
	private static final int FOUR_CARD_THE_SAME_VALUE = 4;
	private static final int THREE_CARD_THE_SAME_VALUE = 3;
	private static final int TWO_CARD_THE_SAME_VALUE = 2;
	private static final int DIFFERENCE_BEETWEEN_VALUE_FIRST_CARD_AND_VALUE_LAST_CARD_IS_FOUR = 4;

	public static Integer getScoreForHand(Hand hand) {
		int score = 0;
		if (isPair(hand)) {
			score = ONE_PAIR;
		} else if (isTwoPairs(hand)) {
			score = TWO_PAIRS;
		} else if (isThreeOfKind(hand)) {
			score = THREE_OF_KIND;
		} else if (isFullHouse(hand)) {
			score = FULLHOUSE;
		} else if (isFour(hand)) {
			score = FOUR;
		} else if (isStraight(hand) && isFlush(hand)) {
			score = POKER;
		} else if (isStraight(hand)) {
			score = STRAIGHT;
		} else if (isFlush(hand)) {
			score = FLUSH;
		}
		return score;
	}

	public static int findHigherCard(Hand hand, Hand secondHand) {
		Iterator<Entry<CardValue, Integer>> iteratorHand = hand.getListAppearanceCardValue().iterator();
		Iterator<Entry<CardValue, Integer>> iteratorSecondHand = secondHand.getListAppearanceCardValue().iterator();
		while (iteratorHand.hasNext() && iteratorSecondHand.hasNext()) {
			int compareValue = iteratorHand.next().getKey().getIntegerValue()
					.compareTo(iteratorSecondHand.next().getKey().getIntegerValue());
			if (compareValue != 0) {
				return compareValue;
			}
		}
		return 0;
	}

	private static boolean isFour(Hand hand) {
		return hand.getListAppearanceCardValue().get(0).getValue() == FOUR_CARD_THE_SAME_VALUE;
	}

	private static boolean isFullHouse(Hand hand) {
		List<Entry<CardValue, Integer>> listAppearance = hand.getListAppearanceCardValue();
		return listAppearance.size() == TWO_CARD_THE_SAME_VALUE
				&& listAppearance.get(0).getValue() == THREE_CARD_THE_SAME_VALUE;
	}

	private static boolean isFlush(Hand hand) {
		Integer color = hand.getCardList().get(0).getColor();
		return hand.getCardList().stream().allMatch((card)->card.getColor().equals(color));
	}

	private static boolean isStraight(Hand hand) {
		return (hand.getCardList().getFirst().getValue() - hand.getCardList().getLast()
				.getValue() == DIFFERENCE_BEETWEEN_VALUE_FIRST_CARD_AND_VALUE_LAST_CARD_IS_FOUR)
				&& (hand.getListAppearanceCardValue().size() == FIVE_DIFFERENT_VALUE_CARD);
	}

	private static boolean isThreeOfKind(Hand hand) {
		return hand.getListAppearanceCardValue().get(0).getValue().equals(THREE_CARD_THE_SAME_VALUE)
				&& hand.getListAppearanceCardValue().size() == THREE_DIFFERENT_VALUE_CARD;
	}

	private static boolean isTwoPairs(Hand hand) {
		return hand.getListAppearanceCardValue().get(0).getValue().equals(TWO_CARD_THE_SAME_VALUE)
				&& hand.getListAppearanceCardValue().get(1).getValue().equals(TWO_CARD_THE_SAME_VALUE);
	}

	private static boolean isPair(Hand hand) {
		return hand.getListAppearanceCardValue().size() == FOUR_DIFFERENT_VALUE_CARD;
	}
}
