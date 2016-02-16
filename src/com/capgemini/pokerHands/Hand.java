package com.capgemini.pokerHands;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Hand{
		
	private final int INITIAL_APPEARANCE_COUNTER = 1;

	private LinkedList<Card> hand = new LinkedList<>();
	
	public boolean isColor(){
		Integer color = hand.get(0).getColor();
		for(Card card :hand){
			if(!card.getColor().equals(color)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isStrit(){
		sort();
		return  hand.getFirst().getValue() - hand.getLast().getValue() == 4;
	}
	
	public boolean isPoker(){
		return isColor()&&isStrit();
	}
	
	private void sort() {
		hand.sort((c1,c2)->c2.getValue().compareTo(c1.getValue()));
	}
	
	private Comparator<CardValue> sortByGreater = new Comparator<CardValue>() {
		@Override
		public int compare(CardValue value1, CardValue value2) {
			return value2.getCardValue().compareTo(value1.getCardValue());
		}
	
	};
	
	public Map<CardValue, Integer> createAppearanceMap() {
		
		Map<CardValue, Integer> map = new TreeMap<>(sortByGreater);
		
		hand.forEach((card)->{
			CardValue value = card.getCardValue();
			if(map.containsKey(value)){
				Integer appearance = map.get(value);
				appearance++;
				map.replace(value, appearance);
			}else{
				map.put(value, INITIAL_APPEARANCE_COUNTER);
			}
		});
		return map;
	}
	
	public void addCard(Card card){
		hand.add(card);
	}
		
}
