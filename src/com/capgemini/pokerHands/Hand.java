package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Hand implements Comparable<Hand> {

    private final int INITIAL_APPEARANCE_COUNTER = 1;

    private final LinkedList<Card> listCards = new LinkedList<>();
    private final List<Map.Entry<CardValue, Integer>> listAppearanceCardValue = new ArrayList<>();

    @Override
    public int compareTo(Hand secondHand) {
        prepareHandsToCompare(secondHand);
        if (HandAnalyzer.getScoreForHand(this).compareTo(HandAnalyzer.getScoreForHand(secondHand)) == 0) {
            return HandAnalyzer.findHigherCard(this, secondHand);
        }
        return HandAnalyzer.getScoreForHand(this).compareTo(HandAnalyzer.getScoreForHand(secondHand));
    }

    private void prepareHandsToCompare(Hand secondHand) {
        if (listAppearanceCardValue.isEmpty()) {
            prepareHandToCompare();
        }
        if (secondHand.getListAppearanceCardValue().isEmpty()) {
            secondHand.prepareHandToCompare();
        }
    }

    private void prepareHandToCompare() {
        sortCardsByValue();
        createListAppearanceCardValue();
        sortListAppearenceCardValueByAppearenceAndByValue();
    }

    private void sortCardsByValue() {
        listCards.sort((c1, c2) -> c2.getValue().compareTo(c1.getValue()));
    }

    private void createListAppearanceCardValue() {
        Map<CardValue, Integer> mapAppearance = createMapAppearance();
        listAppearanceCardValue.addAll(mapAppearance.entrySet());
    }

    private Map<CardValue, Integer> createMapAppearance() {
        Map<CardValue, Integer> mapAppearance = new TreeMap<>();
        listCards.forEach((card) -> {
            CardValue value = card.getCardValue();
            if (mapAppearance.containsKey(value)) {
                Integer appearance = mapAppearance.get(value);
                appearance += 1;
                mapAppearance.replace(value, appearance);
            }
            else {
                mapAppearance.put(value, INITIAL_APPEARANCE_COUNTER);
            }
        });
        return mapAppearance;
    }

    private void sortListAppearenceCardValueByAppearenceAndByValue() {
        listAppearanceCardValue.sort((e1, e2) -> {
            int compareAppearance = e2.getValue().compareTo(e1.getValue());
            if (compareAppearance == 0) {
                int compareCardValue = e2.getKey().compareTo(e1.getKey());
                return compareCardValue;
            }
            return compareAppearance;
        });
    }

    public List<Map.Entry<CardValue, Integer>> getListAppearanceCardValue() {
        return listAppearanceCardValue;
    }

    public LinkedList<Card> getCardList() {
        return listCards;
    }

    public void addCard(Card card) {
        listCards.add(card);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listCards == null) ? 0 : listCards.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Hand other = (Hand) obj;
        if (listCards == null) {
            if (other.listCards != null) {
                return false;
            }
        }
        else if (!listCards.equals(other.listCards)) {
            return false;
        }
        return true;
    }

}