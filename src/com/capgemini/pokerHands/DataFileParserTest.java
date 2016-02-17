package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class DataFileParserTest {

	@Test
	public void shouldHasAccessToFile() throws IOException, FileNotFoundException {
		DataFileParser dataFileParser = new DataFileParser();

		// given
		boolean prepareReader = false;
		boolean prepareReaderExpected = true;
		// when
		prepareReader = dataFileParser.prepareParser("test_files/poker.txt");

		// then
		assertEquals(prepareReaderExpected, prepareReader);

	}

	@Test
	public void shouldHasAccessToFileButFileIsEmpty() throws IOException, FileNotFoundException {
		DataFileParser dataFileReader = new DataFileParser();

		// given
		boolean prepareReader = true;
		boolean prepareReaderExpected = false;
		// when
		prepareReader = dataFileReader.prepareParser("test_files/poker_empty_file.txt");

		// then
		assertEquals(prepareReaderExpected, prepareReader);

	}

	@Test(expected = FileNotFoundException.class)
	public void shouldThrowAFileNotFoundExceptionWhenPrepareFile() throws IOException, FileNotFoundException {
		DataFileParser dataFileReader = new DataFileParser();
		dataFileReader.prepareParser("poke.txt");
	}

	@Test
	public void shouldReturnAListWithTwoHands() throws FileNotFoundException, IOException {
		// given 8C TS KC 9H 4S 7D 2S 5D 3S AC
		Hand first = new Hand();
		first.addCard(new Card(CardValue.EIGHT, CardColor.CLUBS));
		first.addCard(new Card(CardValue.TEEN,CardColor.SPADES));
		first.addCard(new Card(CardValue.KING,CardColor.CLUBS));
		first.addCard(new Card(CardValue.NINE,CardColor.HEARTS));
		first.addCard(new Card(CardValue.FOUR,CardColor.SPADES));

		Hand second = new Hand();
		second.addCard(new Card(CardValue.SEVEN, CardColor.DIAMONDS));
		second.addCard(new Card(CardValue.TWO, CardColor.SPADES));
		second.addCard(new Card(CardValue.FIVE, CardColor.DIAMONDS));
		second.addCard(new Card(CardValue.THREE, CardColor.SPADES));
		second.addCard(new Card(CardValue.ACE, CardColor.CLUBS));

		ArrayList<Hand> expected_hands = new ArrayList<>();
		expected_hands.add(first);
		expected_hands.add(second);

		DataFileParser dataFileParser = new DataFileParser();
		dataFileParser.prepareParser("test_files/two_hand.txt");

		// when
		ArrayList<Hand> readNextRound = dataFileParser.readNextRound();

		// then
		assertArrayEquals(expected_hands.toArray(), readNextRound.toArray());
	}

}
