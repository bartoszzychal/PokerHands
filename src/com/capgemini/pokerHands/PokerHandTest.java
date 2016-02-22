package com.capgemini.pokerHands;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

// REVIEW bzychal - failing tests here
public class PokerHandTest {

    @Test
    public void shouldFirstPlayerWon376Times() throws IOException {
        // given
        String file = "test_files/poker.txt";

        PokerHand poker = new PokerHand(file);
        // when
        int winner = poker.getNumberOfWonRoundByFirstPlayer();
        // then
        assertEquals(376, winner);
    }

    @Test
    public void shouldFirstPlayerWon45Times() throws IOException {
        // given
        String testfile = "test_files/test_file.txt";

        PokerHand poker = new PokerHand(testfile);
        // when
        int winner = poker.getNumberOfWonRoundByFirstPlayer();
        // then
        assertEquals(46, winner);
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldWBeExceptionFileNotFound() throws IOException {
        new PokerHand("");
    }

    @Test
    public void shouldBeIOException() throws IOException {
        PokerHand pokerHand = new PokerHand("test_files/poker_empty_file.txt");
        int winner = pokerHand.getNumberOfWonRoundByFirstPlayer();
        assertEquals(0, winner);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionForColor() throws IOException {
        PokerHand pokerHand = new PokerHand("test_files/exception_test_illegal_color.txt");
        pokerHand.getNumberOfWonRoundByFirstPlayer();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionForValue() throws IOException {
        PokerHand pokerHand = new PokerHand("test_files/exception_test_illegal_value.txt");
        pokerHand.getNumberOfWonRoundByFirstPlayer();
    }

}
