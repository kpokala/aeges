package com.aeges.service;

import com.aeges.exception.InvalidInputException;

import java.util.concurrent.atomic.AtomicBoolean;

public class GenerateAsciiService {


    public char[] evaluateOddSequences(String input) throws InvalidInputException {

        AtomicBoolean exception = new AtomicBoolean(false);
        input.chars().forEach(c -> {
            if ((char) c < 48 || (char) c > 57) {
                exception.set(true);
            }
        });
        if (exception.get() == true) {
            throw new InvalidInputException("contains Alphabets");
        }

        int inputTextPairSize = input.length() % 2 == 0 ? input.length() / 2 : (input.length() / 2) + 1;
        int oddSequenceArrayLength = inputTextPairSize % 2 == 0 ? inputTextPairSize / 2 : (inputTextPairSize / 2) + 1;
        char[] oddSequenceArray = new char[oddSequenceArrayLength];
        int oddSequenceArrayIndex = 0;
        int loopIndex = 1;
        int substringStep = 0;
        while (loopIndex != inputTextPairSize + 1) {
            //if the input string length is an odd number, then the last digit goes as a single character
            if (input.length() % 2 != 0 && substringStep == input.length() - 1) {
                oddSequenceArray[oddSequenceArrayIndex] = (char) (Integer.parseInt(input.substring(substringStep, substringStep + 1)));
            } else {
                //take the odd sequence items only 1,3,5,7...
                if (loopIndex % 2 != 0) {
                    oddSequenceArray[oddSequenceArrayIndex] = (char) (Integer.parseInt(input.substring(substringStep, substringStep + 2)));
                    oddSequenceArrayIndex++;
                }
                //increment the substring by 2
                substringStep = substringStep + 2;
            }
            loopIndex++;
        }
        return oddSequenceArray;
    }

}