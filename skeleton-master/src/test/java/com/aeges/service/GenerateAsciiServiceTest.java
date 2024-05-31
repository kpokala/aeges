package com.aeges.service;

import com.aeges.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateAsciiServiceTest {

    GenerateAsciiService generateAsciiService = new GenerateAsciiService();

    @Test
    public void checkInputIsAsExpected() throws InvalidInputException {
        char[] charArray = generateAsciiService.evaluateOddSequences("6521714069616518831033");
        String text = String.copyValueOf(charArray);
        assertTrue(text.equals("AGEAS!"));
    }

    @Test
    public void checkInputWithOddPairs() throws InvalidInputException {
        char[] charArray = generateAsciiService.evaluateOddSequences("6521324356");
        String text = String.copyValueOf(charArray);
        assertTrue(text!=null);
        assertTrue(text.length()==3);
    }

    @Test
    public void checkInputWithEvenPairs() throws InvalidInputException {
        char[] charArray = generateAsciiService.evaluateOddSequences("652132");
        String text = String.copyValueOf(charArray);
        assertTrue(text.length()==2);
    }

    @Test
    public void shouldNotContainAlphabets()  {
        InvalidInputException thrown = assertThrows(
                InvalidInputException.class,
                () -> generateAsciiService.evaluateOddSequences("A521714069B16518831033"),
                "Contains Alphabets"
        );

        assertTrue(thrown.getMessage().contains("contains Alphabets"));
    }

}