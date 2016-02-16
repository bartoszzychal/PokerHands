package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFileParser {
	
	
	private static final String SPACE = " ";
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	
	public Boolean prepareParser(String file) throws IOException{
		this.fileReader = new FileReader(file);
		this.bufferedReader = new BufferedReader(fileReader);		
		return bufferedReader.ready();
	}
		
	public ArrayList<Hand> readNextRound() throws IOException{
		String data= bufferedReader.readLine();
		
		ArrayList<String> cards = new ArrayList<>(Arrays.asList(data.split(SPACE)));
		
		ArrayList<String> first = new ArrayList<>(cards.subList(0, 5));
		ArrayList<String> second = new ArrayList<>(cards.subList(5, 10));
		
		Hand firstHand = getHand(first);
		Hand secondHand = getHand(second);
		
		ArrayList<Hand> nextRound = new ArrayList<>();
		
		nextRound.add(firstHand);
		nextRound.add(secondHand);
		
		return nextRound;
	}
	
	private Hand getHand(ArrayList<String> handStr) {
		Hand hand = new Hand();
		for (String cardStr : handStr) {
			Card card = CardParser.parseString(cardStr);
			hand.addCard(card);
		}
		return hand;
	}

	public void close(){
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
