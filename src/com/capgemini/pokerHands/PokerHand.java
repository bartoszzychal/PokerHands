package com.capgemini.pokerHands;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class PokerHand {

	private DataFileParser parser = new DataFileParser();
	private ArrayList<Hand> round;
	private Hand handFirst;
	private Hand handSecond;

	public PokerHand(String file) throws IOException {
		parser.prepareParser(file);
	}

	public int getWinner() throws IOException{
		int winner = 0; //negative second , positive first
		while(parser.ready()){
			nextRound();
			winner+=getWinnerRound();
		}
		return winner;
	}
	
	private void nextRound() throws IOException {
		round = parser.readNextRound();
		handFirst = round.get(0);
		handSecond = round.get(1);
	}
	
	private int getWinnerRound(){
		return handFirst.compareTo(handSecond);
	}

	
}
