package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Hand implements Comparable<Hand>{
		
	private final int INITIAL_APPEARANCE_COUNTER = 1;
	
	private LinkedList<Card> hand = new LinkedList<>();
	private List<Map.Entry<CardValue,Integer>> listAppearance;
	
	
	public void prepareHandToCompare() {
		sort();
		createSortByAppearanceEntryList();
	}

	private void sort() {
		hand.sort((c1,c2)->c2.getValue().compareTo(c1.getValue()));
	}
	
	private void createSortByAppearanceEntryList() {
		Map<CardValue, Integer> mapAppearance = createAppearanceMap();
		listAppearance = new ArrayList<>(mapAppearance.entrySet());
		listAppearance.sort((e1,e2)->{
			 int compareAppearance = e2.getValue().compareTo(e1.getValue());
			 if(compareAppearance == 0){
				 return e2.getKey().compareTo(e1.getKey());
			 }
			 return compareAppearance;
		});
	}
	
	private Map<CardValue, Integer> createAppearanceMap() {
		Map<CardValue,Integer> mapAppearance = new TreeMap<>(); 
		hand.forEach((card)->{
			CardValue value = card.getCardValue();
			if(mapAppearance.containsKey(value)){
				Integer appearance = mapAppearance.get(value);
				appearance++;
				mapAppearance.replace(value, appearance);
			}else{
				mapAppearance.put(value, INITIAL_APPEARANCE_COUNTER);
			}
		});
		return mapAppearance;
	}
	
	public List<Map.Entry<CardValue, Integer>> getListAppearance() {
		return listAppearance;
	}
	
	public LinkedList<Card> getCardList() {
		return hand;
	}

	public void addCard(Card card){
		hand.add(card);
	}
	
	@Override
	public int compareTo(Hand secondHand) {
		prepareHandToCompare();
		secondHand.prepareHandToCompare();
			
		int compareHand = HandAnalyzer.analyzeHand(this).compareTo(HandAnalyzer.analyzeHand(secondHand));
		if(compareHand == 0){
			return HandAnalyzer.findHigherCard(this,secondHand);
		}
		return compareHand;
	}

}